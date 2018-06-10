package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution53{
	public int maxSubArray(int[] nums) {
		int max=nums[0];
		int sum=nums[0];
		for(int i=1;i<nums.length-1;i++) {
			sum=Math.max(sum+nums[i], nums[i]);
			max=Math.max(max, sum);
		}
		return max;
	}
}
//class Solution53 {
//    public int maxSubArray(int[] nums) {
//    	if(nums.length==1 ) {return nums[0];}
//    	int sum= 0;
//    	int max=Integer.MIN_VALUE;
//    	for(int i=0;i<nums.length;i++) {
//    		sum=nums[i];
//    		if(sum>max) {max=sum;}
//    		for(int j=i+1;j<nums.length;j++) {
//    			sum+=nums[j];
//    			if(sum>max) {max=sum;}
//    		}
//    	}
//        return max;
//    }
//}

public class maxSubArray {
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
            int[] nums= {0};
            int ret = new Solution53().maxSubArray(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
