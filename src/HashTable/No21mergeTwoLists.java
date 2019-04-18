package HashTable;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

/**
 * Definition for singly-linked list.
 */ 
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution21 {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//    	if(l1==null && l2==null) return null;
//    	if(l1==null && l2!=null) return l2;
//    	if(l1!=null && l2==null) return l1;
//    	ListNode temp=new ListNode(0);
//    	ListNode list = temp;
//    	
//    	list.val= l1.val<l2.val ? l1.val:l2.val;
////    	if(l1.val<l2.val){list.val=l2.val;l2=l2.next;}
////    	else{if(l1.val==l2.val){list.val=l1.val;l1=l1.next;
////    				       list.next=new ListNode(l2.val);list=list.next;l2=l2.next;}
////    		 else{list.val=l1.val;l1=l1.next;}
////    	}
//    	while(l1!=null && l2!=null){
//    		if(l1.val>l2.val){list.next=new ListNode(l2.val);list=list.next;l2=l2.next;}
//    		if(l1.val==l2.val){list.next=new ListNode(l1.val);list=list.next;l1=l1.next;
//    		                  list.next=new ListNode(l2.val);list=list.next;l2=l2.next;}
//    		else{list.next=new ListNode(l1.val);list=list.next;l1=l1.next;}
//    	}
//    	return temp;
//    }
	/**
	 * good-idea1:
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		ListNode temp=new ListNode(0);
		if(l1.val<l2.val){temp.val=l1.val;temp.next=mergeTwoLists(l1.next, l2);}
		else{temp.val=l2.val;temp.next=mergeTwoLists(l1, l2.next);}
		return temp;
	}

}

public class No21mergeTwoLists {
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
//            ListNode l1 = stringToListNode(line);
//            line = in.readLine();
//            ListNode l2 = stringToListNode(line);
    	    ListNode l1=stringToListNode("[1,3,4]");
    	    ListNode l2=stringToListNode("[1,2,4]");
            ListNode ret = new Solution21().mergeTwoLists(l1, l2);
            
            String out = listNodeToString(ret);
            
            System.out.print(out);
 //       }
    }
} 