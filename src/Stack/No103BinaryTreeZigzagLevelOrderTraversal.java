package Stack;

import java.util.ArrayList;
import java.util.*;
import utils.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null ){return null;}
        if(root.left == null && root.right == null) {
            List<List<Integer>> totallist = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            totallist.add(list);
            return totallist;
        }
        return null;
    }
}
public class No103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("3"); list.add("9"); list.add("20"); list.add("null");
        list.add("null"); list.add("15"); list.add("7");
    }
}
