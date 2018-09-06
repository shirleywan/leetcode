package xiaozhao;

import java.util.*;

import Strings.countAndSay38;

public class meituan03 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String[] strings = str.split(" ");
		int n = Integer.valueOf(strings[0]);
		int k = Integer.valueOf(strings[1]);
		String[] number = in.nextLine().split(" ");
		int[] nums = new int[n];
		for(int i =0 ;i <n ; i++){
			nums[i] = Integer.valueOf(number[i]);
		}
		int[] kmp = new int[n];
//		System.out.println(Arrays.toString(nums));
		for(int i = 0 ; i< n ;i++){
			if(nums[i] == 1){
				for(int j = i+1 ; j < n ; j++){
					if(nums[j] == 1){kmp[i] = j-i-1;break;}
				}
			}
		}
		System.out.println(Arrays.toString(kmp));
		int count1 = 0;
		int count2 = 0;
		int total = 0;
		for(int i = 0 ; i <n-1 ; i++){
			total += kmp[i];
			if(kmp[i] == 1 && kmp[i+1] == 0){
				count1++;
			}
			if(kmp[i] == 2){count2 ++;}
		}
		
	}
}
