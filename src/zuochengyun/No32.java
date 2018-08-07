package zuochengyun;

import zuochengyun.util.TreeNode;

import java.awt.*;
import java.util.*;

/**
 * 打印二叉树的边界节点:有多种方式
 * 可以：按照层次记录最左边和最右边的节点，两个栈即可实现；在中序遍历找到叶节点 -- 逆时针打印即可
 */

class Solution32{
    public ArrayList<Integer> printBorder(TreeNode root){
        if(root == null) {return null;}
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode p = root;
        list.add(root.value);
        while(p.left != null){
            if(!list.contains(p.value)){list.add(p.value);  p = p.left ;}
            else{ p = p.left ; }
        }
        list.add(p.value);
        p = root;
        while(p.right != null){
            if(!list.contains(p.value)){list.add(p.value); p = p.right;}
            else{ p = p.right ; }
        }
        list.add(p.value);

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        while(! queue.isEmpty() ){
            p = queue.poll();
            if (p.left == null && p.right == null) {
                if (! list.contains(p.value)){ list.add(p.value) ; }
            }
            if(p.left != null) {queue.offer(p.left);}
            if(p.right != null) {queue.offer(p.right);}
        }
        return list;
    }
}

public class No32 {
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
        System.out.println(new Solution32().printBorder(root));
    }
}
