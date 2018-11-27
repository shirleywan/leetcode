package TwoPointer;

import utils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
class Solution234 {
    /**
     * 翻转后半部分链表
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode p = head;
        ListNode q = head.next;
        while(q != null){
            q = q.next ;
            if(q != null) {
                p = p.next ;
                q = q.next;
            }
        }
        q = p.next;
        ListNode m = q.next;
        while(m != null){
            q.next = m.next;
            m.next = p.next;
            p.next = m;
            m =q.next;
        }
        q = p.next;
        p = head;
        while(p != null && q != null){
            if(p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
    /**
     * method 2：空间换时间
     * 但是运行时间更慢
     */
    public boolean isPalindrome1(ListNode head) {

        ListNode tmp = head;

        List<Integer> arr = new ArrayList<Integer>();

        while(tmp != null) {
            arr.add(tmp.val);
            tmp = tmp.next;
        }

        int j = arr.size()-1;
        int i = 0;
        while(i < arr.size() && j >=0) {

            if((int)arr.get(i) == (int)arr.get(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }


        return true;
    }
}

public class No234PalindromeLinkedList {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);

        n1.next = n2; n2.next = n3;// n3.next = n4;
        System.out.println(new Solution234().isPalindrome(n1));
    }
}
