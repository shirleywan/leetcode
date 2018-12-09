package TwoPointer;

/**
 * 209. Minimum Size Subarray Sum
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * Example:
 *      Input: s = 7, nums = [2,3,1,2,4,3]
 *      Output: 2
 *      Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 *      If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
class Solution209 {
    /**
     * 计算加和；
     * Runtime: 3 ms, faster than 50.37% of Java online submissions for Minimum Size Subarray Sum.
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int sum = 0;
        int p = 0 ;
        int q = 0;
        for( int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
        }
        if(sum < s) return 0;
        sum = 0 ;
        for( ; q< nums.length ; ){
            sum += nums[q];
            if(sum >= s){
                while( p <= q && sum - nums[p] >= s){
                    sum -= nums[p];p++;
                }
                len = Math.min( q- p + 1 , len);
                q++;
            }
            else{
                q++;
            }
        }
        return len;
    }
    /**
     *Runtime: 3 ms, faster than 50.37% of Java online submissions for Minimum Size Subarray Sum.
     */
    public int minSubArrayLen1(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int sum = 0;
        int p = 0 ;
        int q = 0;
        boolean flag = false;
        for( ; q< nums.length ; ){
            sum += nums[q];
            if(sum >= s){
                flag = true;
                while( p <= q && sum - nums[p] >= s){
                    sum -= nums[p];p++;
                }
                len = Math.min( q- p + 1 , len);
                q++;
            }
            else{
                q++;
            }
        }
        if(!flag) return 0;
        return len;
    }
    /**
     * good method -- 更慢
     * 和我的想法一样，但是写法更好；
     */
    public int minSubArrayLen2(int s, int[] nums) {

        if(nums.length==0)
            return 0;
        int minLength=nums.length+1,i=0,j=0,sum=nums[0];


        while(j<nums.length)
        {
            if(sum==s)
            {
                minLength=Math.min(minLength,j-i+1);

            }
            if(sum<s)
            {
                j++;
                if(j<nums.length)
                    sum=sum+nums[j];
            }
            else
            {
                minLength=Math.min(minLength,j-i+1);
                sum=sum-nums[i];
                i++;
            }

        }
        if(minLength==nums.length+1)
            return 0;

        return minLength;
    }
}
public class No209MinimunSizeSubarraySum {
    public static void main(String[] args){
        int s = 6;
        int[] nums = {10,2,3};
        System.out.println(new Solution209().minSubArrayLen(s , nums));
    }
}
