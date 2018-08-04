package zuochengyun;

import zuochengyun.util.randomNode;
/**
 * 复制含有随机指针节点的链表
 */
class Solution19{
	public randomNode copy(randomNode head){
		if (head == null || head.next == null){ return head; }
		randomNode p = head;
		while( p != null){
			randomNode node = new randomNode(p.value);
			node.next = p.next ;
			p.next = node ;
			p = p.next.next;
		}
		p = head;
		randomNode headnew = head.next;
		while(p!=null){
			if( p.next.next == null ) break;
			if(p.rand == null){
				p.next.rand = null;
			}
			else{
				p.next.rand = p.rand.next;
			}
			p = p.next.next;
		}
		p = head;
		randomNode q = headnew;
		while( p != null){
			if(p.next.next == null) break ;
			p.next = q.next;
			q.next = p.next.next;
			p = p.next;
			q = q.next;
		}
		return headnew;
	}
}

public class No19 {
	public static void main(String[] args) {
		randomNode root = new randomNode(1);
        randomNode n1 = new randomNode(2);
        randomNode n2 = new randomNode(5);
        randomNode n3 = new randomNode(3);
        randomNode n4 = new randomNode(1);
        root.next = n1 ;n1.next = n2 ; n2.next = n3; n3.next = n4 ;
        root.rand = n2 ; n2.rand = n4;
        randomNode result = new Solution19().copy(root);
        while(result != null){
        	if(result.rand != null){
        		System.out.println(result.rand.value);
        	}
        	else {System.out.println("null");}
            result = result.next ;
        }
	}
}
