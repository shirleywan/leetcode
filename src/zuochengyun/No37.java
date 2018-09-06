package zuochengyun;

import zuochengyun.util.TreeNode;

import java.util.HashMap;

/**
 * 找到二叉树中的最大搜索二叉子树 -- 未完成
 * 时间复杂度O(N),空间复杂度O(h)
 */

class Solution37 {

}

public class No37 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);

        root.left = n1; root.right = n3;
        n1.right = n2;
        n3.left = n4; n3.right = n5;
        
        Solution37 solution = new Solution37();


    }
}
