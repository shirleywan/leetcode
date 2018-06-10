package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//class Solution27 {
//	/**
//	 * 这个想法和26题的好算法基本相同，重点是使用count作为内层的循环。
//	 */
//    public int removeElement(int[] nums, int val) {
//    	int count=0;  //注意count的用法，count++可以当作新的一个循环，覆盖掉原来的值，不需要申请新的数组。
//    	for(int n:nums) {
//    		if(n!=val) {
//    			nums[count]=n;
//    			count++;
//    		}
//    	}
//        return count;
//    }
//}
//其他想法
class Solution27{
	public int removeElement(int[] nums, int val) {
	    int i = 0;
	    int n = nums.length;
	    while (i < n) {
	        if (nums[i] == val) {
	            nums[i] = nums[n - 1];
	            // reduce array size by one
	            n--;
	        } else {
	            i++;
	        }
	    }
	    return n;
	}
}
public class removeElement {
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
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
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
//            int val = Integer.parseInt(line);
            int[] nums= {3};
            int val=3;
            int ret = new Solution27().removeElement(nums, val);
            String out = integerArrayToString(nums, ret);
            
            System.out.print(out);
//        }
    }
}
