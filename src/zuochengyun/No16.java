package zuochengyun;

import java.util.*;
import zuochengyun.util.*;
import zuochengyun.util.Node;

/**
 * 环形单链表的约瑟夫问题 -- P43
 */

class Solution16{
    /**
     * easy question
     */
    public Node JospheCircle1(Node head , int k){
        if(head == null || head.next == null){return null;}
        int count = 2;
        Node p = head;
        while(head.next != head){
            while( count < k && head.next != head){
                p = p.next;
                count ++;
            }
            p.next = p.next.next;
            head = p;
            p = p.next;
            count = 2;
        }
        return head;
    }

    /**
     * easy question
     */
    public Node JospheCircle2(Node head , int k){
        if(head == null || head.next == null){return null;}
        Node p = head.next;
        int count = 0;
        while ( p.next != head){
            count ++ ;
            p = p.next ;
        }
        count = getNum (count , k);
        while( -- count != 0 ){
            head = head.next;
        }
        head.next = head;
        return head;
    }
    public int getNum (int count , int k){
        if (count == 1 ) return 1;
        return (getNum(count-1 , k) + k -1 ) % count +1;
    }
}

public class No16 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(4);
        Node n3 = new Node(6);
        Node n4 = new Node(5);
        Node n5 = new Node(7);
        head.next = n1 ;n1.next = n2 ; n2.next = n3;n3.next = n4 ;n4 .next  = n5;n5.next = head;
        Node result = new Solution16().JospheCircle1(head, 3);
        System.out.println(result.value);
    }
}
