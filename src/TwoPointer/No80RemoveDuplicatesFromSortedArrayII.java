package TwoPointer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *      Given nums = [1,1,1,2,2,3],
 *      Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *      It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *      Given nums = [0,0,1,1,1,1,2,3,3],
 *      Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *      It doesn't matter what values are set beyond the returned length.
 */
class Solution80 {
    /**
     * two pointer:
     * 5ms, 88.13%
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int count = 0;
        int p = 0 ,q = 1;
        for( ; q < nums.length ;){
            if(nums[p] == nums[q]) {
                while (  q < nums.length && nums[p] == nums[q]) {
                    q++;
                }
                nums[count] = nums[count+1] = nums[p];
                count = count + 2;
                p = q;
                q++;
            }
            else{
                nums[count] = nums[p];
                count ++;
                p ++; q++;
            }

        }
        if(nums[nums.length-2] != nums[nums.length-1]) {
            nums[count] = nums[nums.length-1];
            count++;
        }
//        System.out.println(Arrays.toString(nums));
        return count;
    }
}
public class No80RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args){
        int[] nums = {1};
        System.out.println(new Solution80().removeDuplicates(nums));
    }
}
