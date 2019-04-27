package DynamicProgramming;

/**
 * 64. Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * Example:
 *      Input:
 *      [
 *          [1,3,1],
 *          [1,5,1],
 *          [4,2,1]
 *      ]
 *      Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
class Solution64 {
    /**
     * Runtime: 2 ms, faster than 96.83% of Java online submissions for Minimum Path Sum.
     * Memory Usage: 42.9 MB, less than 13.73% of Java online submissions for Minimum Path Sum.
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int[][] nums = new int[grid.length][grid[0].length];
        nums[0][0] = grid[0][0];
        for(int i = 1 ; i < nums.length ; i++){ // column
            nums[i][0] = nums[i-1][0]+grid[i][0];
        }
        for(int i = 1 ; i < nums[0].length ; i++){
            nums[0][i] = nums[0][i-1]+grid[0][i];
        }
        for(int i = 1 ; i < nums.length ; i++){
            for(int j = 1 ; j < nums[0].length ; j++){
                nums[i][j] = Math.min(nums[i-1][j] , nums[i][j-1])+grid[i][j];
            }
        }
        return nums[grid.length-1][grid[0].length-1];
    }
}
public class No64minPathSum {
    public static void main(String[] args){
        int[][] grid = { {1,3,1}, {1,5,1}, {4,2,1}};
//        System.out.println(grid.length +","+ grid[0].length);
        System.out.println(new Solution64().minPathSum(grid));
    }
}
