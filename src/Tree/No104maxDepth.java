package Tree;

import java.util.*;
import utils.*;

import javax.xml.bind.UnmarshallerHandler;

/**
 * 104. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
class Solution104 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 40.4 MB, less than 5.01% of Java online submissions for Maximum Depth of Binary Tree.
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        //if(root.left == null && root.right == null) return 1;

        return Math.max(maxDepth(root.left)+1 , maxDepth(root.right)+1);
    }
}
public class No104maxDepth {
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
//        n2.right = n4;
//        n1.left = n5;
        System.out.println(new Solution104().maxDepth(root));
    }
}
