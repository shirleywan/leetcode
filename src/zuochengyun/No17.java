package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;

/**
 * 判断一个链表是否是回文结构
 * 注意：如果是节点个数偶数个，p 会停在 3/6 的位置，且 3 在栈中；直接使用 p = p.next 即可；
 * 如果节点个数是奇数个，p 会停在 3/5 的位置上，且 3 不入栈，同样使用 p = p.next，中间位置是回文公共部分；
 */

class Solution17{
	/**
	 * 第一种方法：将链表全部放入stack中
	 */
	
	
	/**
	 * 第二种方法：将链表的一半放入stack中
	 */
	public boolean isNodeParm(Node head) {
		Stack<Integer> stack = new Stack<Integer>();
		if (head == null || head.next == null){return true;}
		Node p = head ; 
		Node q = head.next ;
		while(q!=null){
			stack.push(p.value);
			q = q.next;
			if (q != null){
				p = p.next;
				q = q.next;
			}
		}
		p = p.next;
		while( p!=null){
			if(p.value != stack.pop()){return false;}
			else{
				p = p.next;
			}
		}
		return true;
	}
	/**
	 * 第三种方法：不使用额外结构，空间O(1),时间O(N)
	 * 使右边部分反转，连向中间节点，在从两个头部分别设置指针，步长相同向中间移动
	 */
	public boolean isNodeParm2(Node head) {
		if (head == null || head.next == null){return true;}
		Node p = head ; 
		Node q = head.next ;
		while(q.next!=null){
			q = q.next;
			if (q.next!= null){
				p = p.next;
				q = q.next;
				break;
			}
		} //q当前是在最后的位置,奇数p停在2/5上，偶数停在2/6上，因此都反转到p.next
		System.out.println(p.value);
		System.out.println(p.next.value);
		p = p.next;
		Node first = p.next;
		Node m = first.next;
		while( m != null){
			first.next = m.next;
			m.next = p.next;
			p.next = m;
			m = first.next;
		}
		q = head;
		p = p.next;
		while(p != null){
			if(q.value != p.value){return false;}
			else{
				q = q.next ;
				p = p.next ;
			}
		}
		return true;
		
	}
}

public class No17 {
	public static void main(String[] args) {
	Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n5 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        root.next = n1 ;n1.next = n2 ; n2.next = n5;n5.next = n3;n3.next = n4 ;
        System.out.println(new Solution17().isNodeParm2(root));
        
	}
}
