package bishi;

import java.util.*;
/**
 * 纸牌游戏
 */
public class tengxun805 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		String str = in.nextLine();
		String[] strings = str.split(" ");
		int [] nums = new int[n];
		for(int i=0 ;i<n ; i++){
			nums[i]= Integer.valueOf(strings[i]);
		}
		Arrays.sort(nums);
		int count = 0;
		if(n/2 ==0){
			for(int i = n-1;i > 0 ;i = i-2){
				count += nums[i]-nums[i-1];
			}
		}
		else{
			for(int i = n-1;i > 1 ;i = i-2){
				count += nums[i] - nums[i-1];
			}
			count +=nums[0];
		}
		System.out.println(count);
	}
}
