package Tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 */
class Solution230 {
    /**
     * Runtime: 1 ms, faster than 42.45% of Java online submissions for Kth Smallest Element in a BST.
     * Memory Usage: 38.4 MB, less than 80.61% of Java online submissions for Kth Smallest Element in a BST.
     */
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        List<Integer> list = new ArrayList<Integer>();
        inOrder(root , list);
//        System.out.println(list);
        return list.get(k-1);
    }
    public void inOrder(TreeNode root , List<Integer> list){
        if(root == null) return;
        if(root.left != null) inOrder(root.left , list);
        list.add(root.val);
        if(root.right!= null) inOrder(root.right,list);
    }
    /**
     * good idea : not use middle order
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
     * Memory Usage: 38.9 MB, less than 24.51% of Java online submissions for Kth Smallest Element in a BST.
     */
    int k_tree = 0;
    int result = Integer.MAX_VALUE;
    public int kthSmallest1(TreeNode root, int k) {

        util(root, k);
        return result;
    }

    public void util(TreeNode root, int k){

        if(root == null)
            return ;
        util(root.left,k);
        k_tree++;
        if(k_tree == k){
            result=  root.val;
            return;
        }
        util(root.right,k);
    }
}
public class No230kthSmallest {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);

        root.left  = n1;
        root.right = n2;
        n1.right  = n3;
//        n1.right = n4;
        n2.left  = n4;
        n2.right = n5;

        System.out.println(new Solution230().kthSmallest1(root , 4));
    }
}
