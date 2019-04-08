package Tree;

import utils.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *      The left subtree of a node contains only nodes with keys less than the node's key.
 *      The right subtree of a node contains only nodes with keys greater than the node's key.
 *      Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 */
class Solution98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        boolean flag = false;
        if((root.val == Integer.MIN_VALUE && getMax(root.left) == Integer.MIN_VALUE)||
                (root.val == Integer.MAX_VALUE && getMin(root.right) == Integer.MAX_VALUE)) flag = true;
        else {
            if (root.val > getMax(root.left) && root.val < getMin(root.right)) flag = true;
        }
        return flag && isValidBST(root.left) && isValidBST(root.right);
    }
    public int getMax(TreeNode root){
        if(root == null ) return Integer.MIN_VALUE;
        int max = root.val;
        if(root.right != null)  max = getMax(root.right);
        return max;
    }
    public int getMin(TreeNode root){
        if(root == null ) return Integer.MAX_VALUE;
        int min = root.val;
        if(root.left!= null)  min = getMin(root.left);
        return min;
    }
}
class Solution98new {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode root, Integer low, Integer high) {

        if (root == null) {
            return true;
        }

        if (low != null && root.val <= low) {
            return false;
        } else if (high != null && root.val >= high) {
            return false;
        } else {
            return isValid(root.left, low, root.val) && isValid(root.right, root.val, high);
        }
    }
}
public class No98isValidBST {
    public static void main(String[] args){
        TreeNode root = new TreeNode(-1);
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(6);


        root.left  = n1;
//        root.right = n2;
//        n2.left  = n3;
//        n2.right = n4;
//        n2.left = n5;
//        n2.right = n6;
//        n4.left = n7;
//        n4.right = n8;
        System.out.println(new Solution98().isValidBST(root));
    }
}
