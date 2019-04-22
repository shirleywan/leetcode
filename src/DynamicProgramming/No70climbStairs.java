package DynamicProgramming;

/**
 * 70. Climbing Stairs -- easy
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * Example 1:
 *   Input: 2
 *   Output: 2
 *   Explanation: There are two ways to climb to the top.
 *     1. 1 step + 1 step
 *     2. 2 steps
 * Example 2:
 *   Input: 3
 *   Output: 3
 *   Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
class Solution70 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 31.7 MB, less than 100.00% of Java online submissions for Climbing Stairs.
     */
    public int climbStairs(int n) {
        if( n == 0 ) return 1;
        if( n == 1 ) return 1;
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        for(int i = 2 ; i < n+1 ; i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }
    /**
     * better writting style:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 31.6 MB, less than 100.00% of Java online submissions for Climbing Stairs.
     */
    public int climbStairs1(int n) {
        int pre = 1;
        int res = 0;
        int prepre = 0;
        for(int i = 0; i< n; i++){
            res = prepre + pre;
            prepre = pre;
            pre = res;
        }
        return res;
    }
}
public class No70climbStairs {
    public static void main(String[] args){
        int n = 44 ;
        System.out.println(new Solution70().climbStairs(n));
    }
}
