package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * No.628
 * @author admin
 *我的这个算法跑不出来，但是我认为结构没有问题啊！差在哪里了呢？
 */
class Solution628{
	public int maximumProduct(int[] nums) {
		if(nums.length==3) { return nums[0]*nums[1]*nums[2];}
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		int m=0,n=0,p=0;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>max1) {
				max1=nums[i];
				m=i;
			}
			if(nums[i]<min1) {
				min1=nums[i];
				n=i;
			}
		}
		for(int i=0;i<nums.length && i!=m && i!=n;i++) {
			if(nums[i]>max2) {
				max2=nums[i];
				p=i;
			}
			if(nums[i]<min2) {
				min2=nums[i];
			}
		}
		for(int i=0;i<nums.length && i!=m && i!=p;i++) {
			if(nums[i]>max3) {
				max3=nums[i];
			}
		}

	  	
	 	if(max1*max2*max3>=min1*min2*max1) { return max1*max2*max3;}
		else { return min1*min2*max1;}
	}
}
//这个方法是先冒泡排序+比较选值，算出结果
//class Solution628 {
//    public int maximumProduct(int[] nums) {
//        int sum;
//    	if(nums.length==3) { return sum=nums[0]*nums[1]*nums[2];}
//    	BubbleSort(nums);
//    	if(nums[nums.length-1]<0&& nums[nums.length-2]<0 && nums[0]<0 && nums[1]<0) {return sum=nums[0]*nums[1]*nums[2];}
//    	if(nums[nums.length-1]>0&& nums[nums.length-2]<0 && nums[0]<0 && nums[1]<0) {return sum=nums[0]*nums[1]*nums[nums.length-1];}
//    	if(nums[nums.length-1]>0&& nums[nums.length-2]>0 && nums[0]<0 && nums[1]<0) {
//    		if(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]>=nums[0]*nums[1]*nums[nums.length-1]) {
//    			return sum=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
//    		}
//    		else {
//    			return sum=nums[0]*nums[1]*nums[nums.length-1];
//    		}
//    	}
//    	else {
//    		return sum=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
//    	}
//    }	
//    //冒泡排序
//    public static void BubbleSort(int[] arr) {
//        int temp;//定义一个临时变量
//        for(int i=0;i<arr.length-1;i++){//冒泡趟数
//            for(int j=0;j<arr.length-i-1;j++){
//                if(arr[j+1]<arr[j]){
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//    }
//    
//}


//参考答案！
//	public int maximumProduct(int[] nums) {
//	    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
//	    for (int n : nums) {
//	        if (n > max1) {
//	            max3 = max2;
//	            max2 = max1;
//	            max1 = n;
//	        } else if (n > max2) {
//	            max3 = max2;
//	            max2 = n;
//	        } else if (n > max3) {
//	            max3 = n;
//	        }
//	
//	        if (n < min1) {
//	            min2 = min1;
//	            min1 = n;
//	        } else if (n < min2) {
//	            min2 = n;
//	        }
//	    }
//	    return Math.max(max1*max2*max3, max1*min1*min2);
//	}

public class maximumProduct {
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
            int[] nums= {1,2,3,5,-120,-1};
            int ret = new Solution628().maximumProduct(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}