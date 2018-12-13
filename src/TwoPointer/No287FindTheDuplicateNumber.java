package TwoPointer;

/**
 * 287. Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * Example 1:
 *      Input: [1,3,4,2,2]
 *      Output: 2
 * Example 2:
 *      Input: [3,1,3,4,2]
 *      Output: 3
 * Note:
 *      You must not modify the array (assume the array is read only).
 *      You must use only constant, O(1) extra space.
 *      Your runtime complexity should be less than O(n2).
 *      There is only one duplicate number in the array, but it could be repeated more than once.
 */
class Solution287 {
    /**
     * Runtime: 1 ms, faster than 64.54% of Java online submissions for Find the Duplicate Number.
     * 将遍历过的点设置为0，如果重新遍历了这个点，则返回这个值；
     */
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int i = 0 ;
        int temp = 0;
        while(nums[i] != 0){
            temp = nums[i];
            nums[i] = 0;
            i = temp;
        }
        return i;
    }
    /**
     * good method：
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
     */
    public int findDuplicate1(int[] nums) {
        int n = nums.length;
        int slow = n;
        int fast = n;
        do{
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }while(slow != fast);
        slow = n;
        while(slow != fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }
}
public class No287FindTheDuplicateNumber {
    public static void main(String[] args){
        int[] nums = {3,1,3,4,2};
        System.out.println(new Solution287().findDuplicate(nums));
    }
}
