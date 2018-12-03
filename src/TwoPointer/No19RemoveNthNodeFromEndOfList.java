package TwoPointer;

import utils.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *      Given linked list: 1->2->3->4->5, and n = 2.
 *      After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *      Given n will always be valid.
 * Follow up:
 *      Could you do this in one pass?
 */
class Solution19 {
    /**
     * 6ms,99.10%
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null ) return head;
        if(head.next == null && n ==1) return null;
        if(n == 0) return head;
        ListNode p = head;
        ListNode q = head;
        int i = 0;
        while( i < n) {q = q.next;i++;}
        if(q == null) return p.next;
        while(q.next != null) {q = q.next ; p = p.next;}
        p.next = p.next.next;
        return head;
    }

    /**
     * same idea
     * 9ms , 59.33%
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
public class No19RemoveNthNodeFromEndOfList {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2; n2.next = n3; //n3.next = n4;
        ListNode res = new Solution19().removeNthFromEnd(n1 , 3);
        while( res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
