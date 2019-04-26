package DynamicProgramming;

/**
 * 62. Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Example 1:
 *      Input: m = 3, n = 2
 *      Output: 3
 *      Explanation:
 *      From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 *      1. Right -> Right -> Down
 *      2. Right -> Down -> Right
 *      3. Down -> Right -> Right
 * Example 2:
 *      Input: m = 7, n = 3
 *      Output: 28
 */
class Solution62 {
    public int uniquePaths(int m, int n) {
        if( m == 1 && n == 1 )return 1;
        if( m <= 0 || n <= 0) return 0;
        return uniquePaths(m-1 , n ) + uniquePaths(m , n-1);
    }
    /**
     * 2 dimension array
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
     * Memory Usage: 31.7 MB, less than 100.00% of Java online submissions for Unique Paths.
     */
    public int uniquePaths1(int m, int n) {
        if( m <= 0 || n <= 0) return 0;
        int[][] nums = new int[m][n];
        nums[0][0] = 1 ;
        for(int i = 0 ; i < m ; i++){
            nums[i][0] = 1;
        }
        for(int i = 0 ; i < n ; i++){
            nums[0][i] = 1;
        }
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                nums[i][j] = nums[i-1][j] + nums[i][j-1];
            }
        }
        return nums[m-1][n-1];
    }
}
public class No62uniquePaths {
    public static void main(String[] args){
        int m = 3 , n = 2 ;
        System.out.println(new Solution62().uniquePaths(m , n));
    }
}
