package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;
/**
 * 在单链表中删除指定值的节点
 */
class Solution24{
	/**
	 * 方法一：不使用辅助数据结构
	 */
	public Node deleteNum (Node head , int num){
		if(head == null) {return head;}
		while(head.value == num){
			head = head.next ; 
			if (head == null){ return head ; }
		}
		Node p = head ;
		while(p.next != null){
			if(p.next.value == num){
				p.next = p.next.next;
//				if( p == null) return head;
			}
			else{ p = p.next; }
		}
		if (p.value == num){p = null;}
		
		return head;
	}
	/**
	 * 方法二：使用栈或队列
	 */
}
public class No24 {
	public static void main(String[] args) {
		Node root = new Node(5);
        Node n1 = new Node(3);
        Node n2 = new Node(5);
        Node n3 = new Node(6);
        Node n4 = new Node(5);
        Node n5 = new Node(5);
        root.next = n1 ;n1.next = n2 ; n2.next = n3;n3.next = n4 ;n4 .next  = n5;
        Node result = new Solution24().deleteNum(root, 5);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
	}
}
