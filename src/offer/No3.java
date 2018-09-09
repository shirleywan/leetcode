package offer;
/**
 * 从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个 ArrayList。
 */

import offer.util.ListNode;
import java.util.*;

class Solution3{
    /**
     *reverse list
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(head == null){return list;}
        if(head.next == null){list.add(head.val); return list;}
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int temp = 0;
        int n = list.size();
        for(int i = 0 ; i < n/2 ; i++){
            temp = list.get(i);
            list.set( i , list.get(n- 1 - i));
            list.set( n-1-i , temp);
        }
        return list;
    }

    /**
     *stack
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode head){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(head == null){return list;}
        if(head.next == null){list.add(head.val); return list;}
        Stack<Integer> stack = new Stack<Integer>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
public class No3 {
    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head.next = n1;n1.next = n2; n2.next = n3;n3.next = n4;
        System.out.println(new Solution3().printListFromTailToHead1(head));
    }
}
