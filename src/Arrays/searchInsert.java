package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//class Solution35 {
//    public int searchInsert(int[] nums, int target) {
//    	if(nums.length==0) {return 0;}
//    	for(int i=0;i<nums.length;i++) {
//    		if(nums[i]>=target) {
//    			return i;
//    		}
//    	}
//        return nums.length;
//    }
//}

class Solution35{  //二分查找法，好想法吗？我觉得不是。
	public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}

public class searchInsert {
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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//        while ((line = in.readLine()) != null) {
//            int[] nums = stringToIntegerArray(line);
//            line = in.readLine();
//            int target = Integer.parseInt(line);
            int[] nums= {1};
            int target=3;
            int ret = new Solution35().searchInsert(nums, target);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
