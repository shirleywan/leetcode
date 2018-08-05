package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;
/**
 * 单链表的选择排序
 * 要求：额外空间复杂度为O(1)
 */
class Solution26{
	public Node chooseSort (Node head ){
		if(head == null || head.next == null){ return head; }
		Node p = head ;
		Node q = head ; 
		Node pointer = head;
		Node headnew = new Node(head.value);
		while(pointer != null){
			p = pointer.next;
			q = pointer;
			headnew.value = pointer.value;
			while(p != null){
				if( headnew.value > p.value) {headnew.value = p.value ;q = p; }
				p =p.next;
			}
			q.value = pointer.value ;
			pointer.value = headnew.value;
			headnew.value = q.value;
			pointer = pointer.next;
		}
		
		return head;
	}
}

public class No26 {
	public static void main(String[] args) {
		Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(6);
        Node n4 = new Node(7);
        Node n5 = new Node(5);
        root.next = n1 ;n1.next = n2 ; n2.next = n3;n3.next = n4 ;n4 .next  = n5;
        Node result = new Solution26().chooseSort(root);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
	}
}
