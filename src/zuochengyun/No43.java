package zuochengyun;

import sun.reflect.generics.tree.Tree;
import zuochengyun.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树是否是平衡二叉树
 *
 */

class Solution43 {
    /**
     * 求出左右节点的层数，比较差值是否小于1
     * 复杂度是O(m*2),比较高
     */
    public boolean isBalance(TreeNode root){
        if(root == null){return true;}
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node.left  != null){queue.offer(node.left); }
            if(node.right != null){queue.offer(node.right);}
            if(Math.abs(level(node.left) - level(node.right)) >1 ){return false;}
        }
        return true;
    }
    public int level(TreeNode root){
        if(root == null){return 0;}
        if(root.left == null && root.right == null){return 1;}
        return Math.max(level(root.left) +1 , level(root.right)+1);
    }
    /**
     * 后续遍历实现
     * 复杂度是O(m)
     */
    public boolean isBalance2(TreeNode root){
        if(root == null){return true;}
        boolean flag = true;
        getHeight(root , 1 , flag);
        return flag;
    }
    public int getHeight(TreeNode head , int level , boolean flag){
        if(head == null) {return level ; }
        int lh = getHeight(head.left , level + 1 , flag);
        if(!flag) {return level ;}
        int rh = getHeight(head.right, level + 1 , flag);
        if(!flag) {return level ;}
        if(Math.abs(lh - rh)>1) {flag = false;}
        return Math.max(lh , rh);
    }
}

public class No43 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);

        root.left = n1; root.right = n3;
        n1.right = n2;
        n3.left = n4; n3.right = n5;
        
        Solution43 solution = new Solution43();
        System.out.println(solution.isBalance2(root));

    }
}
