package zuochengyun;
import java.util.*;

import zuochengyun.util.DoubleNode;
import zuochengyun.util.Node;
/**
 * 在单链表和双链表中删除倒数第 k 个节点
  */

class Solution12{
    /**
     * 设置两个指针，间隔为 k，当 q 到达最后是，p 就是要删除的节点
      */
    public Node deleteSingleKth(Node root , int k){
        if(root == null ) return null;
        if (k <= 0 ) return root;
        Node p = root ;
        Node q = root ;
        while(k > 0 ){
            q=q.next ; k -- ;
            if (q == null){ // 如果 k > 链表长度，则删除第一个
                 return root.next;
            }
        }
        while(q.next!=null){
            p = p.next ;
            q = q.next ;
        }
        p.next = p.next.next;
        return root;
    }

    /**
     * 双向链表与单链表处理方法相同，这里使用另一种方法处理，
     * 当节点向后移动 1 个时，k 减小 1，
     * 当 k > 0 时，不删除节点;
     *  k=0时，删除头节点；
     *  k<0时，再次从头遍历，当k = 0时就是待删除节点；
     */
    public DoubleNode deleteTwoKth(DoubleNode root , int k){
        if(root == null || k<= 0) return root;
        DoubleNode p = root ;
        while(p!=null){
            p = p.next;
            k -- ;
        }
        if( k > 0){return root;}
        else{
        	if (k == 0){ return root.next;}
        	else{
        		p = root;
        		while( k < -1 ){
        			p = p.next;
        			k++;
        		}
        		p.next = p.next.next;
        		if(p.next !=null){p.next.last = p;}
        		return root;
        	}
        }
    }
}

public class No12 {
    public static void main(String[] args){
        Node root = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        root.next = n1; n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        Node result = new Solution12().deleteSingleKth(root , 2);
        while(result!=null){
            System.out.println(result.value);
            result = result.next;
        }
        System.out.println("-------------------");
        DoubleNode node = new DoubleNode(0);
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        node.last  = null ; node.next  = node1;
        node1.last = node ; node1.next = node2;
        node2.last = node1; node2.next = null ;
        DoubleNode doubleNode = new Solution12().deleteTwoKth(node , 1);
        while(doubleNode!=null){
            System.out.println(doubleNode.value);
            doubleNode = doubleNode.next;
        }

    }
}
