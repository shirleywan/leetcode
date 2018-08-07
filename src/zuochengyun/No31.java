package zuochengyun;

import zuochengyun.util.Node;
import zuochengyun.util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 分别用递归和非递归方式实现二叉树先序、中序和后序遍历
 */
class Solution31{
    /**
     * 递归二叉树先序遍历
     */
    public ArrayList<Integer> preOrderIter(TreeNode root){
        if (root == null) return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = preOrder(root , list);
        return list;
    }
    public ArrayList<Integer> preOrder (TreeNode root , ArrayList<Integer> list){
        if (root.left == null && root.right == null){list.add(root.value); return list;}
        list.add(root.value);
        if(root.left  != null) {preOrder(root.left  , list);}
        if(root.right != null) {preOrder(root.right , list);}
        return list;
    }
    /**
     * 非递归二叉树先序遍历
     */
    public ArrayList<Integer> non_preOrder(TreeNode root){
        if (root == null) return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode node = null;
        while(! stack.isEmpty() ){
            node = stack.pop();
            list.add(node.value);
            if(node.right != null){stack.push(node.right);}
            if (node.left != null){stack.push(node.left); }
        }
        return list;
    }
    /**
     * 递归二叉树中序遍历
     */
    public ArrayList<Integer> midOrderIter(TreeNode root){
        if (root == null) return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = midOrder(root , list);
        return list;
    }
    public ArrayList<Integer> midOrder (TreeNode root , ArrayList<Integer> list){
        if (root.left == null && root.right == null){list.add(root.value); return list;}
        if(root.left  != null) {preOrder(root.left  , list);}
        list.add(root.value);
        if(root.right != null) {preOrder(root.right , list);}
        return list;
    }
    /**
     * 非递归二叉树中序遍历
     */
    public ArrayList<Integer> non_midOrder(TreeNode root){
        if (root == null) return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode node = null;
        while(! stack.isEmpty() ){
            node = stack.peek();
            if (node.left != null){stack.push(node.left);node.left = null;}
            else{
                list.add(node.value);
                stack.pop();
                if (node.right != null){stack.push(node.right);}
            }

        }
        return list;
    }

    /**
     * 递归二叉树后序遍历
     */
    public ArrayList<Integer> backOrderIter(TreeNode root){
        if (root == null) return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = backOrder(root , list);
        return list;
    }
    public ArrayList<Integer> backOrder (TreeNode root , ArrayList<Integer> list){
        if (root == null){return list;}
        if(root.left  != null) {backOrder(root.left  , list);}
        if(root.right != null) {backOrder(root.right , list);}
        list.add(root.value);
        return list;
    }
    /**
     * 非递归二叉树后序遍历
     */
    public ArrayList<Integer> non_backOrder(TreeNode root){
        if (root == null) return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode node = null;
        while(! stack.isEmpty() ){
            node = stack.peek();
            if(node.right != null || node.left != null){
                if(node.right != null){stack.push(node.right);node.right = null;}
                if(node.left != null){stack.push(node.left);node.left = null;}
            }
            else{
                list.add(node.value);
                stack.pop();
            }

        }
        return list;
    }
}
public class No31 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);

        root.left = n1 ; root.right = n3;
        n1.right = n2;
        n3.left = n4; n3.right = n5;
        Solution31 solution = new Solution31();
//        ArrayList<Integer> list =solution.preOrderIter(root);
//        System.out.println("pre order: ");
//        System.out.println(list);
//        System.out.println(solution.non_preOrder(root));

//        System.out.println("middle order: ");
//        System.out.println(solution.midOrderIter(root));
//        System.out.println(solution.non_midOrder(root));

//        System.out.println("back order: ");
//        System.out.println(solution.backOrderIter(root));
        System.out.println(solution.non_backOrder(root));
    }
}
