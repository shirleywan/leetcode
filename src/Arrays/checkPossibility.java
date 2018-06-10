package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * No.665
 * ���˴𰸣��벻��������
 * @author admin
 *
 */
class Solution665 {
	 public boolean checkPossibility(int[] nums) {
	        int count=0;
	        	for(int i=1;i<nums.length;i++) {
		            if(nums[i-1]>nums[i]) {
		            	count++;
		            	if(i-2<0||nums[i-2]<=nums[i]) {nums[i-1]=nums[i];} //���е�������num[i-1]���󣬽����Ϊnum[i]
		            	else nums[i]=nums[i-1];  //���еݼ�����num[i]��С�������Ϊnum[i-1]
		            }	            
	        	}
	        if(count>1) return false;
	        
	        return true;
	    }
}

public class checkPossibility {
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
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] nums = stringToIntegerArray(line);
    	  int[] nums= {2,3,3,2,4}; 
            
            boolean ret = new Solution665().checkPossibility(nums);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
//    }
}
