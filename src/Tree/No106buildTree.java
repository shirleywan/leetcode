package Tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 *      You may assume that duplicates do not exist in the tree.
 *      For example, given
 *      inorder = [9,3,15,20,7]
 *      postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
class Solution106 {
    /**
     * Runtime: 30 ms, faster than 5.92% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     * Memory Usage: 45.6 MB, less than 5.79% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     * Like No105 , my answer
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if((inorder == null && postorder == null)||(inorder.length == 0 && postorder.length == 0)) return null;
        return subTree(inorder, postorder ,0 , inorder.length-1 , 0 , postorder.length-1);
    }
    public TreeNode subTree(int[] inorder, int[] postorder , int inBegin,int inEnd , int postBegin , int postEnd){
        if(inBegin > inEnd || postBegin > postEnd) return null;
        if(inBegin == inEnd && postBegin == postEnd) return new TreeNode(inorder[inBegin]);
        TreeNode root = new TreeNode(postorder[postEnd]); //该子树的根节点
        System.out.println(root.val);
        int inbegin = inBegin;

        while(inbegin <= inEnd ){ //找到根节点在中序遍历中的位置，确定左右子树序列
            if(inorder[inbegin] == postorder[postEnd]) break;
            inbegin ++ ;
        }

        int postend = postBegin+inbegin-inBegin;
        root.left = subTree(inorder , postorder ,inBegin , inbegin-1 , postBegin , postend-1);
        root.right= subTree(inorder , postorder ,inbegin+1 , inEnd, postend , postEnd-1);
        return root;
    }
    public List<Integer> preOrder(TreeNode root , List<Integer> list){
        if(root == null) return list;
        list.add(root.val);
        if(root.left != null) preOrder(root.left , list);
        if(root.right!= null) preOrder(root.right, list);
        return list;
    }
}
public class No106buildTree {
    public static void main(String[] args){
        int[] inorder  = {3,15,20,7};
        int[] postorder= {15,7,20,3};
        TreeNode root = new Solution106().buildTree(inorder , postorder);
        List<Integer> list = new ArrayList<Integer>();
        System.out.println(new Solution106().preOrder(root , list));
    }
}
