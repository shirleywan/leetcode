package DynamicProgramming;

import java.rmi.server.RemoteServer;
import java.security.interfaces.RSAKey;
import java.util.HashMap;
import java.util.Map;

/**
 * 213. House Robber II
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *      Input: [2,3,2]
 *      Output: 3
 *      Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *      Input: [1,2,3,1]
 *      Output: 4
 *      Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
class Solution213 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = nums[1];
        for(int i = 2 ; i < nums.length ; i++){
            result[i] = Math.max(result[i-1], result[i-2]+nums[i]);
        }
        return result[result.length-1];
    }

    /**
     * good solution
     * Runtime: 1 ms, faster than 66.26% of Java online submissions for House Robber II.
     * Memory Usage: 35.7 MB, less than 94.44% of Java online submissions for House Robber II.
     */
    // Two maps for each range 0 - n-2, 1 - n-1
    Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
    Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();

    public int rob1(int[] nums) {
        // Trivial cases
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2 ) return Math.max(nums[0], nums[1]);

        // Solve for 2 ranges 0 - n-2 & 0 - n-1 and get the max
        return Math.max(solve(nums, 0, nums.length-2), solve(nums, 1, nums.length-1));
    }

    private int solve(int[] nums, int start, int end) {
        //Basecases
        if(start == end) return nums[end];
        if(start == end-1) return Math.max(nums[end-1], nums[end]);

        // Get the right map based on which range we are working on
        Map<Integer, Integer> map = end == nums.length-2 ? map1 : map2;
        if(map.containsKey(start)) return map.get(start);

        int val = Math.max(solve(nums, start+1, end), solve(nums,start+2,end)+nums[start]);
        map.put(start, val);
        return val;
    }
}
public class No213rob {
    public static void main(String[] args){
        int[] nums = {2,3,2};
        System.out.println(new Solution213().rob(nums));
    }
}
