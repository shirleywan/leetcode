package Tree;
import java.util.*;
import utils.*;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 *      You may assume that duplicates do not exist in the tree.
 *      For example, given
 *
 *      preorder = [3,9,20,15,7]
 *      inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
class Solution105 {
    /**
     * Runtime: 33 ms, faster than 5.08% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     * Memory Usage: 45.4 MB, less than 5.06% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if((preorder == null && inorder == null)||(preorder.length == 0 && inorder.length == 0)) return null;
        if(preorder.length == 1 && inorder.length == 1 && preorder[0] == inorder[0]){
            return new TreeNode(preorder[0]);
        }

        return subTree(preorder, inorder ,0 , preorder.length-1 , 0 , inorder.length-1);
    }
    public TreeNode subTree(int[] preorder, int[] inorder , int preBegin,int preEnd , int inBegin , int inEnd){
        if(preBegin > preEnd || inBegin > inEnd) return null;
        if(preBegin == preEnd && inBegin == inEnd) return new TreeNode(preorder[preBegin]);
        TreeNode root = new TreeNode(preorder[preBegin]); //该子树的根节点
        System.out.println(root.val);
        int inbegin = inBegin;

        while(inbegin <= inEnd ){ //找到根节点在中序遍历中的位置，确定左右子树序列
            if(inorder[inbegin] == preorder[preBegin]) break;
            inbegin ++ ;
        }

        int preend = preBegin+inbegin-inBegin;
        root.left = subTree(preorder , inorder , preBegin+1 , preend , inBegin , inbegin-1);
        root.right= subTree(preorder , inorder , preend+1 , preEnd, inbegin+1 , inEnd);
        return root;
    }
    /**
     * tree preOrder
     */
    public List<Integer> preOrder(TreeNode root , List<Integer> list){
        if(root == null) return list;
        list.add(root.val);
        if(root.left != null) preOrder(root.left , list);
        if(root.right!= null) preOrder(root.right, list);
        return list;
    }
    /**
     * similar idea with good expression
     * Runtime: 9 ms, faster than 35.52% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     * Memory Usage: 37.2 MB, less than 88.96% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     */
    public TreeNode buildTreeMethod1(int[] preorder, int[] inorder) {
        return helperMethod1(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helperMethod1(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helperMethod1(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right= helperMethod1(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
    /**
     * another good method, but not understand
     * Runtime: 5 ms, faster than 60.18% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     * Memory Usage: 42.6 MB, less than 5.98% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     */
    public TreeNode buildTree2(int[] preorder , int[] inorder){
        int n = preorder.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) pos.put(inorder[i], i);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for (int i = 1; i < n; i++) {
            Integer value = preorder[i];
            TreeNode node = new TreeNode(value);
            if (pos.get(value) < pos.get(stack.peek().val)) stack.peek().left = node;
            else {
                TreeNode parent = null;
                while (!stack.isEmpty() && pos.get(value) > pos.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }
}
public class No105buildTree {
    public static void main(String[] args){
        int[] preorder = {3,20,15,7};
        int[] inorder  = {3,15,20,7};
        TreeNode root = new Solution105().buildTree(preorder , inorder);
        List<Integer> list = new ArrayList<Integer>();
        System.out.println(new Solution105().preOrder(root , list));
    }
}
