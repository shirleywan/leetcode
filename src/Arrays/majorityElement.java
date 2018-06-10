package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution169 {
	/**
	 * 自己写的第一个，方法是对的，可以没有主元素，找到元素个数最多的
	 * 可以在后面加入判断：if(max>nums.length/2){return k;}  return 0;
	 * 这里使用List<int[]>的结构，如果只用2维数组，无法找到加入新元素的条件和位置 --可以尝试
	 * @param nums:输入数组
	 * @return
	 */
//    public int majorityElement(int[] nums) {
//        List<int[]> count=new ArrayList<int[]>();
//        boolean flag=false;
//        for(int i=0;i<nums.length;i++) {
//        	for(int j=0;j<count.size();j++) {
//        		if(nums[i]==count.get(j)[0]) {
//        			count.get(j)[1]++;
////        			System.out.print(count.get(j)[0]);
////        			System.out.println(count.get(j)[1]);  //测试
//        			flag=true;}
//        	}
//        	if(flag==false) {
//        		int[] element = new int[2];
//                element[0]=nums[i];element[1]++;count.add(element);
//        	}
//        	flag=false; //注意这里，开始的时候忘了修改标识符，导致不能加入新元素
//        }
//        for(int i=0;i<count.size();i++) {
//            System.out.println(count.get(i)[0]+","+count.get(i)[1]);
//        }
//        int max=count.get(0)[1];int k=count.get(0)[0];
//        for(int i=0;i<count.size();i++) {
//            if(count.get(i)[1]>max) {max=count.get(i)[1];k=count.get(i)[0];}
//        }
//        return k;
//    }
	/**
	 * 用Map实现元素个数的统计，不需要记录map中key-value对的个数，很方便。
	 * 放在map中的key-value对不能再修改值了，只能再次放入map中，后续遍历也会扫描到。
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
        boolean flag=false;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int n:nums){
            if(map.containsKey(n)){map.put(n,map.get(n)+1);flag=true;}
            if(flag==false){map.put(n,1);}
            flag=false;
        }
        int max=map.get(nums[0]);int k=nums[0];
        for(int n:nums){
            if(map.get(n)>max) {max=map.get(n);k=n;}
        }
        return k;
    }

    /**
     * 这个方法仅限数组中存在主元素，如果数组为{2,1,2,1,3,1,2,1}时，输出的元素是2，不是主元素1
     */
//	public int majorityElement(int[] nums) {
//	    int count=0, ret = 0;
//	    for (int num: nums) {
//	        if (count==0)
//	            ret = num;
//	        if (num!=ret)
//	            count--;
//	        else
//	            count++;
//	    }
//	    return ret;
//	}
}

public class majorityElement {
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
            int[] nums= {2,1,2,1,3,2,1,1};
            int ret = new Solution169().majorityElement(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
