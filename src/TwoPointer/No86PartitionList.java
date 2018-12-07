package TwoPointer;

import leetcode.util.ListNode;

/**
 * 86. Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * Example:
 *      Input: head = 1->4->3->2->5->2, x = 3
 *      Output: 1->2->2->4->3->5
 */
class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode p = first;
        ListNode q = p.next;
        while(q != null){
            if(q.val >= x){
                if(q.next == null) break;
                while( q .next != null && q.next.val >= x) { q = q.next ; }
                ListNode n = q.next;
                if( n != null){
                    q.next = n.next;
                }
                else{ q.next = null;}
//                m.next = (n.next != null ? n.next : null);
                n.next = p.next;
                p.next = n;
                p = p.next;
                q = q.next;
            }
            else{
                q = q.next;
                p = p.next;
            }
        }
        return first.next;
    }

    /**
     * good method
     */
    public ListNode partition1(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        boolean moveHead = true;
        ListNode firstMoved = null;
        while (curr != null && curr.next != null && curr != firstMoved) {
            ListNode next = curr.next;
            if (curr.val >= x) {
                if (firstMoved == null)
                    firstMoved = curr;
                last.next = curr;
                curr.next = null;
                last = curr;
                if (prev != null)
                    prev.next = next;
            } else {
                moveHead = false;
                prev = curr;
            }

            curr = next;
            if (moveHead) {
                head = curr;
            }
        }

        return head;
    }
}
public class No86PartitionList {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2 ; n2.next = n3 ; n3.next = n4 ; n4.next = n5; n5.next = n6 ;

        ListNode result = new Solution86().partition(n1 , 0);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
