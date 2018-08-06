package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;
/**
 * 向有序的环形单链表中插入新节点
 */
class Solution30{
	public Node insertCircleList(Node head , int num){
		if(head == null) {return new Node(num);}
		Node node = new Node(num);
		if(head.next == head){head.next = node;node.next = head;return head;}
		else{
			if(head.value >= num){
				Node p = head.next;
				while( p.next != head){p = p.next;}
				p.next = node ; node.next = head;
				return node;
			}
			else{
				Node p = head.next;
				if( p.value >= num){
					head.next = node;
					node.next = p;
					return head;
				}
				else{
					while( p.next !=head && p.value < num){
						p = p.next;
					}
					node.next = p.next;
					p.next = node;
					return head;
				}
			}
		}
	}
}

public class No30 {
	public static void main(String[] args) {
		Node head = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(4);
        Node n3 = new Node(6);
        Node n4 = new Node(5);
        Node n5 = new Node(7);
        //head.next = head;
        //head.next = n1 ;n1.next = head;//two node
        head.next = n1 ;n1.next = n2 ; n2.next = head;
        //head.next = n1 ;n1.next = n2 ; n2.next = n3;n3.next = n4 ;n4 .next  = n5;n5.next = head;
        Node result = new Solution30().insertCircleList(head, 6);
        Node p = result;
        while(p.next != result){
            System.out.println(p.value);
            p = p.next ;
        }
        System.out.println(p.value);
        System.out.println(p.next.value);
	}
}

