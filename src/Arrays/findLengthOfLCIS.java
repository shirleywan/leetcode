package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * No.674
 * @author admin
 *
 */
//class Solution {
//    public int findLengthOfLCIS(int[] nums) {
//        int count=0;
//        int temp=0;
//        if(nums.length==0){
//            return 0;
//        }
//        for(int i=0;i<nums.length-1;i++){
//            if(nums[i+1]>nums[i]){
//                count++;
//            }
//            else{
//                if(count>temp){
//                    temp=count;
//                }
//                count=0;
//            }
//        }
//        if(count>temp){
//            temp=count;
//        }
//        return temp+1;
//    }
//}
////����[],Ҫ���0����1��Ҫ���1��ע�����һ�£�

class Solution {
	public int findLengthOfLCIS(int[] num) {
        if (num == null || num.length == 0) return 0;
        int n = num.length;
        int[] dp = new int[n];
        
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (num[i] > num[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}

public class findLengthOfLCIS {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
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
    	  int[] nums= {1,2,4,4,5,6,7,2,3,8,5};
            
            int ret = new Solution().findLengthOfLCIS(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
