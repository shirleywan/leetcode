package zuochengyun;

import zuochengyun.util.TreeNode;

import java.util.*;

/**
 * 在二叉树中找到累加和为指定值的最长路径长度
 * 时间复杂度O(N),空间复杂度O(h)
 */

class Solution36 {
    public int getMaxLength(TreeNode head , int sum){
        HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
        map.put(0,0);
        return preOrder(head , sum , 0 ,1, 0 ,map);
    }
    public int preOrder (TreeNode head , int sum , int preSum , int level , int maxlen , HashMap<Integer, Integer> map){
        if(head == null ) {return maxlen;}
        int curSum = preSum +head.value;
        if(!map.containsKey(curSum)){
            map.put( curSum , level);
        }
        if(map . containsKey(curSum - sum)){
            maxlen = Math.max(level - map.get(curSum - sum) , maxlen);
        }
        maxlen = preOrder( head.left,sum , curSum , level +1 , maxlen , map);
        maxlen = preOrder( head.right,sum , curSum , level +1 , maxlen , map);
        if(level == map.get(curSum)){
            map.remove(curSum);
        }
        return maxlen;
    }
}

public class No36 {
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
        
        Solution36 solution = new Solution36();
        System.out.println(solution.getMaxLength(root , 6));

    }
}
