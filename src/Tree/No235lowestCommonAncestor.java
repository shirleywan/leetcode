package Tree;

import java.util.*;
import utils.*;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *        6
 *      /  \
 *     2    8
 *   / \   / \
 *  0  4  7   9
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * Example 1:
 *      Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 *      Output: 6
 *      Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *      Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 *      Output: 2
 *      Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * Note:
 *
 *      All of the nodes' values will be unique.
 *      p and q are different and both values will exist in the BST.
 */
class Solution235 {
    /**
     * Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     * Memory Usage: 36.2 MB, less than 5.11% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == q) return p;
        if(p.val > q.val) {TreeNode node = p;p = q ; q = node;}
//        if((p.left!= null && p.left == q) ||(p.right!= null && p.right == q)) return p;
//        if((q.left!= null && q.left == p) ||(q.right!= null && q.right == p)) return q;
        TreeNode node = root;
        while(node != null &&(node != p || node != q)){
            if(node.val < p.val) node = node.right;
            if(node.val > q.val) node = node.left;
            if(node.val > p.val && node.val < q.val) return node;
            else{
                if(node == p) return p;
                if(node == q) return q;
            }
        }
        return node;
    }
    /**
     * recursion
     * Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     * Memory Usage: 34.9 MB, less than 57.90% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val<p.val && root.val < q.val) return lowestCommonAncestor1(root.right,p,q);
        if(root.val>p.val && root.val > q.val) return lowestCommonAncestor1(root.left,p,q);
        return root;
    }
}
public class No235lowestCommonAncestor {
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
        System.out.println(new Solution235().lowestCommonAncestor(root , n1,n8).val);
    }
}
