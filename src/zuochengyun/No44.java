package zuochengyun;

import zuochengyun.util.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 反转二叉树
 *
 */

class Solution44 {
    /**
     * 递归实现
     */
    public TreeNode reverseErCha(TreeNode root){
        if(root == null){return null;}

        TreeNode tmp = root.left;
        root.left = reverseErCha(root.right);
        root.right = reverseErCha(tmp);
        return root;
    }
    public ArrayList<Integer> pre(TreeNode root , ArrayList<Integer> list){
        if(root == null) return list;
        list.add(root.value);
        if(root.left != null){pre(root.left , list);}
        if(root.right != null){pre(root.right , list);}
        return list;
    }
}

public class No44 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);

        root.left = n1; root.right = n3;
        n1.left = n6; n1.right = n2;
        n3.left = n4; n3.right = n5;
        
        Solution44 solution = new Solution44();
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode result = solution.reverseErCha(root);
        System.out.println(solution.pre(result , list));

    }
}
