package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * No.26 Remove Duplicates from Sorted Array
 * @author admin
 *
 */
//∫√œÎ∑®£∫
class Solution26{
	public int removeDuplicates(int A[]) {
	        if(A.length < 2) return A.length;
	        int id = 1;
	        for(int i = 1; i < A.length; ++i) 
	            if(A[i] != A[i-1]) A[id++] = A[i];
	        return id;
	    }
}

//class Solution26 {
//    public int removeDuplicates(int[] nums) {
//    	if(nums.length==0) {
//    		return 0;
//    	}
//    	int count=1;
//    	int max=nums[0];
//    	for(int i=1;i<nums.length;i++) {
//    		for(int n :nums) {
//    			if(n>max) {
//    				nums[i]=n;
//    				max=n;
//    				count++;
//    				break;
//    			}
//    		}
//    	}
//    	return count;
//    }
//}

public class removeDuplicates {
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
            int[] nums= {-1,0,0,2,3};
            int ret = new Solution26().removeDuplicates(nums);
            String out = integerArrayToString(nums, ret);
            
            System.out.print(out);
//        }
    }
}
