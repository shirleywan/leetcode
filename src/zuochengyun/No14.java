package zuochengyun;
import java.util.*;
import zuochengyun.util.*;
import zuochengyun.util.Node;
/**
 * 反转单向和双向链表
 */

class Solution14{
    /**
     *反转单向链表
     */
    public Node reverseSingle(Node root ){
        if (root == null || root.next == null){return root;}
        Node first = root ;
        Node p = first.next;
        while(p != null){
            root.next = p.next;
            p.next = first;
            first = p;
            p = root.next;
        }
        return first ;
    }
    /**
     *反转双向链表,要注意结尾处的处理
     */
    public DoubleNode reverseDouble(DoubleNode root ){
        if (root ==null || root.next ==null){return root ; }
        DoubleNode first = root;
        DoubleNode p = root.next;
        while(p != null){
            root.next = p.next;
            if (p.next == null){
                p.next = first;
                p.last = null;
                first.last = p;
                first = p;
                return first;
            }
            p.next.last = root ;
            p.next = first;
            p.last = null;
            first.last = p;
            first = p;
            p = root.next;
        }
        return first;
    }
}

public class No14 {
    public static void main(String[] args){
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        root.next = n1 ;n1.next = n2 ; n2.next = n3; n3.next = n4 ;
        Node result = new Solution14().reverseSingle( root );
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
        System.out.println("-------------------");
        DoubleNode head = new DoubleNode(5);
        DoubleNode n5 = new DoubleNode(6);
        DoubleNode n6 = new DoubleNode(7);
        DoubleNode n7 = new DoubleNode(8);
        head.next = n5; n5.next = n6; n6.next = n7;
        n7.last = n6;n6.last = n5; n5.last = head;
        DoubleNode doubleresult = new Solution14().reverseDouble(head);
        while(doubleresult != null){
            System.out.println(doubleresult.value);
            doubleresult = doubleresult.next ;
        }
    }
}
