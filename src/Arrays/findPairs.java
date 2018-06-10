package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution532 {
    public int findPairs(int[] nums, int k) {
    	if(k<0) {return 0;} //because abs(i,j)<=k, k couldn't <0
    	List list=new ArrayList();
    	int count=0;
    	for(int i=0;i<nums.length;i++) {
    		list.add(i,nums[i]+k);
    	}
    	for(int i=0;i<nums.length;i++) {
    		if(list.contains(nums[i]) && i!=list.indexOf(nums[i])) {count++;}
    	}
    	return count;
    }
//    public int findPairs(int[] nums, int k) {
//        int ans = 0;
//        Arrays.sort(nums);
//        for (int i = 0, j = 0; i < nums.length; i++) {
//            for (j = Math.max(j, i + 1); j < nums.length && (long) nums[j] - nums[i] < k; j++) ;
//            if (j < nums.length && (long) nums[j] - nums[i] == k) ans++;
//            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
//        }
//        return ans;
//    }
}

public class findPairs {
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
//            line = in.readLine();
//            int k = Integer.parseInt(line);
            int[] nums= {1,2,3,4,5};
            int k=-1;
            int ret = new Solution532().findPairs(nums, k);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
