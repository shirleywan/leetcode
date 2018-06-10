package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=nums[0];
        if(nums.length==1) {return nums[0];}
        if(nums[nums.length-1]!=nums[nums.length-2]) {count=nums[nums.length-1];}
        for(int i=1;i<nums.length-1;i++) {
        	if(nums[i-1]!=nums[i]&&nums[i]!=nums[i+1]) {
        		count=nums[i];
        	}
        }
        return count;
    }
//	public int singleNumber(int[] nums) {
//        Map map=new HashMap();
//        for(int n:nums){
//            if(map.containsKey(n)){map.remove(n);}
//            else{map.add(n);}
//        }
//        return map(1);
//    }
}

public class singleNumber136 {
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
            int[] nums= {1};
            int ret = new Solution136().singleNumber(nums);
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}