package Tree;
import utils.TreeNode;
import java.util.*;

/**
 * 114. Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, given the following tree:
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
class Solution114 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
     * Memory Usage: 38.3 MB, less than 5.09% of Java online submissions for Flatten Binary Tree to Linked List.
     */
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null)
        {
            if (curr.left == null) // no left subtree, go right
                curr = curr.right;
            else
            {
                pre = curr.left; // find the left subtree's rightmost child
                while (pre.right != null && pre.right != curr)
                    pre = pre.right;
                if (pre.right == null) // first time found this child, tree not flattened yet
                {
                    pre.right = curr;     // store link to root
                    curr = curr.left;      // go left
                }
                else
                {  // we are back to our root
                    pre.right = curr.right; // link left rightmost child to the right child
                    curr.right = curr.left;  // left subtree already flattened
                    curr.left = null;          // delete old left
                    curr = pre.right;        // flatten right
                }
            }
        }
    }
    public List<Integer> preOrder(TreeNode root , List<Integer> list){
        if(root == null) return list;
        list.add(root.val);
        if(root.left != null) preOrder(root.left , list);
        if(root.right!= null) preOrder(root.right, list);
        return list;
    }
}
public class No114flatten {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);

        root.left  = n1;
        root.right = n2;
        n1.left  = n3;
        n1.right = n4;
        //n2.left = n4;
        n2.right = n5;

        List<Integer> list = new ArrayList<Integer>();
        new Solution114().flatten(root);
        System.out.println(new Solution114().preOrder(root , list));
    }
}
