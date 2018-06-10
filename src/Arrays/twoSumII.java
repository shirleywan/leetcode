package Arrays;

import java.io.IOException;
/**
 * NO.167 Two Sum II - Input array is sorted
 * @author admin
 *
 */
//两层遍历代价太高，则设置前后2个指针，计算二者的和，如大于，则向前移动后面的指针；如小于，则向后移动前面的指针。
class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
    	int[] count=new int[2];
    	int i=0,j=numbers.length-1;
    	while(i<j) {
            if(numbers[i]+numbers[j]==target) {
             	count[0]=i+1;
            	count[1]=j+1;
            	break;
            }else {
        	    if(numbers[i]+numbers[j]>target) {j--;}
            	else {i++;}
            }
    	}
        return count;
    }
}

public class twoSumII {
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
//            int[] numbers = stringToIntegerArray(line);
//            line = in.readLine();
//            int target = Integer.parseInt(line);
    	    int[] numbers= {-1,0};
    	    int target=-1;
            
            int[] ret = new Solution167().twoSum(numbers, target);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
//        }
    }
}
