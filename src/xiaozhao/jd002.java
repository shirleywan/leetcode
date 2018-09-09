package xiaozhao;

import java.util.*;

public class jd002 {
	public static int[] isValid(String str , int x , int y){
		int count = 1;
		int[] nums = new int[y-x+1];
		for(int i = 0 ; i < y-x+1; i++){
			for(int j = i+1 ; j < y-x+1 ; j++){
				if(nums[j] == 0){
					nums[i] = count;
					if(str.charAt(i) == str.charAt(j)){nums[j] = count;}
				}
			}
			if(nums[i] == 0){nums[i] = count;}			
			count++;

		}
		return nums;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String str = in.nextLine();
		int count = 0;
//		int[] nums = isValid(str , 0 ,str.length()-1);
//		System.out.println(Arrays.toString(nums));
		String s1 = "";
		String s2 = Arrays.toString(isValid(str , 0 ,str.length()-1));
//		System.out.println("s2:"+s2);
		int i = 0;
		while(i < line.length() - str.length()+1){
//			System.out.println(line.substring(i, i+str.length()));
			s1 = Arrays.toString(isValid(line, i,i+str.length()-1));
			System.out.println("s1:"+s1);
			if(s1.equals(s2)){count++;}
			i++;
		}
		System.out.println(count);
	}
}
