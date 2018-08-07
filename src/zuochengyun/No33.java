package zuochengyun;

import zuochengyun.util.TreeNode;
import java.util.*;

/**
 * 较为直观地打印二叉树 - p100
 */

class Solution3{
    public void printErchaTree(root){
    }
}

public class No33{
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
        System.out.println(new Solution33().printErchaTree(root));
    }
}
