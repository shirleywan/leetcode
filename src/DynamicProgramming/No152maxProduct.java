package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 152. Maximum Product Subarray
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * Example 1:
 *      Input: [2,3,-2,4]
 *      Output: 6
 *      Explanation: [2,3] has the largest product 6.
 * Example 2:
 *      Input: [-2,0,-1]
 *      Output: 0
 *      Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
class Solution152 {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int max = nums[0];
        int mul = 1;
//        List<Integer> list = new ArrayList<Integer>();
        for(int n : nums){
            if(n == 0) {
                mul = 1;
                max = Math.max( max, 0);
            }
            else {
                mul = mul* n;
                if (mul > max) max = mul;
            }

        }
        return max;
    }
    /**
     * Runtime: 1 ms, faster than 98.17% of Java online submissions for Maximum Product Subarray.
     * Memory Usage: 37.6 MB, less than 13.83% of Java online submissions for Maximum Product Subarray.
     */
    public int maxProduct1(int[] a) {
        int min = a[0], max = a[0], bool = a[0];

        for(int i = 1; i < a.length; i++) {
            if(a[i] < 0)
                max=min+max-(min=max);
            max = Math.max(a[i], max*a[i]);
            min = Math.min(a[i], min*a[i]);

            bool = Math.max(max, bool);
        }
        return bool;
    }
}
public class No152maxProduct {
    public static void main(String[] args){
        int[] nums = {3,-1,4};
        System.out.println(new Solution152().maxProduct(nums));
    }
}
