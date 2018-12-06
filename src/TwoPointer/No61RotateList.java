package TwoPointer;

import utils.ListNode;

/**
 * 61. Rotate List
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *      Input: 1->2->3->4->5->NULL, k = 2
 *      Output: 4->5->1->2->3->NULL
 *      Explanation:
 *      rotate 1 steps to the right: 5->1->2->3->4->NULL
 *      rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *      Input: 0->1->2->NULL, k = 4
 *      Output: 2->0->1->NULL
 *      Explanation:
 *      rotate 1 steps to the right: 2->0->1->NULL
 *      rotate 2 steps to the right: 1->2->0->NULL
 *      rotate 3 steps to the right: 0->1->2->NULL
 *      rotate 4 steps to the right: 2->0->1->NULL
 */
class Solution61 {
    /**
     * one pointer
     * Runtime: 7 ms, faster than 94.27% of Java online submissions for Rotate List.
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null ) return head;
        ListNode p = head;
        int count = 1;
        while(p.next != null){p = p.next ; count++;}
        k = k % count;
        if( k == 0) return head;
        p.next = head;
        p = head;
        int num = 0;
        while( num < count - k - 1){
            p = p.next ;
            num ++ ;
        }
        ListNode q = p.next;
        p.next = null;
        return q;
    }
    /**
     * k = k % count;
     * 441 ms, faster than 0.99% of Java online submissions for Rotate List.
     */
    public ListNode rotateRight1(ListNode head, int k) {
        if(head == null || head.next == null ) return head;
        ListNode p = head;
        int count = 1;
        while(p.next != null){p = p.next ; count++;}

        if( k % count == 0) {return head;}
        else{
            while( k - count > 0){
                k = k - count;
            }
        }

        p.next = head;
        p = head;
        int num = 0;
        while( num < count - k - 1){
            p = p.next ;
            num ++ ;
        }
        ListNode q = p.next;
        p.next = null;
        return q;
    }
}
public class No61RotateList {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2; n2.next = n3; //n3.next = n4;
        ListNode result = new Solution61().rotateRight(n1 , 4);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
