package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Solution268 {
//    public int missingNumber(int[] nums) {
//    	Map map=new HashMap();
//        for(int n:nums) {
//        	map.put(n,1);
//        }
//        for(int i=0;i<=nums.length;i++) {
//        	if(!map.containsKey(i)) {
//        		return i;
//        	}
//        }
//        return 0;
//    }
	/**
	 * 方法2：新建一个数组，存每个元素是否存在的标识，在扫描新数组，看哪个元素不在。
	 */
//	public int missingNumber(int[] nums) {
//    	int[] count=new int[nums.length+1];
//    	for(int i=0;i<nums.length;i++) {
//    		count[nums[i]]=1;
//    	}
//    	for(int i=0;i<count.length;i++) {
//    		if(count[i]==0) {return i;}
//    	}
//		return 0;
//    }
	/**
	 * good idea 1
	 * @param nums
	 * @return
	 */
//	public int missingNumber(int[] nums) {
//	    int xor = 0, i = 0;
//		for (i = 0; i < nums.length; i++) {
//			xor = xor ^ i ^ nums[i];
//		}
//		return xor ^ i;
//	}
	/**
	 * good idea 2:another XOR
	 */
//	public int missingNumber(int[] nums) {  //xor
//	    int res = nums.length;
//	    for(int i=0; i<nums.length; i++){
//	        res ^= i;
//	        res ^= nums[i];
//	    }
//	    return res;
//	}
	/**
	 * good idea 3:SUM
	 */
//	public int missingNumber(int[] nums) { //sum
//	    int len = nums.length;
//	    int sum = (0+len)*(len+1)/2;
//	    for(int i=0; i<len; i++)
//	        sum-=nums[i];
//	    return sum;
//	}
/**
 * good idea 4: Binary Search,二分查找
 * @param nums
 * @return
 */
//	public int missingNumber(int[] nums) { //binary search
//	    Arrays.sort(nums);
//	    int left = 0, right = nums.length, mid= (left + right)/2;
//	    while(left<right){
//	        mid = (left + right)/2;
//	        if(nums[mid]>mid) right = mid;
//	        else left = mid+1;
//	    }
//	    return left;
//	}
	/**
	 * good idea 5：求和
	 */
	public int missingNumber(int[] nums) {
	    long n = nums.length;
	    return (int) (n * (n+1) / 2 - IntStream.of(nums).sum());
	}
}

public class missingNumber {
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
            int[] nums= {9,6,4,2,3,5,7,0,1};
            int ret = new Solution268().missingNumber(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}