package zuochengyun;

import java.util.*;

import javax.lang.model.type.NullType;

import zuochengyun.util.DoubleNode;
import zuochengyun.util.TreeNode;
/**
 * 将搜索二叉树转换为双向链表
 */
class Solution25{
	/**
	 * 方法一：先中序遍历，在生成双向链表
	 */
	public DoubleNode DoubleList (TreeNode root ){
		if(root == null) {return null;}
		if ( root.left == null && root.right == null ){return new DoubleNode(root.value);}
		ArrayList<DoubleNode> list = new ArrayList<DoubleNode>();
		list = preOrder(root, list);
		for(int i = 0;i<list.size() - 1; i++){
			list.get(i).next = list.get(i+1);
			if( i == 0) { list.get(0).last = null; }
			else{ list.get(i).last = list.get(i-1); }
		}
		list.get(list.size()-1).last = list.get(list.size()-2);
		return list.get(0);
	}
	//中序遍历
	public ArrayList<DoubleNode> preOrder(TreeNode root ,ArrayList<DoubleNode> list){
		if(root == null) return list;
		if(root.left != null){ preOrder(root.left, list); }
		list.add(new DoubleNode(root.value));
		if(root.right != null){ preOrder(root.right, list); }
		return list;
	}
}

public class No25 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(6);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(7);
		root.left = n1 ; root.right = n3;
		n1.right = n2;
		n3.left = n4 ; n3.right = n5;
//		ArrayList<DoubleNode> list = new ArrayList<DoubleNode>();
//		list = new Solution25().preOrder(root, list);
//		System.out.println(list);
		DoubleNode result = new Solution25().DoubleList(root);
		while(result.next != null){
			System.out.println(result.value);
			result = result.next;
		}
		System.out.println(result.value);
		System.out.println("------------------");
		while(result != null){
			System.out.println(result.value);
			result = result.last;
		}
	}

}
