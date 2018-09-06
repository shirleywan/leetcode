package xiaozhao;

import java.util.*;

import Strings.intToRoman12;

/**
 * 小Q的歌单
 */
public class tengxun801 {
	/**
	 * 阶乘想法
	 */
	public static int work(int length , int a ,int x , int b ,int y){
		if(length <a || length < b){return 0;}
		if (a <= 0 || b <= 0 || x <=0 || y <= 0){return 0;}
		int count = 0;
		for (int i = 0 ;i <= x ; i++){
			for (int j = 0 ;j <= y ; j++){
				if(i*a + j *b == length){count = (count+jiecheng(i, x) * jiecheng(j, y))%1000000007;}
			}
		}
		return count;
	}
	public static int jiecheng(int x , int n) {
		int count = 1;
		int num = 1 ;
		int total = 1;
		for (int i = 1; i<= x ; i++){
			count = count *i;
		}
		for (int i = 1; i<= (n-x) ; i++){
			num = num *i;
		}
		for (int i = 1; i<= n ; i++){
			total = total *i;
		}
		return total/(num*count);
	}
	
	public static int gedan(int length , int a ,int x , int b ,int y){
		int[][] nums =new int[105][100];
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		int a = in.nextInt();
		int x = in.nextInt();
		int b = in.nextInt();
		int y = in.nextInt();
		System.out.println(work(length, a, x, b, y));
		
	}
}
