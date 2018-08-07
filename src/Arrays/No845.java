package Arrays;

import java.util.ArrayList;

/**
 * 845. Longest Mountain in Array
 */
class Solution845 {
	/**
	 * 暴力求解吧，最省心了。。
	 * 这个版本调不出来，卡死在这个用例上，61/72
	 */
	public int longestMountain(int[] nums) {
    	if(nums.length == 0 || nums.length < 3){return 0;}
    	int i = 0;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(nums[0] <nums[1]) {list.add(0);}
    	for ( i = 1 ; i <nums.length-1 ; i++){
    		if((nums[i] <= nums[i+1] && nums[i-1] > nums[i]) ||(nums[i] < nums[i+1] && nums[i-1] >= nums[i]) ) {list.add(i);}
    	}
    	if(nums[nums.length-1] < nums[nums.length-2]) {
    		if(list.size() > 1){
    			if(list.get(list.size()-1) == nums.length -2 ){
    				list.remove(list.size()-1);list.add(nums.length-1);
    			}
    			else{list.add(nums.length-1);}
    		}
    		else{list.add(nums.length-1);}
    	}
//    	System.out.println(list);
    	if(list.size() == 0){return 0;}
    	int max = 0;
    	for( i = 0 ; i<list.size()-1 ; i++){
    		if((list.get(i+1) - list.get(i)+1)>max) {max = list.get(i+1) - list.get(i)+1;}
    	}
        return max >= 3 ? max : 0;
    }
}

public class No845 {
	public static void main(String[] args) {
		int[] nums = {2,0,2,2,3};
		System.out.println(new Solution845().longestMountain(nums));
	}
}
