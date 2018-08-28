package leetcode;

/**
 *linked-list-cycle-ii
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 * Follow up:
 * Can you solve it without using extra space?
 */
import leetcode.util.ListNode;
import java.util.*;

class Solution9{
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){return null;}
        if(head.next == head ){return head;}
        ListNode p = head.next;
        ListNode q = head.next.next;
        while ( p != q){
            if(q == null) {return null;}
            q = q.next;
            if(q == null){return null;}
            q = q.next;
            p = p.next;
        }
        p = head;
        while( p != q){
            q = q.next;
            p = p.next;
        }
        return p;
    }
}
public class No9 {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2 ;n2.next = n1; //n3.next = n4;n4.next = n5;n5.next = n6;n6.next = n7;//n7.next = n3;
        ListNode result = new Solution9().detectCycle(n1);
        System.out.println(result.val);
    }
}
