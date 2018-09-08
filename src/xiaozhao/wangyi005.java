package xiaozhao;

import java.util.*;
import java.util.Scanner;

public class wangyi005 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		int[] nums = new int[3];
		nums[0]= Integer.valueOf(line.split(" ")[0]);
		nums[1]= Integer.valueOf(line.split(" ")[1]);
		nums[2] = Integer.valueOf(line.split(" ")[2]);
		Arrays.sort(nums);
		int total = Math.abs(nums[1]-nums[0]) + Math.abs(nums[2]-nums[1]);
		System.out.println(total);
	}
}
