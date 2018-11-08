package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 456. 132 Pattern
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * Note: n will be less than 15,000.
 *
 * Example 1:
 *      Input: [1, 2, 3, 4]
 *      Output: False
 *      Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 *      Input: [3, 1, 4, 2]
 *      Output: True
 *      Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 *      Input: [-1, 3, 2, 0]
 *      Output: True
 *      Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
class Solution456 {
    /**
     * method 1:过不去测试用例
     */
    public boolean find132pattern1(int[] nums) {
        if(nums == null || nums.length == 0){return false;}
        Stack<Integer> stack = new Stack<Integer>();
        boolean flag = false;
        int min = nums[0];
        int max= nums[0];
        for(int n : nums){
            if(stack.isEmpty()){ stack.push(n) ; continue;}
//            System.out.println( n+"," +stack.toString());
//            System.out.println("max" +max);
            if(!flag && n < stack.peek()){
                stack.pop();
                stack.push(n);
                min = n;
            }
            else{
                if(!flag && n > stack.peek()){
                    stack.push(n);
                    flag = true;
                    max = n;
                }
                else{
                    if(flag && n > max){stack.pop();stack.push(n); max = n;}
                    else{
                        if(flag && n > min && n < max){return true;}
                        else{
                            stack.push(n);
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     * method 2 ：参考，很好
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length, top = n, third = Integer.MIN_VALUE;
        //int i=4,j,k;
        //j=i--;    //i先赋值给j，然后i在执行i=i-1;
        //k=--i;    //i先执行i=i-1，然后再赋值给;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) return true; //是否小于这个第二小的值，如模式里的2
            while (top < n && nums[i] > nums[top]) third = nums[top++]; //先把nums[top]的值赋给third，在执行top++；
            nums[--top] = nums[i];
            System.out.println(i+" , "+third+" , "+Arrays.toString(nums));
        }

        return false;
    }
}
public class No456132Pattern {
    public static void main(String[] args){
        int[] nums = {-1 , 3 , -1 , 5 , 4};
        //{3,5,0,3,4} -- true
        //{-1 , 3 , -1 , 5 , 4} -- true
        //{-2,1,1} -- false
        //[8,10,4,6,5] -- true
        System.out.println(new Solution456().find132pattern(nums));
    }
}
