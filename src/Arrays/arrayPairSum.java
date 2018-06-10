package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution561 {
    public int arrayPairSum(int[] nums) {
//    	if(nums.length==0) {return 0;}
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i+=2) {
        	count +=nums[i];
        }
        return count;
    }
}

public class arrayPairSum {
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
            int[] nums= {};
            int ret = new Solution561().arrayPairSum(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}