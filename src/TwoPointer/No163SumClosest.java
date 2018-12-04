package TwoPointer;

import javax.swing.text.AbstractDocument;
import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *      Given array nums = [-1, 2, 1, -4], and target = 1.
 *      The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
class Solution16 {
    /**
     * O(n*n)
     * 10ms , 94.73%
     */
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null && nums.length < 3) return 0;
        int sum = nums[0];
        Arrays.sort(nums);
        int dis = nums[0] + nums[1] + nums[2] -target;
        if(dis >= 0) { return dis+target; }
        if(nums[nums.length -1] +nums[nums.length -2] +nums[nums.length -3] < target)
            return nums[nums.length -1] +nums[nums.length -2] +nums[nums.length -3];
        for(int i = 0 ; i < nums.length-2 ; i++){
            if(nums[i] + nums[i+1]+nums[i+1] > target) {
                sum = nums[i] + nums[i+1]+nums[i+1] -target;
                dis = Math.abs(dis) > Math.abs(sum) ? sum : dis;
                break;
            }
            for(int j= i+1 , k= nums.length-1 ; j<k; ){
                sum = nums[i] + nums[j] + nums[k] - target;
                if(sum > 0) {
                    k--;
                    dis = Math.abs(dis) > Math.abs(sum) ? sum : dis;}
                else {
                    if (sum < 0) {
                        j++;
                        dis = Math.abs(dis) > Math.abs(sum) ? sum : dis;
                    }
                    if( sum == 0){ return target; }
                }
            }
        }
        return dis + target;
    }

    /**
     * good solution 1:
     * w/2 Sum; -- 更慢 。。
     * 18ms, 33.49%
     */
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int dist = Integer.MAX_VALUE;
        int min_sum = 0;
        for(int i = 0; i < nums.length-2; i++){
            int l = i + 1;
            int r = nums.length-1;
            while(l < r){
                int currentDist = Math.abs(target - (nums[i]+nums[l]+nums[r]));
                int currentSum = (nums[i]+nums[l]+nums[r]);
                if(currentSum == target)
                    return target;
                if(currentDist < dist){
                    dist = currentDist;
                    min_sum = currentSum;
                }
                if(currentSum < target)
                    l++;
                else if(currentSum > target)
                    r--;
            }
        }
        return min_sum;
    }
}
public class No163SumClosest {
    public static void main(String[] args){
        int[] nums = {-1 , 0,1,7};
        int target = 2;
        System.out.println(new Solution16().threeSumClosest(nums , target));
    }
}
