package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution414 {  
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
//        public int thirdMax(int[] nums) {
//        	if(nums.length==1) {return nums[0];}
//        	if(nums.length==2) {
//        		return Math.max(nums[0],nums[1]);
//        	}
//        	int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE,temp=0,k=0;
//            for(int i=0;i<nums.length;i++) {
//            	if(nums[i]>max1) {max1=nums[i];k=i;}
//            }
//            nums[k]=nums[nums.length-1];nums[nums.length-1]=max1;
//            for(int i=0;i<nums.length-1&& nums[i]!=max1;i++) {
//            	if(nums[i]>max2) {max2=nums[i];k=i;}
//            }
//            temp=nums[nums.length-2];nums[nums.length-2]=nums[k];nums[k]=temp;
//            for(int i=0;i<nums.length-2 && nums[i]!=max2;i++) {
//            	if(nums[i]>max3) {max3=nums[i];k=i;}
//            }
//            return max3;
//        }
}

public class thirdMax {
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
            int[] nums= {3,2,2};
            int ret = new Solution414().thirdMax(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}