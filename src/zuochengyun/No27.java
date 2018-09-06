package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;
/**
 * 一种特殊的删除：不给定头结点而删除某个节点
 */
class Solution27{
	public void delete (Node node ){
		if(node == null) {return;}
		Node next = node.next;
		if(next == null){
			node = null;
		}
		node.value = next.value ;
		node.next = next.next;
	}
}

public class No27 {
	public static void main(String[] args) {
		Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(6);
        Node n4 = new Node(7);
        Node n5 = new Node(5);
        root.next = n1 ;n1.next = n2 ; n2.next = n3;n3.next = n4 ;n4 .next  = n5;
        new Solution27().delete(root);
        while(root != null){
            System.out.println(root.value);
            root = root.next ;
        }
	}
}
