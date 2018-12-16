package Tree;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import utils.TreeNode;

import java.time.chrono.IsoChronology;
import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
class Solution107 {
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        if(root == null ) return null;
        List<List<Integer>> total = new ArrayList<List<Integer>>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            while(!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                list.add(node.val);
                if(node.right  != null) {stack2.push(node.right);}
                if(node.left != null) {stack2.push(node.left );}
            }
            if(!list.isEmpty()) total.add(list);
            List<Integer> list1 = new ArrayList<Integer>();
            while(!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                list1.add(node.val);
                if(node.left != null) {stack1.push(node.left);}
                if(node.right!= null) {stack1.push(node.right);}
            }
            if(!list1.isEmpty()) total.add(list1);
        }

        return total;
    }

    /**
     * Runtime: 1 ms, faster than 98.90% of Java online submissions for Binary Tree Level Order Traversal II.
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> total = new ArrayList<List<Integer>>();
        if(root == null ) return total;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode p = root;
        TreeNode q = root;

        List<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if( node.left != null ) { queue.offer(node.left ); q = node.left; }
            if( node.right!= null ) { queue.offer(node.right); q = node.right;}
            if(node == p) {
                total.add(0 ,list);  //注意这种写法，每次把最新值放在第0号位置上
                list = new ArrayList<Integer>();
                p = q;
            }
        }

        return total;
    }

    /**
     * BFS
     * Runtime: 1 ms, faster than 98.90% of Java online submissions for Binary Tree Level Order Traversal II.
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}
public class No107BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(8);

        root.left  = n1;
        root.right = n2;
        n2.left  = n3;
        n2.right = n4;
        //n1.left = n5;
        System.out.println(new Solution107().levelOrderBottom(root));
    }
}
