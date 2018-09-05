package zuochengyun;

import zuochengyun.util.Node;

import java.util.*;

/**
 * 在二叉树中找到累加和为指定值的最长路径长度
 * 时间复杂度O(N),空间复杂度O(h)
 */

class Solution36 {
    public int getMaxLength(Node head , int sum){
        HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
        map.put(0,0);
        return preOrder(head , sum , 0 ,1, 0 ,map);
    }
    public int preOrder (Node head , int sum , int preSum , int level , int maxlen , HashMap<Integer, Integer> map){
        return maxlen;
    }
}

public class No36 {
    public static void main(String[] args) {


    }
}
