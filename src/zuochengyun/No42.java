package zuochengyun;

import zuochengyun.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断t1树是否包含t2树拓扑结构完全相同的子树
 * 时间复杂度O(M) 和 O(M + N)两种方法
 */

class Solution42 {
    /**
     *层次遍历找到根节点，再递归比较节点和左右子节点是否相同；
     * 时间复杂度O(M),更高效
     */
    public boolean contains(TreeNode root , TreeNode head){
        if(root == null || head == null) {return false;}
        TreeNode node =null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node.left != null){queue.offer(node.left);}
            if(node.right != null){queue.offer(node.right);}
            if(node.value == head.value){break;}
        }
        return check(node,head);
    }
    public boolean check(TreeNode root , TreeNode head){
        if(root == null && head == null){return true;}
        boolean flag = false;
        if(root != null && head!= null){
            if(root.value == head.value ){
                flag = true;
            }
            else flag = false;
        }
        if((root == null && head != null) || (root != null && head == null)){flag = false;}
        return flag && check(root.left , head.left) && check(root.right ,head.right);
    }
    /**
     * 方法二：序列化，比较子树序列是否是原树序列的子串，string.contains(str)即可
     * 时间复杂度O(M + N)
     */
    public boolean isContain(TreeNode root , TreeNode head){
        if(root == null ){return false;}
        if(root != null && head == null){return true;}
        String str1 = "";
        String str2 = "";
        str1 = serialize(root , str1);
        str2 = serialize(head , str2);
        System.out.println("root : " + str1);
        System.out.println("head : " + str2);
        return str1.contains(str2);
    }
    public String serialize(TreeNode root , String string){
        if(root == null){string += "#!"; return string;}
        string = string + root.value;
        string = serialize(root.left , string);
        string = serialize(root.right , string);
        return string;
    }
    //为什么要用KMP算法？直接用某字符串是否包含某子串即可
    public boolean KMP(String string , String str){

        return false;
    }
}

public class No42 {
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

        TreeNode head = new TreeNode(5);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(6);
        head.left = n6;head.right = n7;
        
        Solution42 solution = new Solution42();
        //method 1:
        System.out.println(solution.contains(root, head));
        System.out.println("------------------");
        //method 2:
        String string = "";
        System.out.println(solution.isContain(root,head));

    }
}
