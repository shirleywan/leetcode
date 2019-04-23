package DynamicProgramming;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Example 1:
 *      Input: [1,2,3,1]
 *      Output: 4
 *      Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *      Input: [2,7,9,3,1]
 *      Output: 12
 *      Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 */
class Solution198 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
     * Memory Usage: 35.5 MB, less than 92.14% of Java online submissions for House Robber.
     */
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        int[] arr = new int[nums.length+1];
        arr[0] = 0;
        arr[1] = nums[0];
        arr[2] = Math.max(nums[1], nums[0]);
        for(int i=3;i<arr.length;i++){
            arr[i] = Math.max(nums[i-1] + arr[i-2], arr[i-1]);
        }

        return arr[nums.length];
    }
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
     * Memory Usage: 35.4 MB, less than 92.14% of Java online submissions for House Robber.
     */
    public int rob1(int[] nums) {
        int[] maxArr = new int[nums.length];
        if(nums.length == 0) return 0;
        else if(nums.length == 1) return nums[0];
        else{
            maxArr[0] = nums[0];
            maxArr[1] = nums[1];
            for(int i=2;i<nums.length;i++){
                maxArr[i] = Math.max(maxArr[i-2]+nums[i], maxArr[i-1]-nums[i-1]+nums[i]);
            }
        }
        return Math.max(maxArr[nums.length-1],maxArr[nums.length-2]);
    }
}
public class No198rob {
    public static void main(String[] args){
        int[] nums = { 2,1,1,2 };
        System.out.println(new Solution198().rob(nums));
    }
}
