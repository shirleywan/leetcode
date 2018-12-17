package Tree;

import utils.TreeNode;

/**
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 */
class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        else{
            if(Math.abs(level(root.left) - level(root.right)) <= 1) return true;
            else return false ;
        }
    }
    public int level(TreeNode root){
        if(root.left == null && root.right == null) return 1;
        if(root.left == null ) return level(root.right) +1;
        if(root.right== null ) return level(root.left ) +1;
        return Math.max(level(root.left) , level(root.right))+1;
    }
}

/**
 * 含义相同，写法更好；
 * Runtime: 2 ms
 */
class Solution110_1{
    public boolean isBalanced(TreeNode root) {
        return root == null ? true : Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

/**
 * Runtime: 1 ms, faster than 90.70% of Java online submissions for Balanced Binary Tree.
 */
class Solution110_2{
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (right == -1 || left == -1 || Math.abs(left-right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
public class No110BalancedBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(8);

        root.left  = n1;
        root.right = n2;
        n2.left  = n3;
        n3.right = n4;
        //n1.left = n5;
        System.out.println(new Solution110_2().isBalanced(root));
    }
}
