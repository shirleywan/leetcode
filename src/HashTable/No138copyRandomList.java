package HashTable;
class Node{
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

/**
 *138. Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * Input:
 *      {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * Explanation:
 *      Node 1's value is 1, both of its next and random pointer points to Node 2.
 *      Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */
class Solution138 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node p = head;
        Node root = new Node(head.val , null ,null);
        while( p != null){
            Node node = new Node(p.val , p.next , null);
            p.next = node;
            p = p.next.next;
        }
        p = head ;
        while( p != null){
            p.next.random = p.random.next;
            p = p.next.next;
        }
        p = head.next;
        while(p != null){
            p.next = p.next.next;
            p = p.next.next;
        }
        return head.next;
    }
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
     * Memory Usage: 35.3 MB, less than 100.00% of Java online submissions for Copy List with Random Pointer.
     */
    public Node copyRandomList1(Node head) {
        if(head == null){
            return null;
        }
        Node prev = new Node(0,null,null);
        Node res = prev;
        while(head != null){
            Node curr = new Node(head.val, null, head.random);
            head.random = curr;
            prev.next = curr;
            prev = prev.next;
            head = head.next;
        }
        prev = res.next;
        while(prev != null){
            if(prev.random != null)
                prev.random = prev.random.random;
            prev = prev.next;
        }
        return res.next;
    }
}
public class No138copyRandomList {
    public static void main(String[] args){
        Node head = new Node(1, null , null);
        Node  n1  = new Node(2 , null , null);
        head.next = n1 ; head.random = n1;
        n1.next = null; n1.random = n1;
        Node node = new Solution138().copyRandomList(head);
        Node result = node;
        while(result != null){ System.out.println(result.val +" , " + result.random.val);result = result.next;}
    }
}
