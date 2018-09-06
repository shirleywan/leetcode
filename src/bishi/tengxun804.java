package bishi;

import java.util.*;
/**
 * 贪吃的小 Q
 */
public class tengxun804 {
	public static int sum(int n, int mid) {
        int need = 0;
        for(int i = 0; i < n; i++) {
            need += mid;
            mid = (mid + 1) >> 1; //不小于前一天的一半，向上取整
        }
        return need;
    }
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int low = 1;
		int high = m;
		int mid = (low + high +1)/2;
		while( low < high){
			mid = (low + high +1)/2;
			int need = sum(n,mid);
			if(need > m) {high = mid -1;}
			else {
				if ( need == m){high = m;break;}
				else{low = mid;}
			}
		}
		System.out.println(mid);
	}
}
