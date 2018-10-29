package Stack;
import java.util.*;
/**
 * 496. Next Greater Element I
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 *
 * Example 1:
 *      Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 *      Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 *      Input: nums1 = [2,4], nums2 = [1,2,3,4].
 *      Output: [3,-1]
 * Explanation:
 *     For number 2 in the first array, the next greater number for it in the second array is 3.
 *     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 */
class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0){int[] result ={};return result;}
        int[] result = new int[nums1.length];
        int count = 0 ;
        boolean flag = false;
        for(int n : nums1){
            flag = false;
            for(int i = 0 ; i < nums2.length ; i++){
                if(nums2[i] == n){
                    while(i+1 < nums2.length){
                        if(nums2[i+1] > n){result[count] = nums2[i+1];count++;flag = true;break;}
                        i++;
                    }
                }
            }
            if(!flag){result[count] = -1 ; count++;}
        }
        return result;
    }
}
public class No496NextGreaterElementI {
    public static void main(String[] args){
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(new Solution496().nextGreaterElement(nums1 , nums2)));
    }
}
