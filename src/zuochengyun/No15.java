package zuochengyun;
import java.util.*;
import zuochengyun.util.Node;

/**
 * 反转部分单向链表
 */
class Solution15{
    /**
     *反转部分单向链表
     */
    public Node reverseSingleBetween(Node root ,int from , int to){
        if (root == null || root.next == null || from >= to){return root;}
        Node first = root ;
        while(first.next.value != from ||first.next!=null){
            first = first.next;
        }
        Node begin = first;
        first = first.next;
        begin.next = null;
        Node p = first.next;
        while(p.value != to){
            first.next = p.next;
            p.next = first;
            begin.next = p;
            p = first.next;
        }
        first.next = p.next;
        p.next = first;
        begin.next = p;

        return root ;
    }
}
public class No15 {
    public static void main(String[] args){
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        root.next = n1 ;n1.next = n2 ; n2.next = n3; n3.next = n4 ;
        Node result = new Solution15().reverseSingleBetween(root , 2 , 4);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
    }
}
