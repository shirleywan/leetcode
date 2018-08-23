package leetcode;

/**
 * sort-list
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 用归并排序
 */
import java.util.*;
import leetcode.util.*;
class Solution4 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {return head;}
        ListNode p = head ;
        ListNode q = head.next;
        while( q != null){
            q = q.next;
            if(q != null){
                p = p.next;
                q = q.next;
            }
        }
        ListNode mid = p.next;
        p.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
    }
    public ListNode merge(ListNode head , ListNode mid){
        ListNode p = head;
        ListNode q = mid;
        ListNode first = new ListNode(0);
        ListNode pointer = first;
        while( q != null && p != null){
            if(p.val > q.val){
                pointer.next = q;pointer = pointer.next; q = q.next;
            }
            else{
                pointer.next = p;p = p.next;pointer = pointer.next;
            }
        }
        if( p == null){pointer.next = q;}
        if( q == null){pointer.next = p;}
        return first.next;
    }
}
public class No4 {
    public static void main(String[] args){
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
//        ListNode n4 = new ListNode(2);
//        ListNode n5 = new ListNode(1);
        n1.next = n2 ;n2.next = n3; //n3.next = n4; n4.next = n5;
//        ListNode result = new Solution4().merge(n1,n2);
//        while (result!= null){
//            System.out.println(result.val);
//            result = result.next;
//        }

        ListNode result = new Solution4().sortList(n1);
        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}
