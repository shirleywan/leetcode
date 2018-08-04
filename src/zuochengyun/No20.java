package zuochengyun;

import java.util.*;
import zuochengyun.util.Node;
/**
 * 两个单链表生成相加链表
 * 注意：要考虑进位
 */

class Solution20{
	/**
	 * 方法一：用栈实现
	 */
	public Node add1( Node head1 , Node head2){
		if(head1 ==null && head2 == null){return null;}
		if(head1 ==null || head2 == null){return (head1 == null ? head2:head1);}
		Stack<Integer> stack1 =new Stack<Integer>();
		Stack<Integer> stack2 =new Stack<Integer>();
		Node p = head1;
		int count1 = 0;
		while(p != null){
			stack1.push(p.value);
			p = p.next;
			count1 ++ ;
		}
		Node q = head2;
		int count2 = 0;
		while(q != null){
			stack2.push(q.value);
			q = q.next;
			count2 ++;
		}
		count1 = Math.max(count1 , count2); 
		Node[] nodes = new Node[count1];
		int num1 = 0;
		int num2 = 0;
		int flag = 0;
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			count1 -- ;
			num1 = 0 ; num2 = 0; 
			if(!stack1.isEmpty()){num1 = stack1.pop();}
			if(!stack2.isEmpty()){num2 = stack2.pop();}
			Node node = new Node((num1 + num2 + flag)%10);
			if((num1 + num2) >9){ flag = 1;}
			else{flag = 0;}
			nodes[count1] = node;
		}
		for (int i = 0 ; i < nodes.length-1 ; i++){
			nodes[i].next = nodes[i+1];
		}
		return nodes[0];
	}
	
	/**
	 * 方法二：两个链表逆序后相加，形成新链表
	 */
	public Node add2( Node head1 , Node head2){
		if(head1 ==null && head2 == null){return null;}
		if(head1 ==null || head2 == null){return (head1 == null ? head2:head1);}
		Node p = head1.next;
		Node first = head1;
		while( p != null){
			head1.next = p.next;
			p.next = first;
			first = p;
			p = head1.next;
		}
		head1 = first;
		p = head2.next;
		first = head2;
		while( p != null){
			head2.next = p.next;
			p.next = first;
			first = p;
			p = head2.next;
		}
		head2 = first;
		p = head1 ;
		Node q = head2;
		int num1 = 0;
		int num2 = 0;
		int flag = 0; //注意，进位标志
		List<Node> list = new ArrayList<Node>();
		while( p != null || q != null){
			num1 = 0 ; num2 = 0;
			if( p != null) { num1 = p.value ; p = p.next ; }
			if( q != null) { num2 = q.value ; q = q.next ; }
			Node node = new Node((num1 + num2 + flag)%10);
			if((num1 + num2) >9){ flag = 1;}
			else{flag = 0;}
			list.add(node);
		}
		//注意，这时list中放入的node顺序是反的
		for (int i = list.size()-1 ; i > 0 ; i -- ){
			list.get(i).next = list.get(i-1); 
		}
		return list.get(list.size()-1);
	}
}

public class No20 {
	public static void main(String[] args) {
		Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(5);
        Node n3 = new Node(3);
        Node n4 = new Node(8);
        root.next = n1 ;n1.next = n2 ; //n2.next = n3;
        n3.next = n4 ;
        Node result = new Solution20().add2(root, n3);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
	}

}
