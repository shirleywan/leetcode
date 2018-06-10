package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/**
 * 1.Two Sum
 */
class Solution1{
	public int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}
}
//class Solution1 {
//    public int[] twoSum(int[] nums, int target) {
//        int i,j;
//        int[] count=new int[2];
//        for(i=0;i<nums.length;i++) {
//        	for(j=i+1;j<nums.length;j++) {
//        		if(nums[i]+nums[j]==target) {
//        			count[0]=i;count[1]=j;
//        			return count;
//        		}
//        	}
//        }
//        return count;
//    }
//}

public class twoSum {
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
    
    public static String integerArrayToString(int[] nums, int length) {
        String result = "";
        if (length == 0) {
            return result;
        }
    
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return result.substring(0, result.length() - 2);
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] nums = stringToIntegerArray(line);
//            line = in.readLine();
//            int target = Integer.parseInt(line);
            int[] nums= {-1,-2,-3,-4,-5};
            int target=-8;
            int[] ret = new Solution1().twoSum(nums, target);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
//        }
    }
}