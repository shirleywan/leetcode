package DynamicProgramming;

/**
 * 303. Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 *      Given nums = [-2, 0, 3, -5, 2, -1]
 *      sumRange(0, 2) -> 1
 *      sumRange(2, 5) -> -1
 *      sumRange(0, 5) -> -3
 * Note:
 *      You may assume that the array does not change.
 *      There are many calls to sumRange function.
 */
class NumArray {
    /**
     * O(n^2)
     * Runtime: 236 ms, faster than 21.35% of Java online submissions for Range Sum Query - Immutable.
     * Memory Usage: 54.8 MB, less than 21.53% of Java online submissions for Range Sum Query - Immutable.
     */
    int[] array;
    public NumArray(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("Input nums cannot be null!");
        }
        array = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            array[i] = nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || j >= array.length) {
            throw new IllegalArgumentException("Range out of boundry!");
        }
        int result = 0;
        for(int n = i ; n <= j ; n++){
            result = result + array[n];
        }
        return result;
    }
}
class NumArray1 {
    /**
     * O(n)
     * Runtime: 52 ms, faster than 99.19% of Java online submissions for Range Sum Query - Immutable.
     * Memory Usage: 41.3 MB, less than 94.89% of Java online submissions for Range Sum Query - Immutable.
     */
    private int[] sums;

    public NumArray1(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("Input nums cannot be null!");
        }
        // for query intensive, we want to pre-compute sums
        sums = computeSums(nums);

    }

    public int sumRange(int i, int j) {
        if (i < 0 || j >= sums.length) {
            throw new IllegalArgumentException("Range out of boundry!");
        }

        return i == 0 ? sums[j] : sums[j] - sums[i - 1];
    }

    private int[] computeSums(int[] nums) {
        int sum = 0;
        int[] sums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }

        return sums;
    }
}

public class No303NumArray {
    public static void main(String[] args){
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        int i = 0 ; int j = 5;
        int param_1 = obj.sumRange(i,j);
        System.out.println(param_1);
    }
}
