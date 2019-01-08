package Tree;

import com.sun.prism.RTTexture;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given the below binary tree and sum = 22,
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( root == null || root.val > sum) return result;
        int count = 0;
        List<Integer> list = new ArrayList<Integer>();
        if(root.val < sum){ list.add(root.val);}
        return result;
    }
    public List<Integer> getList(TreeNode node , List<Integer> list , int sum){
        if(node.val <= sum) list.add(node.val);
        if(node.left == null && node.right == null){
            return list;
        }

        return list;
    }
    public List<Integer> preOrder( TreeNode root , List<Integer> list){
        return list;
    }
}
public class No113PathSumII {
    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
    }
}
