package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution581 {
	/**
	 * Method-1:先用一个数组temp保存nums，然后对temp排序，
	 * 然后用两个变量start和end去找两个数组出现不同之处的第一个位置和最后一个位置，最后返回end-start+1就是要找的数组长度。
	 */
//    public int findUnsortedSubarray(int[] nums) {
//    	int[] count=new int[nums.length];
//    	int j=0,k=0;
//    	for(int i=0;i<nums.length;i++) {
//    		count[i]=nums[i];
//    	}
//    	Arrays.sort(nums);
//    	for(int i=0;i<nums.length;i++) {
//    		if(count[i]!=nums[i]) {j=i;break;}
//    	}
//    	for(int i=nums.length-1;i>0;i--) {
//    		if(count[i]!=nums[i]) {k=i+1;break;}
//    	}
//    	return k-j;
//    }
	/**
	 * Good-idea-1：和我一样的想法，但是写的比我好看呀！
	 */
//	public int findUnsortedSubarray(int[] nums) {
//		int n = nums.length;  
//		int[] temp = new int[n];  
//		for (int i = 0; i < n; i++) temp[i] = nums[i];  
//		Arrays.sort(temp);  
//		     
//		int start = 0;  
//	    while (start < n  && nums[start] == temp[start]) start++;  
//		int end = n - 1;  
//		while (end > start  && nums[end] == temp[end]) end--;  
//		return end - start + 1;  
//	}
	/**
	 * Good-idea-2：超级棒！
	 */
	public int findUnsortedSubarray(int[] A) {  
	        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];  
	        for (int i=1;i<n;i++) {  
	            max = Math.max(max, A[i]); //数组中第i个数应该是前i个数中最大的最大值，若不是，则不满足要求。
	            min = Math.min(min, A[n-1-i]);  //第i+1项元素应该是后n-1-i项中的最小值
	            if (A[i] < max) end = i;  
	            if (A[n-1-i] > min) beg = n-1-i;  
	        }  
	        return end - beg + 1;  
	}   
}

public class findUnsortedSubarray {
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
            int[] nums= {1,2,3,4};
            int ret = new Solution581().findUnsortedSubarray(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}