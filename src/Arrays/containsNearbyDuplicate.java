package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution219 {
	/**
	 * 这句，我把新的之前出现过元素的索引替换旧的，是因为，这次比较，绝对值只差已经大于k;
	 * 因此如果后面还有新的元素的索引，可以和第二次出现的满足j-i<k，则满足条件，返回true；
	 * 如果改成：else {map.put(nums[i], i);}，那么将不会更新的索引值。
     *如：nums=【1，0，1，1】 k=1；结果是true，如果不更新，将只计算nums[2]=nums[0]----false
	 */
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
//    	for(int i=0;i<nums.length;i++) {
//    		if(map.containsKey(nums[i])) {
//    			if(Math.abs(map.get(nums[i])-i)<=k) {return true;}
//    		}
//    		map.put(nums[i], i);
//    	}
//        return false;
//    }
	/**
	 * 
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            set.add(nums[i]);
//            if(!set.add(nums[i])) return true;
        }
        System.out.println(set);
        return false;
 }
}

public class containsNearbyDuplicate {
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
//            line = in.readLine();
//            int k = Integer.parseInt(line);
            
    	    int[] nums= {1,2,3,4,1};
    	    int k=9;
            boolean ret = new Solution219().containsNearbyDuplicate(nums, k);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
//        }
    }
}
