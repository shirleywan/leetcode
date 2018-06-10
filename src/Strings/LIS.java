package Strings;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LIS {
	public static String LIS(String s){
		String[] nums=s.split(",");
		char[] num=new char[nums.length];
		String str="";
		for(String a:nums){
			a.toCharArray();
		}
		Arrays.sort(nums);
		System.out.println(str);
		return LCS.LCS(s,str);
	}
	public static void main(String[] args) {
		String s="5,6,10,1,2,8,9";
		String str=LIS(s);
		System.out.println(str);
	}
}
