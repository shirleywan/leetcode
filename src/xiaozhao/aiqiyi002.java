package xiaozhao;

import java.util.Scanner;

public class aiqiyi002 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		int n = Integer.valueOf(line.split("\n")[0]);
//		System.out.println(n);
		int[] nums = new int[2000];
		int a , b ,x , y ,count= 0;
		boolean flag = false;
		for(int i =0 ; i < n ; i++ ){
			line = in.nextLine();
			flag = false;
			x = Integer.valueOf(line.split("  ")[0]);
			y = Integer.valueOf(line.split("  ")[1]);
			a = Math.min(x, y);
			b = Math.max(x, y);
			for(int j = a ; j < b ; j++){
				if(nums[j] == 1) {flag = true;break;}
			}
			if(flag){count ++;}
			else{
				for(int j = a ; j < b ; j++){
					nums[j] =1 ;
				}
			}
		}
		System.out.println(n-count);
		
	}
}
