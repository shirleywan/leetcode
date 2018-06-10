package test;

import test.Link.Node;

public class linkMy {
	class Node{
		Node next=null;
		int num;
		public Node(int nums){
			this.num=nums;
		}
	}
	Node head=null;
	
    public void add(int d) {
        Node newNode = new Node(d);// 实例化一个节点
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

	
	
	public static void main(String[] args) {
		linkMy link=new linkMy();
		link.add(6);
		System.out.println(link);
	}
}
