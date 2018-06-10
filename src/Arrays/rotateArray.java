package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class Solution189 {
	/**
	 * method 1:that's ok! Use Map and HashMap to achieve;
	 * the point is:key:element's Numbering, value:element
	 */
//    public void rotate(int[] nums, int k) {
//    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
//    	for(int i=0;i<nums.length;i++) {
//    		if(i+k<nums.length) map.put(i+k,nums[i]);
//    		else {map.put((i+k-nums.length)%nums.length,nums[i]);}
//    	}  
//    	for(int i=0;i<nums.length;i++) {
//    		nums[i]=map.get(i);
//    	}
//    }
	/**
	 * method 2:可算过了，哎
	 */
//    public void rotate(int[] nums, int k) {
//        int[] count=new int[nums.length];
//        	for(int i=0;i<nums.length;i++) {
//        		if(i+k<nums.length) {count[i+k]=nums[i];}
//        		else {count[(i+k-nums.length)%nums.length]=nums[i];}
//        	}
//        	for(int i=0;i<nums.length;i++) {
//        		nums[i]=count[i];
//        	}
//    }
	/**
	 * method3：这个方法适合数据量小的情况
	 */
//    public void rotate(int[] nums, int k) {
//        for(int i=0;i<k;i++) {
//        	int temp=nums[nums.length-1];
//        	for(int j=nums.length-2;j>=0;j--) {
//        		nums[j+1]=nums[j];
//        	}
//        	nums[0]=temp;
//        }
//    }
    /**
     * 大神代码：
     */
//    public void rotate(int[] nums, int k) {
//        k %= nums.length;
//        reverse(nums, 0, nums.length - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, nums.length - 1);
//    }
//
//    public void reverse(int[] nums, int start, int end) {
//        while (start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }
	/**
	 * 大神代码：The basic idea is that, for example,:
	 * nums = [1,2,3,4,5,6,7] and k = 3, first we reverse [1,2,3,4], it becomes[4,3,2,1]; 
	 * then we reverse[5,6,7], it becomes[7,6,5], finally we reverse the array as a whole, 
	 * it becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].
	 */
	public void rotate(int[] nums, int k) {
	    if(nums == null || nums.length < 2){
	        return;
	    }
	    
	    k = k % nums.length;
	    reverse(nums, 0, nums.length - k - 1); //reverse [1,2,3,4]
	    reverse(nums, nums.length - k, nums.length - 1); //reverse [5,6,7]
	    reverse(nums, 0, nums.length - 1);  //reverse whole array
	    
	}
	private void reverse(int[] nums, int i, int j){ 
	    int tmp = 0;       
	    while(i < j){
	        tmp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = tmp;
	        i++;
	        j--;
	    }
	}
}

public class rotateArray {
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
//            int[] nums = stringToIntegerArray(line);
//            line = in.readLine();
//            int k = Integer.parseInt(line);
            int[] nums= {-1};
            int k=3;
            new Solution189().rotate(nums, k);
            String out = integerArrayToString(nums);
            
            System.out.print(out);
//        }
    }
}