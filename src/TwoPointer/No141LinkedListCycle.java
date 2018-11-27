package TwoPointer;

import utils.ListNode;

/**
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
class Solution141 {
    /**
     * 设置两个指针，如果有环，则一定会在一个地方两个指针的指向相同
     * 2ms ， 28.28%
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode p = head;
        ListNode q = head.next;
        while(q != null){
            if(p == q) return true;
            q = q.next;
            if(q == null){ return false;}
            else{
                q = q.next;
                p = p.next;
            }
        }
        return false;
    }

    /**
     * good method ：
     * 将遍历过的点，val设置为0，如果再遍历到val为0的点，则视为重复
     * 0ms，100.00%
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode curr = head;
        while (curr != null && curr.val == 0) {
            curr.val = 1;
            curr = curr.next;
        }
        curr = head;
        while (curr != null && curr.val != 0) {
            curr.val = 0;
            curr = curr.next;
            if (curr != null && curr.val == 0) {
                return true;
            }
        }
        return false;
    }
}
public class No141LinkedListCycle {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);

        n1.next = n2; n2.next = n3; n3.next = n4;  n4.next = n1;
        System.out.println(new Solution141().hasCycle(n1));
    }
}
