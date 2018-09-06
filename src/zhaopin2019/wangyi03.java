package zhaopin2019;
import java.util.*;
public class wangyi03 {

	public static void main(String[] args) {//传入一个二维数组
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		int n = Integer.valueOf(line.split(" ")[0]);
		int k = Integer.valueOf(line.split(" ")[1]);
		int[] nums = new int[n];
		int[] awake = new int[n];
		int total = 0;
		String str = in.nextLine();
		String[] ch = str.split(" ");
		for (int i =0 ;i <n ; i++){
			nums[i] = Integer.valueOf(ch[i]);
			total += nums[i];
		}
		str = in.nextLine();
		ch = str.split(" ");
		for (int i =0 ;i <n ; i++){
			awake[i] = Integer.valueOf(ch[i]);
		
		}
//		int max = 0;
//		for (int i =0 ;i <n ; i++){
//			if(awake[i]==0){
//				if(nums[i]>nums[max]){max = i;}
//			}
//		}
//		int count = 0;
//		for(int i =Math.max(max-k+1, 0) ; i<=Math.max(max, k-1);i++){
//			count += nums[i];
//		}
		int count = 0;
		int maxCount = 0;
		int toutal= 0;
		for(int i = 0;i<k;i++){
			if(awake[i] == 0){
				count +=nums[i];
//				if(count>maxCount){total=i;maxCount = count;}
			}
		}
//		System.out.println(count);
		for(int i = 0;i<n-k;i++){
			count = 0;
			for(int j=i ; j<k;j++){
				if(awake[j]==0){count +=nums[j];}
			}
			if(count>maxCount){maxCount = count;}
		}
		for(int i = 0;i<n;i++){
			if(awake[i]==1){
				maxCount+=nums[i];
			}
		}
		
		System.out.println(maxCount);
//		
	}
}
