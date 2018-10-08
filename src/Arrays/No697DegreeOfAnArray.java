package Arrays;

/**
 * 697. Degree of an Array
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 *  Input: [1, 2, 2, 3, 1]
 *  Output: 2
 *  Explanation:
 *      The input array has a degree of 2 because both elements 1 and 2 appear twice.
 *      Of the subarrays that have the same degree:
 *      [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 *      The shortest length is 2. So return 2.
 *
 * Example 2:
 *  Input: [1,2,2,3,1,4,2]
 *  Output: 6
 *
 *  nums.length will be between 1 and 50,000.
 *  nums[i] will be an integer between 0 and 49,999.
 */

import java.util.*;
class Solution697 {
    /**
     * opinion : 用map实现桶排序
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        if(nums.length == 0 || nums.length ==1){return nums.length;}
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        int max = 1;

        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                ArrayList<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i] , list);
                if(list.size() > max){max = list.size();}
            }
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i] , list);
            }
        }
//        System.out.println(map.toString());
//        System.out.println(max);
        int count = Integer.MAX_VALUE;
        for(int n : nums){
            if(map.get(n).size() >= max){
                ArrayList<Integer> list = map.get(n);
                if(list.get(list.size()-1) - list.get(0)+1 < count){count = list.get(list.size()-1) - list.get(0)+1;}
            }
        }
        return count;
    }
}
public class No697DegreeOfAnArray {
    public static void main(String[] args){
        int[] nums = {1,2,2,3,1,4,2};
        //hard test : {2,1,1,2,1,3,3,3,1,3,1,3,2};
        System.out.println(new Solution697().findShortestSubArray(nums));
    }
}
