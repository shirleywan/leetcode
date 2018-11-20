package HashTable;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *      Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *      Output: [2,2]
 * Example 2:
 *      Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *      Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1== null || nums1.length==0 || nums2 == null || nums2.length == 0) {
            int[] result = {};
            return result;
        }
        Map<Integer , Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int n : nums1){
            if(!map.containsKey(n)) {map.put(n , 1);}
            else{
                map.put(n , map.get(n)+1);
            }
        }
        for(int n : nums2){
            if(map.containsKey(n)){
                if(map.get(n) >= 1){list.add(n);}
                map.put(n , map.get(n)-1);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0 ; i < result.length ; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
public class No350IntersectionOfTwoArrayII {
    public static void main(String[] args){
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(Arrays.toString(new Solution350().intersect(num1 , num2)));
    }
}
