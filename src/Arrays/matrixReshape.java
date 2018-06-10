package Arrays;

import java.util.ArrayList;
import java.util.List;

class Solution566 {
	/**
	 * Method-1
	 */
//    public static int[][] matrixReshape(int[][] nums, int r, int c) {
//        int[][] matrix=new int[r][c];
//        int[] row= nums[0];
//        if (row.length*nums.length!=r*c) {
//			return nums;
//		}
//        List list=new ArrayList();
//        for(int i=0;i<nums.length;i++) {
//        	for(int j=0;j<row.length;j++) {
//        		list.add(nums[i][j]);
//        	}
//        }
//        int count=0;
//        for(int i=0;i<r;i++) {
//        	for(int j=0;j<c;j++) {
//        		matrix[i][j]=(int) list.get(count);
//        		count++;
//        	}
//        }
//        return matrix;
//    }
	/**
	 * Good-idea-1
	 */
//	public static int[][] matrixReshape(int[][] nums, int r, int c) {
//	    int n = nums.length, m = nums[0].length;
//	    if (r*c != n*m) return nums;
//	    int[][] res = new int[r][c];
//	    for (int i=0;i<r*c;i++) 
//	        res[i/c][i%c] = nums[i/m][i%m];
//	    return res;
//	}
	/**
	 * Good-idea-2
	 */
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
	    int m = nums.length, n = nums[0].length;
	    if (r * c != m * n) return nums;
	    int[][] reshaped = new int[r][c];
	    for (int i = 0; i < r * c; i++)
	        reshaped[i/c][i%c] = nums[i/n][i%n];
	    return reshaped;
	}
}

public class matrixReshape{
	public static void print(int[][] nums) {
		for(int[] n:nums) {
			for(int i:n) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] matrix= {{1,2,3},{1,2,3}};
		matrix=Solution566.matrixReshape(matrix,3,2);
		print(matrix);
	}
}