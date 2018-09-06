package bishi;

import java.util.*;

import Strings.countAndSay38;
import Strings.strStr28;

/**
 * 画家小Q
 */
class Solution803{
	char[][] nums;
	public void setNums(char[][] nums){
		this.nums = nums;
	}
	public void dfs_Y(int x ,int y){
		if(x >=0 && x < nums.length && y >=0 && y < nums[0].length &&
				(nums[x][y]=='Y' || nums[x][y]=='G')){
			if(nums[x][y] == 'G') {nums[x][y] = 'B';}
			else {nums[x][y] = 'X';}
			dfs_Y(x-1, y-1);
			dfs_Y(x+1, y+1);
		}
	}
	public void dfs_B(int x ,int y){
		if(x >=0 && x < nums.length && y >=0 && y < nums[0].length &&
				(nums[x][y]=='B' || nums[x][y]=='G')){
			if(nums[x][y] == 'G') {nums[x][y] = 'Y';}
			else {nums[x][y] = 'X';}
			dfs_B(x+1, y-1);
			dfs_B(x-1, y+1);
		}
	}
	public int work(char[][] nums) {
		setNums(nums);
		if(nums.length <=1 || nums[0].length <= 1){return 0;}
		int count = 0;
		for(int i = 0 ;i <nums.length ; i++){
			for (int j = 0 ;j <nums[0].length ; j++){
				if(nums[i][j] == 'Y'){
					dfs_Y(i, j);
					count ++;
				}
				if(nums[i][j] == 'B'){
					dfs_B(i, j);
					count ++;
				}
				if(nums[i][j] == 'G'){
					dfs_Y(i, j);
					count ++;
					nums[i][j] = 'B';
					dfs_B(i, j);
					count ++;			
				}
				
			}
		}
		
		return count;
	}
}
public class tengxun803 {
	public static void main(String[] args) {//传入一个二维数组
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
//		System.out.println(Arrays.toString(line.toCharArray()));
		int n = Integer.valueOf(line.split(" ")[0]);
		int m = Integer.valueOf(line.split(" ")[1]); 
		char[][] nums = new char[n][m];
		for(int i = 0 ; i< n ; i++){
			String str = in.nextLine();
			char[] ch = str.toCharArray();
			for (int j =0 ;j <m ; j++){
				nums[i][j] = ch[j];
			}
		}
//		for (int i =0;i < n ;i++){
//			System.out.println(Arrays.toString(nums[i]));
//		}
		System.out.println(new Solution803().work(nums));
	}
}
