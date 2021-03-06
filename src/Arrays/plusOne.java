package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * No.66 Plus One
 * @author admin
 *
 */
//class Solution66 {
//    public int[] plusOne(int[] digits) {
//    	digits[digits.length-1]=digits[digits.length-1]+1;
//    	for(int i=digits.length-1;i>=1;i--) {
//    		if(digits[i]==10) {
//    			digits[i]=0;
//    			digits[i-1]=digits[i-1]+1;
//    		}
//    	}
//    	if(digits[0]!=10) {return digits;}
//    	else {
//    		int nums[]= new int[digits.length+1];
//    		for(int i=0;i<digits.length;i++) {
//    			nums[i+1]=digits[i];
//    		}
//    		nums[0]=1;
//         	nums[1]=0;
//    		return nums;
//    	}
//    }
//}
//好想法：因为每次只加1，所以当能进位时，后面都是0.---->注意这种想法！！
class Solution66{
	public int[] plusOne(int[] digits) {
		int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        
	        digits[i] = 0;
	    }
	    
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}
}

public class plusOne {
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
//            int[] digits = stringToIntegerArray(line);
            int[] digits= {9,9};
            int[] ret = new Solution66().plusOne(digits);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
//        }
    }
}
