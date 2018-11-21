package HashTable;

import java.util.*;

/**
 * 18. 4Sum
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
class Solution18 {
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        if(nums==null || nums.length < 4) return null;
        List<List<Integer>> total = new ArrayList<List<Integer>>();
        int i = 0 , j = i+1 , k = i+2 , m = i+3;
        Arrays.sort(nums);
        for(; i <nums.length-4;){
            if(nums[i] + nums[j]+nums[k] + nums[m] == target){
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[i]);list.add(nums[j]);list.add(nums[k]);list.add(nums[m]);
                if(!total.contains(list)) total.add(list);
            }
            else{
                if(nums[i] + nums[j]+nums[k] + nums[m] < target){
                    m++;
                }
            }
        }
        return null;
    }

    /**
     * method 2：2层for循环+2sum
     */
    public List<List<Integer>> fourSum(int[] nums, int target) { // i和j是循环的，后两位使用2sum的计算方法；
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // &&是截断的；
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        m++;
                        n--;
                        while (m < n && nums[m] == nums[m - 1]) m++;
                        while (m < n && nums[n] == nums[n + 1]) n--;
                    } else if (sum > target) {
                        n--;
                    } else {
                        m++;
                    }
                }
            }
        }
        return results;
    }

    /**
     *加了限制的2层for循环 + 2Sum
     * 16ms , faster than 95.44%
     */
    public List<List> fourSum2(int[] nums, int target) {
        List<List> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if(len < 4 || nums[0] + nums[1] + nums[2] + nums[3] > target
                || nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4] < target)
            return result;
        for( int i = 0;i < len - 3 &&
                nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] <= target ;i++)
            for(int j = i + 1; j < len - 2 &&
                    nums[i] + nums[j] + nums[j + 1] + nums[j + 2] <= target;j++) {
                int k = j + 1,t = len - 1,temp = target - nums[i] - nums[j];
                while(k < t)
                    if(nums[k] + nums[t] == temp) {
                        List res = Arrays.asList(nums[i] ,nums[j],nums[k],nums[t]);
                        if(!result.contains(res))
                            result.add(res);
                        k++; t--;
                    }
                    else if(nums[k] + nums[t] < temp) k++;
                    else t--;
            }
        return result;
    }
}
public class No184Sum {
    public static void main(String[] args){
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new Solution18().fourSum(nums , target));
    }
}
