package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 643 Maximum Average Subarray I
 * @author admin
 *
 */


//public double findMaxAverage(int[] nums, int k) {
//    long sum = 0;
//    for (int i = 0; i < k; i++) sum += nums[i];
//    long max = sum;
//    
//    for (int i = k; i < nums.length; i++) {
//        sum += nums[i] - nums[i - k];
//        max = Math.max(max, sum);
//    }
//    
//    return max / 1.0 / k;
//}
class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
    	Double avg=Double.MIN_VALUE;
    	Double sum=0.0;
    	for(int i=0;i<k;i++) {
			sum=sum+nums[i];
			avg=sum/k;
		}
    	for(int i=1;i<nums.length-k+1;i++) {
    		sum=sum+nums[i+k-1]-nums[i-1];
    		if((sum/k)>avg) {avg=sum/k;}
    	}
        return avg;
    }
}

public class findMaxAverage {
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
    
    public static void main(String[] args) {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] nums = stringToIntegerArray(line);
//            line = in.readLine();
//            int k = Integer.parseInt(line);
    	    int[] nums= {-1};
    	    int k=1;
            double ret = new Solution643().findMaxAverage(nums, k);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
