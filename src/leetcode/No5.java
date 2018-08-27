package leetcode;

import leetcode.util.ListNode;

import java.util.*;
/**
 * insertion-sort-list
 * Sort a linked list using insertion sort.
 */
class Solution5{
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){return head;}
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode p = head;
        ListNode q = first;
        ListNode last = p.next;
        while(p.next != null){
            q = first;
            last = p.next.next ;
            while( p.next.val > q.next.val && q != p) {
                q = q.next;
            }
            if(q == p){
                p = p.next;
            }
            else{
                p.next.next = q.next;
                q.next = p.next;
                p.next = last;
            }
//            System.out.println("p:" + p.val);
        }
        return first.next;
    }
}
public class No5 {
    public static void main(String[] args){
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(2);
        n1.next = n2 ;n2.next = n3; n3.next = n4; n4.next = n5;
        ListNode result = new Solution5().insertionSortList(n1);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
