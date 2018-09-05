package zuochengyun;

import zuochengyun.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 */

class Solution35 {

}

public class No35 {
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

    }
}
