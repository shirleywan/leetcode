package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution485 {
	/**
	 * Method-1
	 */
//    public int findMaxConsecutiveOnes(int[] nums) {
//    	int num = 0,count=0;
//        for(int n:nums) {
//        	if (n==1) {
//				num++;
//			}
//        	else {if(num>count) count=num;num=0;}
//        }
//        return Math.max(num, count);
//    }
	/**
	 * good-idea:写的比我好呀！思想是一样的
	 */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max; 
    } 
}

public class findMaxConsecutiveOnes {
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
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] nums = stringToIntegerArray(line);
            int[] nums= {1,1,0,1,1,1};
            int ret = new Solution485().findMaxConsecutiveOnes(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}