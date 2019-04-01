package Tree;

import java.util.*;
import utils.*;

/**
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
class Solution101 {
    /**
     * recursive
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
     * Memory Usage: 40 MB, less than 8.12% of Java online submissions for Symmetric Tree.
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return isSame(root.left , root.right);
    }
    public boolean isSame(TreeNode root , TreeNode node){
        if(root == null && node == null){return true;}
        if((root == null && node != null) || (root != null && node == null)) return false;
        if(root.val != node.val){ return false;}
//        if((root.left ==null && root.right == null) && (node.left ==null && node.right == null)){ return true;}
//        if((root.left ==null && root.right != null) &&(node.left !=null && node.right == null)){
//            isSame(root.right , node.left);
//        }
//        if((root.left !=null && root.right == null) &&(node.left ==null && node.right != null)){
//            return isSame(root.left , node.right);
//        }
//        else{
        return isSame(root.left , node.right) && isSame(root.right, node.left);
//        }

    }

    /**
     * 用于测试
     */
    public boolean compare(TreeNode root , TreeNode node){
        if(root == null && node == null){return true;}
        if((root == null && node != null) || (root != null && node != null)) return false;
        if(root.val != node.val){ return false;}
        if(root.val == node.val) return true;

        return false;
    }
    /**
     * iterative -- two pointer
     */
    public boolean isSymmetric1(TreeNode root){
        if (root == null) return true;
        return false;
    }
}
public class No101isSymmetric {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(3);

        root.left  = n1;
        root.right = n2;
//        n1.left  = n3;
        n1.right = n4;
//        n2.left  = n5;
        n2.right = n6;
        TreeNode node = null;
        System.out.println(new Solution101().isSymmetric(node));
        //System.out.println(new Solution101().mirror(root));
    }
}
