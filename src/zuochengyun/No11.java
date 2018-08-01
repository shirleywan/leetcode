package zuochengyun;
import java.util.*;

/**
 * 打印两个有序链表的公共部分
 */
class Solution11{
    public ArrayList<Integer> printCommon(Node root1 , Node root2){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root1 == null || root2 == null){return list;}
        while(root1!=null && root2!=null){
            if(root1.value < root2.value) {root1 = root1.next;}
            if(root1.value > root2.value) {root2 = root2.next;}
            else{
                list.add(root1.value);
                root1 = root1.next; root2 = root2.next;
            }
        }
        return list;
    }
}
public class No11 {
    public static void main(String[] args){
        Node root1 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        root1.next = n1; n1.next = n2; n2.next = n3; n3.next = n4;
        Node root2 = new Node(1);
        Node n5 = new Node(3);
        root2.next = n5;
        System.out.println(new Solution11().printCommon(root1 , root2));
    }
}
