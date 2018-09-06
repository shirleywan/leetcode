package zuochengyun;

import java.util.Arrays;

import zuochengyun.util.Node;

class Solution18{
	/**
	 * 方法一：生成新数组，时间O(N),空间O(N)
	 */
	public Node sort(Node head){
		if(head == null || head.next == null){return head;}
		Node p = head;
		int count = 0;
		while(p!=null){
			count ++ ;
			p = p.next ;
		}
		int[] nums = new int[count];
		p = head;
		count = 0;
		while( p != null){
			nums[count] = p.value;
			count ++;
			p = p.next;
		}
		Arrays.sort(nums);
		p = head;
		count = 0;
		while(p!=null){
			p.value = nums[count];
			p = p.next ; 
			count ++ ;
		}
		return head;
	}
	/**
	 * 方法二：将链表划分为3个部分，small、equal、big
	 */
	
	public Node sort1(Node head , Node node){
		if(head == null || head.next == null){return head;}
		Node small = head;
		Node equal = head;
		Node big = head;
		Node p = head;
		while( p != null ){ 
			if ( p.value < small.value ){ small = p; }
			if ( p.value == node.value ){ equal = p; }
			if ( p.value > big.value   ){ big   = p; }
			p = p.next;
		}
		
		
		return head;
	}
}

public class No18 {
	public static void main(String[] args){
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(5);
        Node n3 = new Node(3);
        Node n4 = new Node(1);
        root.next = n1 ;n1.next = n2 ; n2.next = n3; n3.next = n4 ;
        Node result = new Solution18().sort(root);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
    }

}
