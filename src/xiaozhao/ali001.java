package xiaozhao;

import java.util.Arrays;
import java.util.*;

public class ali001 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n == 1) {System.out.println(1);return;}
		int[] ad = new int[n];
		int[] count = new int[n];
		ad[0] = 1;
		if(n >=1) {ad[1] =3;count[1] = 1;}
		for(int i = 2; i < n ; i++){
			ad[i] = 0;
			for(int j = 1 ; j <=3 ; j++){
				if(i - j >= 0 ){
					if( j ==1) {
						ad[i] = ad[i] +ad[i-1] -count[i-1];
						count[i] = ad[i-1] -count[i-1];
					}
					else{
						ad[i] = ad[i] + ad[i-j]; 
					}
				}
			}
		}
		System.out.println(Arrays.toString(ad));
		System.out.println(Arrays.toString(count));
		System.out.println(ad[n-1] - count[n-1]);
		
	}
}
