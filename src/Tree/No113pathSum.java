package Tree;

import utils.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 *      Example:
 *      Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
class Solution113 {
    /**
     * Runtime: 2 ms, faster than 33.84% of Java online submissions for Path Sum II.
     * Memory Usage: 40.9 MB, less than 32.54% of Java online submissions for Path Sum II.
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( root == null ) return result;
        List<Integer> list = new ArrayList<Integer>();
        getList(root , list , sum , result);
        return result;
    }
    public void getList(TreeNode node , List<Integer> list , int sum , List<List<Integer>> result){
        if(node.left == null && node.right == null &&node.val == sum) {list.add(node.val); result.add(list);return;}
        list.add(node.val);
        List<Integer> newListLeft = new ArrayList<>(list);
        List<Integer> newListRight = new ArrayList<>(list);
        if(node.left != null) getList(node.left , newListLeft  , sum-node.val , result);
        if(node.right!= null) getList(node.right, newListRight , sum-node.val , result);
    }
    /**
     * good method -- DFS with one LinkedList
     * Runtime: 2 ms, faster than 33.84% of Java online submissions for Path Sum II.
     * Memory Usage: 39.4 MB, less than 70.07% of Java online submissions for Path Sum II.
     */
    public List<List<Integer>> pathSum1(TreeNode root, int sum){
        List<List<Integer>> result  = new LinkedList<List<Integer>>();
        List<Integer> currentResult  = new LinkedList<Integer>();
        pathSum1(root,sum,currentResult,result);
        return result;
    }

    public void pathSum1(TreeNode root, int sum, List<Integer> currentResult,
                        List<List<Integer>> result) {

        if (root == null)
            return;
        currentResult.add(new Integer(root.val));
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
            return;
        } else {
            pathSum1(root.left, sum - root.val, currentResult, result);
            pathSum1(root.right, sum - root.val, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);
    }
}
public class No113pathSum {
    public static void main(String[] args){
        TreeNode root = new TreeNode(-2);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(-3);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(13);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(5);
        TreeNode n9 = new TreeNode(1);

        //root.left  = n1;
        root.right = n2;
        //n1.left  = n3;
        //n1.right = n4;
        //n2.left = n4;
        //n2.right = n5;

        //n3.left = n6;
        //n3.right = n7;
        //n5.left = n8;
        //n5.right= n9;

        System.out.println(new Solution113().pathSum(root , -5));
    }
}
