package zuochengyun;
import java.util.*;

import Strings.intToRoman12;
/**
 * 构造数组的MaxTree
 * @author Administrator
 *
 */
class Node{
	public int value;
	public Node left;
	public Node right;
	
	public Node (int data){
		this.value = data;
	}
}
class Solution8{
	public Node maxTree(int[] nums){
		int max = nums[0];
		int i = 0;
		for ( ; i< nums.length ; i++){
			if(nums[i] > max){ max = nums[i] ;}
		}
		Node root = new Node(max);
		for(i = 0; i <nums.length ; i++){
			Node node = new Node(nums[i]);
			Node father = generate(nums, i, node);
		}
		return root;
	}
	public Node generate(int[] nums , int n ,Node node){
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		Node father = null;
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int j = 0 ; j<n ; j++){
			if(nums[j]> nums[n]){stack.push(nums[j]);}
		}
		if(!stack.isEmpty()){left = stack.pop();}
		for(int j = right ; j>n ; j--){
			if(nums[j]> nums[n]){stack.push(nums[j]);}
		}
		if(!stack.isEmpty()){right = stack.pop();}
		if(left < right){
			father = new Node(left);
			father.left = node;
		}
		else{
			father = new Node(right);
			father.right = node;
		}
		return father;
	}
}
public class No8 {
	public static void main(String[] args) {
		int[] nums = {3,4,5,1,2} ; 
		System.out.println(new Solution8().maxTree(nums).value);
	}
}
