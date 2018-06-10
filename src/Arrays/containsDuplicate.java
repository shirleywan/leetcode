package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution217 {
	/**
	 * 使用HashMap实现，记录每个元素出现的次数；
	 * @param nums
	 * @return
	 */
//    public boolean containsDuplicate(int[] nums) {
//        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
//        for(int n:nums) {
//        	if(map.containsKey(n)) {map.put(n, map.get(n)+1);}
//        	else{map.put(n, 1);}
//        }
//        for(int n:nums) {
//        	if(map.get(n)>1) {return true;}
//        }
//        return false;
//    }
	/**
	 * Time complexity: O(N^2), memory: O(1)
	 * @param nums
	 * @return
	 */
//	public boolean containsDuplicate(int[] nums) {
//
//        for(int i = 0; i < nums.length; i++) {
//            for(int j = i + 1; j < nums.length; j++) {
//                if(nums[i] == nums[j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
	/**
	 * Time complexity: O(NlgN), memory: O(1)
	 * @param nums
	 * @return
	 */
//	public boolean containsDuplicate(int[] nums) {
//
//        Arrays.sort(nums);  //this method can used directly;
//        for(int ind = 1; ind < nums.length; ind++) {
//            if(nums[ind] == nums[ind - 1]) {
//                return true;
//            }
//        }
//        return false;
//    }
	/**
	 * 人家用HashMap都比你用的好，注意这种写法！！
	 * @param nums
	 * @return
	 */
//	public boolean containsDuplicate(int[] nums) {
//
//	    final Set<Integer> distinct = new HashSet<Integer>();
//	    for(int num : nums) {
//	        if(distinct.contains(num)) {
//	            return true;
//	        }
//	        distinct.add(num);
//	    }
//	    return false;
//	}
	/**
	 * 另一种Set--HashMap
	 */
	public  boolean containsDuplicate(int[] nums) {
		 Set<Integer> set = new HashSet<Integer>();
		 for(int i : nums)
			 if(!set.add(i))// if there is same
				 return true; 
		 return false;
	 }
    
}

public class containsDuplicate {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] nums = stringToIntegerArray(line);
            int[] nums= {1,1};
            boolean ret = new Solution217().containsDuplicate(nums);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
//        }
    }
}