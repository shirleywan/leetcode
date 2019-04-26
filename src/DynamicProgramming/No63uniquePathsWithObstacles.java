package DynamicProgramming;

/**
 * 63. Unique Paths II
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * Note: m and n will be at most 100.
 * Example 1:
 *      Input:
 *      [
 *        [0,0,0],
 *        [0,1,0],
 *        [0,0,0]
 *      ]
 *   Output: 2
 * Explanation:
 *   There is one obstacle in the middle of the 3x3 grid above.
 *   There are two ways to reach the bottom-right corner:
 *   1. Right -> Right -> Down -> Down
 *   2. Down -> Down -> Right -> Right
 */
class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] nums = new int[obstacleGrid.length][obstacleGrid[0].length];
        nums[0][0] = 1;
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) return 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(obstacleGrid[i-1][0] == 1) nums[i][0] = 0;
            else nums[i][0] = 1;
        }
        for(int i = 1 ; i < nums[0].length ; i++){
            if(obstacleGrid[0][i-1] == 1) nums[0][i] = 0;
            else nums[0][i] = 1;
        }
        for(int i = 1 ; i < nums.length ; i++){
            for(int j = 1 ; j < nums[0].length ; j++){
                if(obstacleGrid[i-1][j] == 0 && obstacleGrid[i][j-1] == 0){
                    nums[i][j] = nums[i-1][j] + nums[i][j-1];
                }
                else {
                    if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) return 0;
                    if (obstacleGrid[i - 1][j] == 1) nums[i][j] = nums[i][j - 1];
                    if (obstacleGrid[i][j - 1] == 1) nums[i][j] = nums[i - 1][j];
                }
            }
        }
        return nums[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
    /**
     * 空间复杂度：O(n):
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
     * Memory Usage: 39.2 MB, less than 17.63% of Java online submissions for Unique Paths II.
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //起点是障碍，直接返回 0
        if (obstacleGrid[0][0] == 1)
            return 0;
        int[] dp = new int[n];
        int i = 0;
        //初始化第一行和 62 题不一样了
        //这里的话不是全部初始化 1 了，因为如果有障碍的话当前列和后边的列就都走不过了，初始化为 0
        for (; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[i] = 0;
                break;
            } else {
                dp[i] = 1;
            }
        }
        //障碍后边的列全部初始化为 0
        for (; i < n; i++) {
            dp[i] = 0;
        }
        for (i = 1; i < m; i++) {
            //这里改为从 0 列开始了，因为 62 题中从 1 开始是因为第 0 列永远是 1 不需要更新
            //这里的话，如果第 0 列是障碍的话，需要更新为 0
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    //由于从第 0 列开始了，更新公式有 j - 1，所以 j = 0 的时候不更新
                    if (j != 0)
                        dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[(n - 1)];
    }
}
public class No63uniquePathsWithObstacles {
    public static void main(String[] args){
        int[][] obstacleGrid = { {0,1}};
        System.out.println(new Solution63().uniquePathsWithObstacles(obstacleGrid));
    }
}
