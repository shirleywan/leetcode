package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */


// Definition for singly-linked list.
//class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }
 
class Solution83 {
//    public ListNode deleteDuplicates(ListNode head) {
//    	if(head==null || head.next==null){return head;}
//    	ListNode list=new ListNode(head.val);//新链表
//
//		boolean flag=false;
//    	while(head!=null){
//    		ListNode pointer=list;//从前向后找
//    		flag=false;
//    		while(pointer.next!=null){
//    			if(pointer.val==head.val){flag=true;break;}
//    			pointer=pointer.next;
//    			System.out.println(pointer.val);
//    		}
//    		if(!flag){
//    			ListNode node=new ListNode(head.val);
//    			pointer.next=node;
//    		}
//    		head=head.next;
//    	}
//        return list;
//    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}

public class deleteDuplicates83 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            ListNode head = stringToListNode(line);
    	ListNode head = stringToListNode("[1,1,2,2,3]");
            ListNode ret = new Solution83().deleteDuplicates(head);
            
            String out = listNodeToString(ret);
            
            System.out.print(out);
//        }
    }
}