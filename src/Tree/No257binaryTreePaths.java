package Tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 * Example:
 * Input:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * Output: ["1->2->5", "1->3"]
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
class Solution257 {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Paths.
     * Memory Usage: 37.6 MB, less than 62.66% of Java online submissions for Binary Tree Paths.
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null) return list;
//        if(root.left == null && root.right == null){list.add(String.valueOf(root.val));return list;}
//        String str = String.valueOf(root.val);
        return onePath(root , String.valueOf(root.val) , list);
    }
    public List<String> onePath(TreeNode root , String str , List<String> list){
        if(root.left == null && root.right == null) {list.add(str);return list;}
        if(root.left != null)  onePath(root.left , str+"->"+String.valueOf(root.left.val) , list);
        if(root.right!= null)  onePath(root.right, str+"->"+String.valueOf(root.right.val), list);
        return list;
    }
}
public class No257binaryTreePaths {
    public static void main(String[] args){
        TreeNode root = new TreeNode(6);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(5);

        root.left  = n1;
        root.right = n2;
        n1.left  = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n4.left = n7;
        n4.right = n8;
        System.out.println(new Solution257().binaryTreePaths(root));
    }
}
