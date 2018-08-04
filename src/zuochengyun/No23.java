package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;
/**
 * 删除无序单链表中值重复出现的节点
 */
class Solution23{
	/**
	 * 方法一：哈希表，时间O(N) ,空间 O(N)
	 */
	public Node delete1( Node head ){
		if(head == null || head.next == null) { return head ; }
		Map<Integer , Node> map = new HashMap<Integer , Node>();
		map.put(head.value, head);
		Node p = head.next;
		Node last = head;
		while( p != null){
			if(!map.containsKey(p.value)){ map.put(p.value, p); last.next = p; last = p;}
			//注意这种删除节点的方式
			p = p.next;
		}
		last.next = null; //注意：保证删除的后面节点不会留下指针，影响到返回结果
		return head;
	}
	/**
	 * 方法二：类似于排序，确定一个node后判断后面是否有这个值，时间O(N^2) ,空间 O(N)
	 * 这里不能使用数组排序，是因为如果排序了，链表顺序即会改变
	 */
	public Node delete2( Node head ){
		if(head == null || head.next == null) { return head ; }
		Node last = head;
		Node p = last;
		while(last != null){
			p = last;
			while ( p.next != null){
				if(p.next.value == last.value){p.next = p.next.next;}
				else{ p = p.next ;}
			}
			last = last.next;
		}
		
		return head;
	}
	
}

public class No23 {
	public static void main(String[] args) {
		Node root = new Node(1);
        Node n1 = new Node(1);
        Node n2 = new Node(5);
        Node n3 = new Node(5);
        Node n4 = new Node(5);
        root.next = n1 ;n1.next = n2 ; n2.next = n3;n3.next = n4 ;
        Node result = new Solution23().delete1(root);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
        System.out.println("------------------");
        result = new Solution23().delete2(root);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
	}
}
