package Tree;

import utils.TreeNode;

/**
 * 112. Path Sum
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
class Solution112 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            //We found a leaf node so check if our current value equals to the value from that node.
            return root.val-sum == 0;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
public class No112PathSum {
    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
    }
}
