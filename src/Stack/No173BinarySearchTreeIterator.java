package Stack;

import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 *
 * 题意：next()：查找搜索二叉树中是否有最小值；hasNext()：查找搜索二叉树中是否仍有最小值；
 */
class BSTIterator01 {
    /**
     * 普通二叉树转为双向链表
     */
    public void BSTIterator(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        if(root.left != null) stack1.push(root.left);
        while(!stack1.isEmpty()){
            if(stack1.peek().left != null){
                TreeNode node = stack1.peek();
                stack1.push(node.left);
                node.left = null;
            }
            else{
                TreeNode node = stack1.pop();
                stack2.push(node);
                if(node.right != null){stack1.push(node.right);node.right = null;}
            }
        }
        linkedList.offer(root.val);
        while(!stack2.isEmpty()){
            linkedList.offerFirst(stack2.pop().val);
        }
        if(root.right != null) stack1.push(root.right);
        while(!stack1.isEmpty()){
            if(stack1.peek().left != null){
                TreeNode node = stack1.peek();
                stack1.push(node.left);
                node.left = null;
            }
            else{
                TreeNode node = stack1.pop();
                linkedList.offerLast(node.val);
                if(node.right != null){stack1.push(node.right);node.right = null;}
            }
        }
        System.out.println(linkedList.toString());
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return 0;
    }
}
class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        findInOrderSuccessor(root);
    }

    //'find' is a bad word in this case, its more like push
    private void findInOrderSuccessor(TreeNode node){
        if(node == null) return;
        stack.push(node);
        while(node.left != null){
            node = node.left;
            stack.push(node);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        findInOrderSuccessor(node.right);
        return node.val;
    }
}

public class No173BinarySearchTreeIterator {
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
        n1.left = n5; n1.right = n6;


    }
}
