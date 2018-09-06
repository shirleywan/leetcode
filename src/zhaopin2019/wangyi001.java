package zhaopin2019;

import java.util.*;
public class wangyi001 {

	public static void main(String[] args) {//传入一个二维数组
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		int n = Integer.valueOf(line.split(" ")[0]);
		int m = Integer.valueOf(line.split(" ")[1]);
		int[] nums = new int[n];
		for(int i = 0;i<m ; i++){
			int u = in.nextInt();
			nums[u-1]  += 1 ;
		}
		int min = nums[0];
		for(int i = 0; i<n; i++){
			if(nums[i] < min){min = nums[i];}
		}
		System.out.println(min);
	}
}
