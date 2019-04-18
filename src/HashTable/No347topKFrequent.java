package HashTable;

import java.util.*;

/**
 *347. Top K Frequent Elements
 * Given a non-empty array of integers, return the k most frequent elements.
 * Example 1:
 *      Input: nums = [1,1,1,2,2,3], k = 2
 *      Output: [1,2]
 * Example 2:
 *      Input: nums = [1], k = 1
 *      Output: [1]
 * Note:
 *      You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *      Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
class Solution347 {
    /**
     * Runtime: 1088 ms, faster than 5.04% of Java online submissions for Top K Frequent Elements.
     * Memory Usage: 46.3 MB, less than 5.05% of Java online submissions for Top K Frequent Elements.
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
//        if(k > nums.length || k <= 0) return null;
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return result;
        Map<Integer , Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums){
            if(map.containsKey(n)) map.put(n , map.get(n)+1);
            else map.put(n , 1);
        }
        int[] count = new int[map.size()];
        for(int i = 0 ; i < k ; i++) {
            int maxValue = nums[0];
            int maxCount = 0;
            for (int n : nums) {
                if (map.containsKey(n)) {
                    if (map.get(n) > maxCount) {
                        maxCount = map.get(n);
                        maxValue = n;
                    }
                }
            }
            result.add(maxValue);
            map.remove(maxValue);
        }
        return result;
    }

    /**
     * 先把hashmap中所有值加到list中，在逐渐删除出现次数较少的
     * Runtime: 23 ms, faster than 50.32% of Java online submissions for Top K Frequent Elements.
     * Memory Usage: 41 MB, less than 61.41% of Java online submissions for Top K Frequent Elements.
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : nums){
            if(map.containsKey(i))map.replace(i,map.get(i)+1);
            else if(!map.containsKey(i))map.put(i,1);
        }
        ArrayList<Integer> ans = new ArrayList();
        for(Integer key : map.keySet())ans.add(key);
        int count = 1;
        while(ans.size()>k){
            for(Integer key : map.keySet()){
                if(map.get(key)==count)ans.remove(key);
                if(ans.size()==k)break;
            }
            count++;
        }
        return ans;
    }
}
public class No347topKFrequent {
    public static void main(String[] args){
        int[] nums = {1};
        int k = 1;
        System.out.println(new Solution347().topKFrequent(nums , k));
    }
}
