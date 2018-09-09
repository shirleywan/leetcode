package offer;
/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列 {1,2,4,7,3,5,6,8} 和中序遍历序列 {4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

import offer.util.TreeNode;
import java.util.*;

class Solution4{
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0 ){return null;}
        if(pre.length != in.length){return null;}
        HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0 ; i <pre.length ; i++){
            queue.offer(pre[i]);
            map.put(in[i] , i);
        }
        TreeNode root = new TreeNode(queue.poll());
        return root;
    }
    public TreeNode conNode(int[] in , int x ,int y){
        TreeNode node = new TreeNode(0);
        return node;
    }
}
public class No4 {
    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] mid = {4,7,2,1,5,3,8,6};
        TreeNode result = new Solution4().reConstructBinaryTree(pre, mid);
        System.out.println();
    }
}
