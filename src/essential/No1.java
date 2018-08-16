package leetcode;

import java.util.*;
import leetcode.util.TreeNode;

class Solution1 {
    public int run(TreeNode root) {
        if(root == null) {return 0;}
        if(root.left == null && root.right == null){return 1;}
        if(root.left == null && root.right != null){return run(root.right)+1 ;}
        if(root.left != null && root.right == null){return run(root.left)+1 ;}

        return 1+Math.min(run(root.left) , run(root.right));
    }
}
public class No1 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);

        root.left = n1; root.right = n3;
//        n1.right = n2;
        n3.left = n4; n3.right = n5;
        n5.right = n6;
        ArrayList<ArrayList<Integer>> totallist = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(new Solution1().run(root));
//        System.out.println(new Solution1().run(root));
    }
}
