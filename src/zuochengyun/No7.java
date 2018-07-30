package zuochengyun;

import java.util.*;

/**
 * 生成窗口最大值数组
 * 这里注意，LinkedList类就是双向链表，有First和Last两个方向；
  */
class Solution7{
    public int[] windowMaxArray(int[] nums , int n){
        if( n <= 0 || nums.length ==0){return null;}
        int[] array = new int[nums.length-n+1];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        int i = 0;
        int count = 0;
        n = Integer.min(nums.length,n);
        for( i=1; i < n ; i++){
            if(nums[i]<nums[queue.peekLast()]){queue.offer(i);}
            else{
            	while(!queue.isEmpty()){
            		queue.poll();
            	}
            	queue.offer(i);
            }
        }
        array[count] = nums[queue.peek()];
        for ( i = n; i<nums.length ; i++){
            if(queue.peekFirst() + n <= i ){queue.pollFirst();}
//            if(queue.isEmpty()){queue.offer(i);continue;}
            if(nums[i] <= nums[queue.peekFirst()]){
            	if(nums[i] <= nums[queue.peekLast()]){queue.offer(i);}
                else{
                	while(nums[i]>nums[queue.peekLast()]){
                		queue.pollLast();
                	}
                	queue.offer(i);
                }
            }
            else{
            	while(!queue.isEmpty()){
            		queue.pollFirst();
            	}
            	queue.offerFirst(i);
            }
            count++;
            array[count] =nums[queue.peek()];
        }
        return array;
    }
}
public class No7 {
    public static void main(String[] args){
        int[] nums = {4,3,5,2,4,3,6,7};
        int n = 3;
        int[] array = new Solution7().windowMaxArray(nums, n);
        System.out.println(Arrays.toString(array));
    }
}
