package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;

/**
 * 判断一个链表是否是回文结构
 */

class Solution17{
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
}

public class No17 {
	public static void main(String[] args) {
		Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n5 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(1);
        root.next = n1 ;//n1.next = n2 ; n2.next = n5;// n2.next = n3;n3.next = n4 ;
        System.out.println(new Solution17().isNodeParm(root));
        
	}
}
