package Arrays;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
class Solution153 {
    public int findMin(int[] nums) {
    	if (nums.length == 0){return 0;}
    	if (nums.length == 1){return nums[0];}
    	int head = 0;
    	int mid = nums.length/2;
    	int last = nums.length-1;
    	while(last - head > 1){
    		if(nums[mid] > nums[last]) {head = mid;}
    		else{last = mid;}
    		mid = (last - head)/2 + head; 
    	}
        return nums[head] < nums[last] ? nums[head] : nums[last];
    }
}
public class No153 {
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(new Solution153().findMin(nums));
	}
}
