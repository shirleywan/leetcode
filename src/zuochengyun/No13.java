package zuochengyun;
import java.awt.*;
import java.util.*;
import zuochengyun.util.Node;
/**
 * 删除链表的中间节点和a/b处的节点
 */
class Solution13{
    /**
     *删除链表的中间节点
     */
    public Node deleteMiddle(Node root){
        if (root == null ||root.next == null){return root;}
        Node p = root;
        Node q = root.next.next;
        if (q == null) return root.next;
        while(q!=null){
            q = q.next;
            if (q == null || q.next == null) break;
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return root;
    }
    /**
     *删除链表a/b处的节点
     */
    public Node deleteBetweenAB(Node root , int a ,int b){
        if(root == null || a < 1 || a > b){return root;}
        int n = 0;
        Node p = root ;
        while( p != null){
            n ++ ;
            p = p.next;
        }
        n = (int)Math.ceil(((double)(a * n))/(double) b);//ceil向上取整
        if (n == 1) {return root.next;}
        if (n > 1){
            p = root ;
            while( (n--) > 1){
                p = p.next;
            }
            p.next = p.next.next;
        }
        return root;
    }
}

public class No13 {
    public static void main(String[] args){
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(7);
        root.next = n1 ;n1.next = n2 ; n2.next = n3;
        n3.next = n4 ; //n4.next = n5; //n5.next = n6;
        Node result = new Solution13().deleteMiddle(root);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
        System.out.println("-------------------");
        result = new Solution13().deleteBetweenAB(root , 1 , 5);
        while(result != null){
            System.out.println(result.value);
            result = result.next ;
        }
    }
}
