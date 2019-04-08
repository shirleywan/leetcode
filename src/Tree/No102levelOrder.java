package Tree;

import java.util.*;
import utils.*;

/**
 * 102. Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
class Solution102 {
    /**
     * Runtime: 1 ms, faster than 74.44% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 37.5 MB, less than 7.40% of Java online submissions for Binary Tree Level Order Traversal.
     * queue + list
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> temp = new ArrayList<TreeNode>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            temp.add(node);
            if(node.left != null) { queue.offer(node.left) ; }
            if(node.right!= null) { queue.offer(node.right); }
        }
        TreeNode p = root;
        TreeNode q = p;
        for(int i = 0 ; i < temp.size() ; i++){
            TreeNode node = temp.get(i);
            list.add(node.val);
            if(node.left != null) { q = node.left; }
            if(node.right!= null) { q = node.right; }
            if(node == p) {
                result.add(list);
                list = new ArrayList<Integer>();
                p = q;
            }
        }
        return result;
    }

    /**
     * Runtime: 1 ms, faster than 74.44% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 37.5 MB, less than 10.45% of Java online submissions for Binary Tree Level Order Traversal.
     * two stack
     */
    public List<List<Integer>> levelOrderNew(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        List<Integer> list = new ArrayList<Integer>();
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                list.add(node.val);
                if(node.right!= null) stack2.push(node.right);
                if(node.left != null) stack2.push(node.left );
            }
            if( !list.isEmpty()) result.add(reverse(list));
            list = new ArrayList<Integer>();
            while(!stack2.isEmpty()){
                TreeNode node = stack2.pop();
                list.add(node.val);
                if(node.left != null) stack1.add(node.left );
                if(node.right!= null) stack1.add(node.right);
            }
            if( !list.isEmpty() ) result.add(list);
            list = new ArrayList<Integer>();
        }
        return result;
    }
    public List<Integer> reverse(List<Integer> list){
        if(list.isEmpty()) return list;
        int n = list.size();
        for(int i = 0 ; i < n/2 ; i++){
            int temp = list.get(i);
            list.set(i , list.get(n-i-1));
            list.set(n-i-1 ,temp);
        }
        return list;
    }
    /**
     * Good method:记录每一层有多少个节点，而不是比较每层最后一个节点
     * Runtime: 1 ms, faster than 74.44% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 37.4 MB, less than 23.52% of Java online submissions for Binary Tree Level Order Traversal.
     */
    List<List<Integer>> levelsNodes = new LinkedList<>();

    public List<List<Integer>> levelOrderRefer(TreeNode root) {
        if(root == null) return levelsNodes;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> nodes = new LinkedList<>();

            while(levelSize>0) {
                TreeNode n = q.poll();
                nodes.add(n.val);

                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);

                levelSize--;
            }
            levelsNodes.add(nodes);
        }
        return levelsNodes;
    }
}
public class No102levelOrder {
    public static void main(String[] args){
        TreeNode root = new TreeNode(6);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(5);

        root.left  = n1;
        root.right = n2;
        n1.left  = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n4.left = n7;
        n4.right = n8;
        System.out.println(new Solution102().levelOrderNew(root));
    }
}
