package TwoPointer;

import java.util.Arrays;
import java.util.MissingFormatArgumentException;

/**
 * 75. Sort Colors
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *      Note: You are not suppose to use the library's sort function for this problem.
 * Example:
 *      Input: [2,0,2,1,1,0]
 *      Output: [0,0,1,1,2,2]
 * Follow up:
 *      1. A rather straight forward solution is a two-pass algorithm using counting sort.
 *         First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 *      2. Could you come up with a one-pass algorithm using only constant space?
 */
class Solution75 {
    /**
     * easy solution : count num
     */
    public void sortColors(int[] nums) {
        if( nums == null || nums.length == 0 ) return;
        int count0 = 0 ;
        int count1 = 0;
        for(int n : nums ){
            if( n == 0 ) count0++;
            else if(n == 1) count1 ++;
        }
        int i = 0 ;
        for(i = 0 ; i < count0 ; i++){
            nums[i] = 0;
        }
        for( ; i < count0+ count1 ; i++){
            nums[i] = 1;
        }
        for( ; i < nums.length; i++){
            nums[i] = 2;
        }
    }
    /**
     * good idea : 三个指针，实现排序；
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
     */
    public void sortColors2(int[] nums) {

        if (nums.length <1) {
            return;
        }

        int low =-1;
        int mid = -1;
        int high = nums.length;
        int temp;
        while(mid+1 < high) {

            if (nums[mid+1] < 1) {
                // swap mid+1 and low+1
                temp = nums[mid+1];
                nums[mid+1] = nums[low+1];
                nums[low+1] = temp;
                mid++;
                low ++;
            } else if (nums[mid+1] == 1) {
                mid++;
            } else {
                // greater thn one
                //swap mid+1 and high-1;

                temp = nums[mid+1];
                nums[mid+1] = nums[high-1];
                nums[high-1] = temp;
                high--;

            }
        }
    }
}
public class No75SortColors {
    public static void main(String[] args){
        int[] nums = {2,0,2,2,1,1,2,0,1};
        new Solution75().sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
