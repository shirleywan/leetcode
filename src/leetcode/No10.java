package leetcode;

/**
 * linked-list-cycle
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 */
import leetcode.util.ListNode;

class Solution10{
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){return false;}
        if(head.next == head){return true;}
        ListNode p = head.next;
        ListNode q = head.next.next;
        while( p != q){
            if( q == null ){return false;}
            q = q.next;
            if( q == null ){return false;}
            q = q.next;
            p = p.next;
        }
        return true;
    }
}

public class No10 {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2 ;n2.next = n3; //n3.next = n4;n4.next = n5;n5.next = n6;n6.next = n7;//n7.next = n3;
        System.out.println(new Solution10().hasCycle(n1));
    }
}
