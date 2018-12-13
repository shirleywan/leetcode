package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 *      The solution set must not contain duplicate triplets.
 * Example:
 *      Given array nums = [-1, 0, 1, 2, -1, -4],
 *      A solution set is:
 *      [
 *          [-1, 0, 1],
 *          [-1, -1, 2]
 *      ]
 */
class Solution15 {
    /**
     * Runtime: 60 ms, faster than 57.30% of Java online submissions for 3Sum.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0 ;
        for(; i < nums.length-2 ; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int mid = i+1 , last = nums.length-1;
            if(nums[i] + nums[mid] + nums[mid+1] > 0 ) break;
            while(  mid < last  ){
                if(nums[i] + nums[mid] + nums[last] < 0) mid++;
                else{
                    if(nums[i] + nums[mid] + nums[last] > 0) last--;
                    else{
                        result.add(Arrays.asList(nums[i] , nums[mid],nums[last]));
                        while (mid < last && nums[mid] == nums[mid+1]) mid++;
                        while (mid < last && nums[last] == nums[last-1]) last--;
                        mid++;last--;
                    }
                }
            }
        }
        return result;
    }
    /**
     * good idea：考虑重复
     * Runtime: 69 ms
     * note：LinkedList 与 arraylist的区别：
     * ArrayList 内部是使用可増长数组实现的，所以是用 get 和 set 方法是花费常数时间的，但是如果插入元素和删除元素，除非插入和删除的位置都在表末尾，否则代码开销会很大，因为里面需要数组的移动。
     * LinkedList 是使用双链表实现的，所以 get 会非常消耗资源，除非位置离头部很近。但是插入和删除元素花费常数时间。
     */
    public List<List<Integer>> threeSum1(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
public class No153Sum {
    public static void main(String[] args){
        int[] nums = {-2,0,0,2,2};
        System.out.println(new Solution15().threeSum(nums));
    }
}
