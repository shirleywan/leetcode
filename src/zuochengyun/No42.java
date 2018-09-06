package zuochengyun;

import zuochengyun.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断t1树是否包含t2树拓扑结构完全相同的子树
 * 时间复杂度O(M)
 */

class Solution42 {
    public boolean contains(TreeNode root , TreeNode head){
        if(root == null || head == null) {return false;}
        TreeNode node =null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node.left != null){queue.offer(node.left);}
            if(node.right != null){queue.offer(node.right);}
            if(node.value == head.value){break;}
        }
        return check(node,head);
    }
    public boolean check(TreeNode root , TreeNode head){
        if(root == null && head == null){return true;}
        boolean flag = false;
        if(root != null && head!= null){
            if(root.value == head.value ){
                flag = true;
            }
            else flag = false;
        }
        if((root == null && head != null) || (root != null && head == null)){flag = false;}
        return flag && check(root.left , head.left) && check(root.right ,head.right);
    }
}

public class No42 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);

        root.left = n1; root.right = n3;
        n1.right = n2;
        n3.left = n4; n3.right = n5;

        TreeNode head = new TreeNode(5);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(6);
        head.left = n6;//head.right = n7;
        
        Solution42 solution = new Solution42();
        System.out.println(solution.contains(root, head));

    }
}
