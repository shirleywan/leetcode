package zuochengyun;

import zuochengyun.util.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 调整搜索二叉树中两个错误的节点
 */

class Solution40 {
    /**
     * 找到搜索二叉树中两个错误的节点
     */
    public TreeNode[] getTwoErrNodes(TreeNode root){
        TreeNode[] nodes = new TreeNode[2];
        if(root == null || (root.left == null && root.right == null)) {return nodes;}
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list = midOrder(root , list);
        int count = 0;
        for(int i = 0 ; i <list.size()-1 ; i++){
            if(list.get(i).value > list.get(i+1).value){
                if(count %2 == 0){
                    nodes[count] = list.get(i);count ++;nodes[count] = list.get(i+1);
                }
                else{
                    nodes[count] = list.get(i+1);count++;
                }
            }
        }
        return nodes;
    }
    /**
     * 中序遍历
     */
    public ArrayList<TreeNode> midOrder(TreeNode root , ArrayList<TreeNode> list){
        if(root == null){return list;}
        if(root.left != null){list = midOrder(root.left , list);}
        list.add(root);
        if(root.right != null){list = midOrder(root.right , list);}
        return list;
    }
    /**
     * 交换搜索二叉树中两个错误的节点
     */
    public void changeTwoErrNodes(TreeNode root){
        TreeNode[] nodes = new TreeNode[2];
        if(root == null || (root.left == null && root.right == null)) {return ;}
        nodes = getTwoErrNodes(root);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        TreeNode[] father = new TreeNode[2];
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node.left != null){queue.offer(node.left);}
            if(node.right != null){queue.offer(node.right);}
            if(node.left == nodes[0] || node.right == nodes[0]){father[0] = node;}
            if(node.left == nodes[1] || node.right == nodes[1]){father[1] = node;}
        }
        node = nodes[1];
        TreeNode p = nodes[1].left;
        TreeNode q = nodes[1].right;
        nodes[1].left = nodes[0].left;
        nodes[1].right = nodes[0].right;
        nodes[0].left = p;
        nodes[0].right = q;
        if(father[0].left == nodes[0]){
            father[0].left = nodes[1];
        }
        if(father[0].right == nodes[0]){
            father[0].right = nodes[1];
        }
        if(father[1].left == nodes[1]){
            father[1].left = nodes[0];
        }
        if(father[1].right == nodes[1]){
            father[1].right = nodes[0];
        }

    }
//    public ArrayList<TreeNode> mid(TreeNode root , ArrayList<TreeNode> list){
//        if(root == null) {return list;}
//        if(root.left != null){
//            if(root.value < root.left.value){
//                list.add(root); list.add(root.left);
//            }
//            mid(root.left , list);
//        }
//        if(root.right != null){
//            if(root.value > root.right.value){
//                list.add(root); list.add(root.right);
//            }
//            mid(root.right , list);
//        }
//        return list;
//    }
}

public class No40 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(6);

        root.left = n1; root.right = n3;
        n1.right = n2;
        n3.left = n4; n3.right = n5;
        
        Solution40 solution = new Solution40();
        ArrayList<TreeNode> newlist = new ArrayList<TreeNode>();
        newlist = solution.midOrder(root ,newlist);
        for(int i = 0 ; i< newlist.size() ; i++){
            System.out.println(newlist.get(i).value);
        }
        System.out.println("---------------");
        TreeNode[] nodes= solution.getTwoErrNodes(root);
        System.out.println(nodes[0].value +"," +nodes[1].value);
        System.out.println("---------------");
        //test midOrder
        solution.changeTwoErrNodes(root);
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list = solution.midOrder(root ,list);
        for(int i = 0 ; i< list.size() ; i++){
            System.out.println(list.get(i).value);
        }
        

    }
}
