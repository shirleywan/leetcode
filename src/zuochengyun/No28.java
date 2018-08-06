package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;
/**
 * 合并两个有序的单链表
 */
class Solution28{
	public Node mergeSortedList (Node head1,Node head2 ){
		if(head1 ==null || head2 == null){return head1== null ? head2:head1;}
		Node q = head2;
		Node first = new Node(0);
		first.next = head1;
		Node last = first;
		Node p = head1;
		while(p != null && q !=null){
			if(q.value <= p.value){last.next = q ;q = q.next; last.next.next = p; last = last.next;}
			else{ 
				last = last.next;
				p = p.next;
			}
		}
		if(p == null){last.next = q;}
		return first.next;
	}
}

public class No28 {
	public static void main(String[] args) {
		Node head1 = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(6);
        Node n4 = new Node(5);
        Node n5 = new Node(7);
        head1.next = n1 ;n1.next = n2 ; n2.next = n3;/*n3.next = n4 ;*/n4 .next  = n5;
        Node result = new Solution28().mergeSortedList(head1, n4);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
	}
}
