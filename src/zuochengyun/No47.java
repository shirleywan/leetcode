package zuochengyun;
/**
 * 判断一棵树是不是平衡二叉树和搜索二叉树
 */

import zuochengyun.util.TreeNode;

import java.util.ArrayList;

class Solution47{
    public boolean isComplete(TreeNode root){
        if(root == null){return true;}
        boolean flag = true;
        isBSTTree(root , 1 , flag);
        return flag;
    }
    public int isBSTTree(TreeNode root , int level , boolean flag){
        if(root == null) {return level;}
        int lh = isBSTTree(root.left , level +1 , flag);
        if(root.left != null){
            if (root.left.value > root.value){flag = false;}
        }
        if(!flag) {return level;}
        int rh = isBSTTree(root.right , level +1 , flag);
        if(root.right != null){
            if (root.right.value < root.value){flag = false;}
        }
        if(!flag) {return level;}
        if(Math.abs(lh - rh) < 1) {flag = false;}
        return Math.max(lh , rh);
    }
}

public class No47 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
//        TreeNode n6 = new TreeNode(7);

        root.left = n1; root.right = n3;
//        n1.left = n6;
        n1.left = n2;
        n3.left = n4; n3.right = n5;

        ArrayList<Integer> list = new ArrayList<Integer>();
        Solution47 solution = new Solution47();
        System.out.println(solution.isComplete(root));
    }
}
