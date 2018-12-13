package Tree;

import utils.TreeNode;

/**
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 * Output: true
 *
 * Example 2:
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 *
 * Example 3:
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
class Solution100 {
    /**
     * Runtime: 3 ms, faster than 70.06% of Java online submissions for Same Tree.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null ) return true;
        if((p == null && q != null) || ( p != null && q == null)) return false;
        boolean flag = false;
        if( p.val != q.val ) return false;
        else{
            flag = isSameTree(p.left , q.left);
            if( flag ){
                flag = isSameTree(p.right , q.right);
            }
        }
        return flag;
    }
    /**
     * good method :写法更好；
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Same Tree.
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {


        if(p!=null && q!=null){
            if(p.val == q.val)
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            else
                return false;
        }else if(p==null && q==null)
            return true;
        else
            return false;

    }
}
public class No100SameTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);

        root.left = n1;
        n1.left = n2;

        TreeNode root1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(1);

        root1.left = n3;
        //n3.right = n4;
        System.out.println(new Solution100().isSameTree(root , root1));
    }
}
