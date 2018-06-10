//package Arrays;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
///**
// * No.448.
// * @author admin
// *
// */
//class Solution448 {
////    public List<Integer> findDisappearedNumbers(int[] nums) {
////        List<Integer> list=new ArrayList<Integer>();
////        for(int n:nums) {
////        	if(!list.contains(n)) {list.add(n);}
////        }
////        for(int i=1;i<=nums.length;i++) {
////        	if(list.contains(i)) {list.remove(list.indexOf(i));}
////        	else {list.add(i);}
////        }
////        return list;
////    }
//	/**
//	 * method 2:be similiar to method-1
//	 */
////    public List<Integer> findDisappearedNumbers(int[] nums) {
////        List<Integer> list=new ArrayList<Integer>();
////        for(int i=0;i<nums.length;i++) {
////        	list.add(i, i+1);
////        }
////        for(int i=0;i<nums.length;i++) {
////        	if(list.contains(nums[i])) {list.remove(list.indexOf(nums[i]));}
////        }
////        return list;
////    }
//	/**
//	 * good idea-1:好想法！！
//	 * 重点是根据i的循环，找到nums[i],nums[i]类似于[1,2,3,4...n]中的i，再进入循环，找这个i在nums中是否出现过，
//	 * 出现过设置为负数，没出现过，则是缺失的。
//	 * 这里，val = Math.abs(nums[i]) - 1，减一是因为原数组是1...n的，减1对应0...nums.length
//	 * 后面add(i+1)，把元素加回来。
//	 * @param nums
//	 * @return
//	 */
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> ret = new ArrayList<Integer>();
//        
//        for(int i = 0; i < nums.length; i++) {
//            int val = Math.abs(nums[i]) - 1;
//            if(nums[val] > 0) {
//                nums[val] = -nums[val];
//            }
//        }
//        
//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] > 0) {
//                ret.add(i+1);
//            }
//        }
//        return ret;
//    }
//	/**
//	 * good idea-2:more simple
//	 * @param nums
//	 * @return
//	 */
////    public List<Integer> findDisappearedNumbers(int[] nums) {
////        List<Integer> res = new ArrayList<>();
////        int n = nums.length;
////        for (int i = 0; i < nums.length; i ++) nums[(nums[i]-1) % n] += n;
////        for (int i = 0; i < nums.length; i ++) if (nums[i] <= n) res.add(i+1);
////        return res;
////    }
//}
//
//public class findDisappearedNumbers {
//    public static int[] stringToIntegerArray(String input) {
//        input = input.trim();
//        input = input.substring(1, input.length() - 1);
//        if (input.length() == 0) {
//          return new int[0];
//        }
//    
//        String[] parts = input.split(",");
//        int[] output = new int[parts.length];
//        for(int index = 0; index < parts.length; index++) {
//            String part = parts[index].trim();
//            output[index] = Integer.parseInt(part);
//        }
//        return output;
//    }
//    
//    public static String integerArrayListToString(List<Integer> nums, int length) {
//        if (length == 0) {
//            return "[]";
//        }
//    
//        String result = "";
//        for(int index = 0; index < length; index++) {
//            Integer number = nums.get(index);
//            result += Integer.toString(number) + ", ";
//        }
//        return "[" + result.substring(0, result.length() - 2) + "]";
//    }
//    
//    public static String integerArrayListToString(List<Integer> nums) {
//        return integerArrayListToString(nums, nums.size());
//    }
//    
//    public static void main(String[] args) throws IOException {
////        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
////        String line;
////        while ((line = in.readLine()) != null) {
////            int[] nums = stringToIntegerArray(line);
//            int[] nums= {1,3,3,4};
//            List<Integer> ret = new Solution448().findDisappearedNumbers(nums);
//            
//            String out = integerArrayListToString(ret);
//            
//            System.out.print(out);
////        }
//    }
//}