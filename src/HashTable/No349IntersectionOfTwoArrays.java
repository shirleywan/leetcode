package HashTable;

import java.lang.reflect.Array;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *      Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *      Output: [2]
 * Example 2:
 *      Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *      Output: [9,4]
 * Note:
 *      Each element in the result must be unique.！！！
 *      The result can be in any order.
 */
class Solution349{
    /**
     * method 1 : two pointer
     * 9ms , 12.68%
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            int[] result = {};
            return result;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p = 0 , q = 0;
        List<Integer> list = new ArrayList<>();
        for( ; p < nums1.length && q < nums2.length ; ){
            if(nums1[p] == nums2[q]) {
                if(!list.contains(nums1[p])) list.add(nums1[p]);
                p++;q++;
            }
            else{
                if(nums1[p] < nums2[q]) p++;
                else q++;
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0 ; i < result.length ; i++){
            result[i] = list.get(i);
        }
        return result;
    }
    /**
     * method 2 : hashmap
     * 7ms , 16.82%
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        if(nums1== null || nums1.length==0 || nums2 == null || nums2.length == 0) {
            int[] result = {};
            return result;
        }
        Map<Integer , Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int n : nums1){
            if(!map.containsKey(n)) {map.put(n , 1);}
        }
        for(int n : nums2){
            if(map.containsKey(n)){
                if(!list.contains(n)) list.add(n);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0 ; i < result.length ; i++){
            result[i] = list.get(i);
        }
        return result;
    }
    /**
     * method 3 : hashset
     * O(n) -- 2ms , 98.72%
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}
public class No349IntersectionOfTwoArrays {
    public static void main(String[] args){
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(Arrays.toString(new Solution349().intersection(num1 , num2)));
    }
}
