package TwoPointer;

import utils.ListNode;

/**
 * 142. Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * Note: Do not modify the linked list.
 * others: https://leetcode.com/problems/linked-list-cycle-ii/
 */
class Solution142 {
    /**
     *1 ms, faster than 48.56% of Java online submissions for Linked List Cycle II.
     * 2A = A + N;
     * N是指从相交点到重复循环点的长度；A是起始点到交叉点
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null ) return null;
        ListNode p = head;
        ListNode q = head;
        while( q != null) {
            q = q.next;
            if( q == null) {
                return null;
            }
            else{
                q = q.next;
                p = p.next;
            }
            if( q == null) return null;
            if( p ==q ){break;}
        }
        p = head;
        while( p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
    /**
     * better writting method :
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
public class No142LinkedListCycleII {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2; n2.next = n3; n3.next = n4; //n4.next = n1;
        ListNode result = new Solution142().detectCycle(n1);
        System.out.println(result.val);
    }
}
