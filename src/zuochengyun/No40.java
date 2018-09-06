package zuochengyun;

import zuochengyun.util.TreeNode;

import java.util.ArrayList;

/**
 * 调整搜索二叉树中两个错误的节点
 */

class Solution40 {
    /**
     * 调整搜索二叉树中两个错误的节点
     */
    public TreeNode[] getTwoErrNodes(TreeNode root){
        TreeNode[] nodes = new TreeNode[2];
        if(root == null || (root.left == null && root.right == null)) {return nodes;}
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list = midOrder(root , list);
        int count = 0;
        for(int i = 0 ; i <list.size()-1 ; i++){
            if(list.get(i).value > list.get(i+1).value){
                if(count %2 == 0){
                    nodes[count] = list.get(i);count ++;
                }
                else{
                    nodes[count] = list.get(i+1);count++;
                }
            }
        }
        return nodes;
    }
    public ArrayList<TreeNode> midOrder(TreeNode root , ArrayList<TreeNode> list){
        if(root == null){return list;}
        if(root.left != null){list = midOrder(root.left , list);}
        list.add(root);
        if(root.right != null){list = midOrder(root.right , list);}
        return list;
    }
}

public class No40 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(6);

        root.left = n1; root.right = n3;
        n1.right = n2;
        n3.left = n4; n3.right = n5;
        
        Solution40 solution = new Solution40();
        TreeNode[] nodes= solution.getTwoErrNodes(root);
        System.out.println(nodes[0].value +"," +nodes[1].value);
        //test midOrder
//        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
//        list = solution.midOrder(root ,list);
//        for(int i = 0 ; i< list.size() ; i++){
//            System.out.println(list.get(i).value);
//        }

    }
}
