package xiaozhao;

import java.lang.reflect.Array;
import java.util.*;
public class wangyi002 {

	public static void main(String[] args) {//传入一个二维数组
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		int n = Integer.valueOf(line.split(" ")[0]);
		int k = Integer.valueOf(line.split(" ")[1]);
		int[] nums = new int[n];
		String str = in.nextLine();
		String[] ch = str.split(" ");
		for (int i =0 ;i <n ; i++){
			nums[i] = Integer.valueOf(ch[i]);
		}
//		System.out.println(Arrays.toString(nums));
		int min = nums[0];
		int max = nums[0];
		int low= 0;
		int high = 0;
		for(int i = 0;i<n ; i++){
			if(nums[i] < min){min = nums[i];low = i;}
			if(nums[i]>max){max = nums[i] ; high = i;}
		}
		int count = 0;
		ArrayList<ArrayList<Integer>> total_list = new ArrayList<ArrayList<Integer>>();
		while(min != max){
			ArrayList<Integer> list = new ArrayList<Integer>();
			nums[low] +=1;
			nums[high] -=1;
			list.add(high+1);list.add(low+1);
			min = nums[0];
			max = nums[0];
			for(int i = 0;i<n ; i++){
				if(nums[i] < min){min = nums[i];low = i;}
				if(nums[i] > max){max = nums[i] ; high = i;}
			}
			total_list.add(list);
			count ++;
			if (count >= k) break;
		}
		System.out.println((max-min) +" "+count);
		for(int i = 0;i<total_list.size();i++){
			System.out.print(total_list.get(i).get(0)+" "+total_list.get(i).get(1));
			System.out.print("\n");
		}
	}
}
