package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;
/**
 * 两个单链表相交的一系列问题
  */
class Solution21{
	
}
public class No21 {
	public static void main(String[] args) {
		Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(5);
        Node n3 = new Node(3);
        Node n4 = new Node(8);
        root.next = n1 ;n1.next = n2 ; //n2.next = n3;
        n3.next = n4 ;
        Node result = new Solution20().add2(root, n3);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
	}
}
