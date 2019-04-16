package Tree;

import utils.TreeNode;

/**
 * 404. Sum of Left Leaves
 * Find the sum of all left leaves in a given binary tree.
 * Example:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *      There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
class Solution404 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
     * Memory Usage: 38.5 MB, less than 5.30% of Java online submissions for Sum of Left Leaves.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        int sum = 0;
        if(root.left != null) {
            if(root.left != null && isLeave(root.left)) sum = sum + root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    public boolean isLeave(TreeNode node){
        if(node == null) return false;
        if(node.left == null && node.right == null) return true;
        return false;
    }
    /**
     * good writing
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
     * Memory Usage: 38.4 MB, less than 5.30% of Java online submissions for Sum of Left Leaves.
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        return root!=null?(( root.left != null && root.left.right == null && root.left.left == null ? root.left.val : 0 ) + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right)):0;
    }
}
public class No404sumOfLeftLeaves {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(6);

        root.left  = n1;
        root.right = n2;
        n1.left  = n5;
//        n1.right = n4;
        n2.left  = n3;
        n2.right = n4;

        System.out.println(new Solution404().sumOfLeftLeaves(root));
    }
}
