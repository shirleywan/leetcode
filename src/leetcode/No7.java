package leetcode;

import leetcode.util.TreeNode;
import java.util.*;

/**
 * binary-tree-preorder-traversal
 * 非递归先序遍历
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * return[1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
class Solution7{
    /**
     *递归先序遍历二叉树
     */
    public ArrayList<Integer> preOrderList(TreeNode root , ArrayList<Integer> list){
        if(root.left == null && root.right == null){list.add(root.val) ; return list;}
        list.add(root.val);
        if( root.left != null ) {preOrderList( root.left  , list);}
        if(root.right != null ) {preOrderList( root.right , list);}
        return list;
    }

    /**
     *从先序遍历数组中恢复二叉树
     */
    public TreeNode preRecovery(Queue<String> queue){
        if(queue.isEmpty()) {return null;}
        String str = queue.poll();
        if(str.equals("#")) {return null;}
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = preRecovery(queue);
        node.right = preRecovery(queue);
        return node;
    }

    /**
     *非递归先续遍历
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root){
        if(root == null) {return new ArrayList<Integer>();}
        if(root.left == null && root.right == null){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!= null){stack.push(node.right);}
            if(node.left != null){stack.push(node.left);}
        }
        return list;
    }
    public ArrayList<Integer> postorderTraversal(ArrayList<String> list) {
        System.out.println("list: "+list);
        if (list.size() == 0){return null;}
        if (list.size() == 1 ) {
            if (list.get(0).equals("#")) {
                return null;
            } else {
                return new ArrayList<Integer>(Integer.valueOf(list.get(0)));
            }
        }
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0 ; i<list.size() ; i++){
            queue.offer(list.get(i));
        }
//        TreeNode root = preRecovery(queue); //恢复成二叉树形式
//        ArrayList<Integer> newlist = new ArrayList<Integer>();
//        newlist = preOrderList(root , newlist); //先序遍历查看已构建二叉树的形状
//        return newlist;
        TreeNode root = preRecovery(queue);
        ArrayList<Integer> newlist =preorderTraversal(root);
        return newlist;
    }
}

public class No7 {
    public static void main(String[] args){
//        TreeNode root = new TreeNode(1);
//        TreeNode n1 = new TreeNode(2);
//        TreeNode n2 = new TreeNode(3);
//        TreeNode n3 = new TreeNode(5);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(6);
//        TreeNode n6 = new TreeNode(7);
//
//        root.left = n1; root.right = n3;
//        n1.right = n2;
//        n3.left = n4; n3.right = n5;
//        n5.right = n6;
        Solution7 solution = new Solution7();
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");list.add("#");list.add("2");list.add("3");
        System.out.println(solution.postorderTraversal(list));
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list = solution.preOrderList(root , list);
//        System.out.println(solution.postorderTraversal(list));
//        System.out.println(new Solution1().run(root));
    }
}
