package leetcode;

/**
 * reorder-list
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * You must do this in-place without altering the nodes' values.
 * For example, Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * 反转后半部分链表 + 两个链表合并
 */

import leetcode.util.ListNode;
import java.util.*;
class Solution8{
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {return;}
        ListNode p = head;
        ListNode q = head.next;
        while(q.next != null ){
            q = q.next;
            if( q.next != null){
                p = p.next;
                q = q.next;
            }
        }
        ListNode mid = p.next;
        p.next = null;
        ListNode first = new ListNode(0);
        first.next = mid;
        q = mid.next;
        while(q != null){
            mid.next = q.next;
            q.next = first.next;
            first.next = q;
            q = mid.next;
        }
        //检查反转链表
//        ListNode result = first;
//        while (result != null){
//            System.out.println(result.val);
//            result = result.next;
//        }
        p = head;
        q = first.next;
        while(p !=null && q != null){
            first.next = q.next;
            q.next = p.next;
            p.next = q;
            p = (p.next.next == null ?p.next:p.next.next);
            q = first.next;
        }
//        if(first.next != null){p.next = first.next;}
    }
}
public class No8 {
    public static void main(String[] args){
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(5);
       // ListNode n5 = new ListNode(2);
        n1.next = n2 ;n2.next = n3; n3.next = n4;// n4.next = n5;
        new Solution8().reorderList(n1);
        ListNode result = n1;
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
