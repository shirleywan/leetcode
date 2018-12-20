package Tree;
import utils.TreeNode;
/**
 * 226. Invert Binary Tree
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
class Solution226 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
     */
    public TreeNode invertTree(TreeNode root) {
        if( root == null) return root;
        TreeNode node = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(node);
        return root;
    }
}
public class No226InvertBinaryTree {
    public static void main(String[] args){
        
    }
}
