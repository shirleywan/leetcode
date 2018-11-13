package Stack;

import java.util.Arrays;

/**
 * 503. Next Greater Element II
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * Example 1:
 *      Input: [1,2,1]
 *      Output: [2,-1,2]
 *      Explanation: The first 1's next greater number is 2;
 *                   The number 2 can't find next greater number;
 *                   The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */
class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        if(nums == null || nums.length == 0){return nums;}
        int[] temp = new int[nums.length*2];
        int n = nums.length;
        boolean flag = false;
        for(int i = 0 ; i < nums.length ; i++){
            temp[i] = nums[i];
        }
        for(int i = 0 ; i < nums.length ; i++){
            temp[i+n] = nums[i];
        }
        for(int i = 0 ; i < nums.length ; i++){
            result[i] = -1;
            for(int j = i+1 ; j < temp.length; j++){
                if(nums[i] < temp[j]) {result[i] = temp[j];flag = true; break;}
            }
        }
        return result;
    }
}
public class No503NextGreaterElementII {
    public static void main(String[] args){
        int[] nums = {1 , 2 , 1 };
        System.out.println(Arrays.toString(new Solution503().nextGreaterElements(nums)));
    }
}
