package zuochengyun;

import zuochengyun.util.Node;
import zuochengyun.util.TreeNode;
import java.util.*;
/**
 * 二叉树的序列化和反序列化
 */

class Solution34 {
	/**
	 * 先序遍历实现
	 */
    public String serialization(TreeNode root) {
        if (root == null) {return "#!";}
        String string = root.value + "!";
        string += serialization(root.left);
        string += serialization(root.right);
        return string;
    }

    //反序列化使用队列实现，注意这里的递归实现
    public TreeNode non_serialize(String string) {
        if (string == "#!") {return null;}
        String[] ch = string.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (String str : ch){
        	queue.offer(str);
        }
        return preSerialize(queue);
    }
    public TreeNode preSerialize(Queue<String> queue){
    	String str = queue.poll();
    	if (str.equals("#")){return null;}
    	TreeNode node = new TreeNode(Integer.valueOf(str));
    	node.left = preSerialize(queue);
    	node.right = preSerialize(queue);
    	return node;
    }

    /**
	 * 层次遍历实现
	 */
    public String serialization1(TreeNode root) {
        if (root == null) {return "#!";}
        String string = root.value + "!";
        string += serialization(root.left);
        string += serialization(root.right);
        return string;
    }
}

public class No34 {
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
        Solution34 solution = new Solution34();
        String string = solution.serialization(root);
        System.out.println(string);
        TreeNode result = solution.non_serialize(string);
        System.out.println(solution.serialization(result));
    }
}
