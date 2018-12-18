package Tree;

import utils.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 *Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
class Solution111 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null) {
            return 1 + minDepth(root.right);
        } else if(root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
public class No111MinimumDepthOfBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(8);

//        root.left  = n1;
//        root.right = n2;
//        n2.left  = n3;
//        n3.right = n4;
        //n1.left = n5;
        
        System.out.println(new Solution111().minDepth(root));
    }
}
