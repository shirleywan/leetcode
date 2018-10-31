package Stack;

import java.util.*;
import utils.*;

/**
 * 94. Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively? 非递归实现
 */
class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) {return list;}
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            if(stack.peek().left != null){
                TreeNode node = stack.peek();
                stack.push(node.left);
                node.left = null;
            }
            else{
                TreeNode node = stack.pop();
                list.add(node.val);
                if(node.right != null){stack.push(node.right);node.right = null;}
            }
        }
        return list;
    }
}
public class No94BinaryTreeInorderTraversal {
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

        System.out.println(new Solution94().inorderTraversal(root));
    }
}
