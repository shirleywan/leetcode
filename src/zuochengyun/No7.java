package zuochengyun;

import java.util.*;

/**
 * 生成窗口最大值数组
 */
class Solution7{
    public int[] windowMaxArray(int[] nums , int n){
        if( n <=0 || nums.length ==0){return null;}
        int[] array = new int[nums.length-n+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(nums[0]);
        int i = 0;
        int count = 0;
        n = Integer.min(nums.length,n);
        for( i=1; i < n ; i++){
            if(nums[i]>queue.peek()){queue.offer(nums[i]);}
            else{queue.offer(queue.peek());}
            queue.poll();
        }
        array[count] = queue.peek();
        for ( ; i<nums.length ; i++){
            if(nums[i]>queue.peek()){queue.offer(nums[i]);}
            else{queue.offer(queue.peek());}
            array[count++]=queue.poll();
        }
        return array;
    }
}
public class No7 {
    public static void main(String[] args){
        int[] nums = {4,3,5,4,3,3,6,7};
        int n = 3;

    }
}
