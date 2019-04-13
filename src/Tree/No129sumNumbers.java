package Tree;
import java.util.*;
import utils.*;

/**
 * 129. Sum Root to Leaf Numbers
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 *      The root-to-leaf path 1->2 represents the number 12.
 *      The root-to-leaf path 1->3 represents the number 13.
 *      Therefore, sum = 12 + 13 = 25.
 * Example 2:
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 *      The root-to-leaf path 4->9->5 represents the number 495.
 *      The root-to-leaf path 4->9->1 represents the number 491.
 *      The root-to-leaf path 4->0 represents the number 40.
 *      Therefore, sum = 495 + 491 + 40 = 1026.
 */
class Solution129 {
    /**
     * Runtime: 1 ms, faster than 24.63% of Java online submissions for Sum Root to Leaf Numbers.
     * Memory Usage: 36.8 MB, less than 61.39% of Java online submissions for Sum Root to Leaf Numbers.
     */
    public int sumNumbers(TreeNode root) {
        if(root == null ) return 0;
        if(root.left == null && root.right == null) return root.val;
        int num = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        getList(root , list , result);
        for(int i = 0 ; i < result.size() ; i++){
            int sum = 0;
            list = result.get(i);
            for(int j = 0 ; j < list.size() ; j++){
                sum = sum*10 + list.get(j);
            }
            num = num + sum ;
        }
        return num;
    }
    public void getList(TreeNode node , List<Integer> list , List<List<Integer>> result){
        list.add(node.val);
        if(node.left == null && node.right == null ) {result.add(list);return;}
        List<Integer> newListLeft = new ArrayList<>(list);
        List<Integer> newListRight = new ArrayList<>(list);
        if(node.left != null) getList(node.left , newListLeft  , result);
        if(node.right!= null) getList(node.right, newListRight , result);
    }
    /**
     * new method
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
     * Memory Usage: 36.7 MB, less than 88.12% of Java online submissions for Sum Root to Leaf Numbers.
     */
    int sums = 0;
    public int sumNumbers2(TreeNode root) {
        if(root == null) return 0;
        sumNum(root, 0);
        return sums;
    }
    public void sumNum(TreeNode root, int rootVal){
        rootVal = root.val + 10 * rootVal;
        if(root.left==null && root.right == null){
            sums += rootVal;
        }
        if(root.left != null){
            sumNum(root.left, rootVal);
        }
        if(root.right != null){
            sumNum(root.right, rootVal);
        }
    }
    /**
     * good method3
     * Runtime: 1 ms, faster than 24.63% of Java online submissions for Sum Root to Leaf Numbers.
     * Memory Usage: 37 MB, less than 5.45% of Java online submissions for Sum Root to Leaf Numbers.
     */
    int sum3 = 0;
    public int sumNumbers3(TreeNode root) {
        if (root == null) return 0;
        traverse(root, "");
        return sum3;
    }
    private void traverse(TreeNode root, String s) {
        s += root.val;
        if (root.left == null && root.right == null) {
            sum3 += Integer.parseInt(s);
        }

        if (root.left != null) {
            traverse(root.left, s);
        }
        if (root.right != null) {
            traverse(root.right, s);
        }
    }
}
public class No129sumNumbers {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
//        TreeNode n5 = new TreeNode(6);

//        root.left  = n1;
        root.right = n2;
//        n1.left  = n3;
//        n1.right = n4;
        //n2.left = n4;
//        n2.right = n5;

        System.out.println(new Solution129().sumNumbers3(root));
    }
}
