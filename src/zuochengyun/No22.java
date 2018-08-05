package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;
/**
 * 将单链表的每k个节点之间逆序
 */
class Solution22{
	/**
	 * 方法一：较难，直接调整
	 */
	public Node reverseBetweenK1 (Node head , int k){
		if(head == null || head.next == null){return head ; }
		Node p = head.next;
		Node first = head;
		Node headNew = new Node(0);
		Node q = headNew;
		q.next = head ;
		int count = 1;
		while( p != null ){
			while( p != null  && count < k){
				first.next = p.next ;
				p.next = q.next ;
				q.next = p ;
				p = first.next;
				count ++;
				if ( p ==null) break;
			}
			if( p !=null ) {
				count = 1;
				q = first;
				first = q.next ;
				p = first.next;
			}
			else{
				if(count < k){
					first = q.next;
					p = first.next;
					while( p != null){
						first.next = p.next;
						p.next = q.next ;
						q.next = p;
						p = first.next;
					}
				}
			}
			
		}
		return headNew.next;
	}
	
	/**
	 * 方法三：用栈实现
	 */
	public Node reverseBetweenK2 (Node head , int k){
		if(head == null || head.next == null){return head ; }
		Stack<Node> stack = new Stack<Node>();
		Node p = head;
		Node headNew = new Node(0);
		Node q = headNew; 
		int count = 0;
		while( p != null){
			if(count < k){
				stack.push( p ) ;
				p = p.next ;
				count ++;
			}
			else{
				while(!stack.isEmpty()){
					q.next = stack.pop();
					q = q.next;
				}
				count = 0;
			}
		}
		if(count < k){
			while(!stack.isEmpty()){
				p = stack.pop();
			}
		}
		q.next = p; //只要弹栈到最后一个，后面这几个节点的next值不改变即可；
		return headNew.next;
	}
	
	/**
	 * 方法三：将node按照顺序放如数组中，在从头到尾连接数组
	 */
	public Node reverseBetweenK3 (Node head , int k){
		if(head == null || head.next == null){return head ; }
		Node p = head;
		int count = 0;
		while( p != null){
			p = p.next ;
			count ++;
		}
		Node[] nodes = new Node[count];
		count = 1;
		p = head;
		int m = k;
		Node last = head;
		while( p != null || count < nodes.length){
			if(count <= m){
				if(2*m-count-k < nodes.length){nodes[2*m-count-k ] = p; p = p.next ;count ++;}
				else break;
			}
			else{ m = m + k ;last = p;}
		}
		while( p != null){
			nodes [count-1] = p; 
			p = p.next ;
			count ++;
		}
		for (int i = 0 ; i < nodes.length-1 ; i ++){
			nodes[i].next = nodes[i+1];
		}
		nodes[nodes.length-1].next = null;
		return nodes[0];
	}
}

public class No22 {
	public static void main(String[] args) {
		Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(5);
        Node n3 = new Node(6);
        Node n4 = new Node(5);
        Node n5 = new Node(9);
        root.next = n1 ;n1.next = n2 ; n2.next = n3;n3.next = n4 ;n4 .next  = n5;
        Node result = new Solution22().reverseBetweenK1(root, 3);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
	}
}
