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
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> totallist = new ArrayList<List<Integer>>();
        if(root == null ){return totallist;}
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> list1 = new ArrayList<Integer>();
            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                list1.add(node.val);
                if(node.left != null){stack2.push(node.left);}
                if(node.right!= null){stack2.push(node.right);}
            }
            if(list1.size() != 0) totallist.add(list1);
            List<Integer> list2 = new ArrayList<Integer>();
            while(!stack2.isEmpty()){
                TreeNode node = stack2.pop();
                list2.add(node.val);
                if(node.right!= null){stack1.push(node.right);}
                if(node.left != null){stack1.push(node.left);}
            }
            if(list2.size() != 0) totallist.add(list2);
        }
        return totallist;
    }
}
public class No103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(8);
        TreeNode n6 = new TreeNode(10);

        root.left = n1; root.right = n2;
        n2.left = n3; n2.right = n4;
        n1.left = n5;n1.right = n6;

        System.out.println(new Solution103().zigzagLevelOrder(root));
    }
}
