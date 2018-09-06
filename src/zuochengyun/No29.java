package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;
/**
 * 合并两个有序的单链表
 */
class Solution29{
	public Node halfCombine(Node head){
		if(head == null || head.next == null){ return head; }
		Node p =head ;
		Node q = head.next;
		while(q.next != null){
			q = q.next ; 
			if ( q.next == null ){ break;}
			p = p.next;
			q = q.next;
		}
		q = p.next;
		p.next = null;
		Node last = head;
		p = last.next;
		while( p != null && q != null){
			last.next = q;
			q = q.next ;
			last.next.next = p;
			last = last.next.next;
			p = last.next;
		}
		if( q != null){last.next = q;}
		return head;
	}
}

public class No29 {
	public static void main(String[] args) {
		Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(6);
        Node n4 = new Node(5);
        Node n5 = new Node(7);
        head.next = n1 ;n1.next = n2 ; n2.next = n3;n3.next = n4 ;//n4 .next  = n5;
        Node result = new Solution29().halfCombine(head);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
	}
}
