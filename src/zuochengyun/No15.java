package zuochengyun;
import java.util.*;
import zuochengyun.util.Node;

/**
 * 反转部分单向链表
  */
class Solution15{
    /**
     * 反转部分单向链表
      */
    public Node reverseSingleBetween(Node root ,int from , int to){
        if (root == null || root.next == null || from >= to){return root;}
        Node first = root ;
        while(first.next.value != from && first.next!=null){
            first = first.next;
        }
        if (first.next.value == from && first.next.next==null){return root;}
        Node begin = first;
        first = first.next;
//        begin.next = null;
        Node p = first.next;
        while(p!=null && p.value != to){ //to可以大于最后一个元素，如果大于，直接反转全部
            first.next = p.next;
            p.next = begin.next;
            begin.next = p;
            p = first.next;
            
//            first = begin.next;
        }
        if(p!=null){
        	first.next = p.next;
            p.next = begin.next;
            begin.next = p;
        }
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
        Node result = new Solution15().reverseSingleBetween(root , 2 , 6);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
    }
}
