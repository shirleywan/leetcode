package zuochengyun;

import sun.reflect.generics.tree.Tree;
import zuochengyun.util.TreeNode;

/**
 * 二叉树的按层打印与ZigZag打印
 */
import java.util.*;

class Solution39 {
    public void printByLevel(TreeNode root){
        if(root == null ) {System.out.println(root);}
        if(root.left == null && root.right == null) {System.out.println(root.value);}
        TreeNode last = root;
        TreeNode cur = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        int count = 1;
        System.out.print("Level " + count +" :");
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node.left != null) {queue.offer(node.left);}
            if(node.right != null){queue.offer(node.right);}
            System.out.print( node.value +" ");
            if(node == last) {
                count ++;System.out.print("\n");
                if(last.right != null){last = last.right;}
                else{last = last.left;}
                if(last != null){System.out.print("Level " + count +" :");} //防止没有节点在输出一行
            }
        }
    }
    public void printByZigZag(TreeNode root){
        if(root == null ) {System.out.println(root);}
        if(root.left == null && root.right == null) {System.out.println(root.value);}
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        TreeNode node = null;
        int count = 1;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(count %2 == 1) {
                System.out.print("Level "+count + " : ");
                while (!stack1.isEmpty()) {
                    node = stack1.pop();
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    System.out.print(node.value + " ");
                }
                System.out.print("\n");
                count ++;
            }
            else{
                System.out.print("Level "+count + " : ");
                while(!stack2.isEmpty()){
                    node = stack2.pop();
                    if(node.right != null){stack1.push(node.right);}
                    if(node.left != null){stack1.push(node.left);}
                    System.out.print(node.value + " ");
                }
                System.out.print("\n");
                count ++;
            }
        }
    }

}

public class No39 {
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

        Solution39 solution = new Solution39();
        solution.printByLevel(root);
        System.out.println("---------------------");
        solution.printByZigZag(root);

    }
}
