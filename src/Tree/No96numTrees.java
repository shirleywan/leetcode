package Tree;
import java.util.*;

/**
 * 96. Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * Example:
 *      Input: 3
 *      Output: 5
 *      Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
class Solution96 {
    /**
     * Runtime: 1570 ms, faster than 5.76% of Java online submissions for Unique Binary Search Trees.
     * Memory Usage: 31.8 MB, less than 100.00% of Java online submissions for Unique Binary Search Trees.
     */
    public int numTrees(int n) {
        if( n <= 0) return 1;
        if( n == 1) return 1;
        int num = 0;
        for(int i = 1; i <= n ; i++){
            num = num + numTrees(i-1) * numTrees(n-i);
        }
        return num;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
     * Memory Usage: 31.5 MB, less than 100.00% of Java online submissions for Unique Binary Search Trees.
     * running space for running time -- Dynamic Programming
     */
    public int numTrees1(int n){
        if( n <= 0) return 1;
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            for(int j = 0; j < i ; j++){
                nums[i] = nums[i] + nums[j]*nums[i-1-j];
            }
        }
        return nums[n];
    }
}
public class No96numTrees {
    public static void main(String[] args){
        int n = 1;
        System.out.println(new Solution96().numTrees1(n));
    }
}
