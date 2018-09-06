package xiaozhao;

import java.util.Scanner;
/**
 * 模拟按规则木块下落
 *
 */

public class pdd2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		int n = Integer.valueOf(line.split(" ")[0]);
		int m = Integer.valueOf(line.split(" ")[1]);
		char[][] chess = new char[n][m];
		for(int i = 0 ; i<n ; i++){
			char[] string = in.nextLine().toCharArray();
			for(int p = 0 ; p< m ;p++){
				chess[i][p] = string[p];
			}
		}
		int loc = 0;
		for(int p = 0 ; p< m ;p++){
			for(int i = n-1 ;i >=0 ; i--){
//				for(int z = 0; z < n ;z++){
//					System.out.println(z+": "+String.valueOf(chess[z]));
//				}
				if(chess[i][p] == 'x'){
					loc = i-1;
					i = i-1;
					while(i >=0 ){
						if(chess[i][p] == 'o'){
							chess[i][p] ='.';
							chess[loc][p] = 'o';
							loc -- ;
							
						}
						if(chess[i][p] == 'x') {i = i+1;break;}
						i--;
					}
					if( i ==-1){ i = 0;}
				}
				else{
					chess[i][p] = '.';
				}
				loc = 0;
			}
		}
		for(int i =0 ; i <n ; i++){
			for(int p = 0 ; p<m ; p++){
				System.out.print(chess[i][p]);
			}
			System.out.print("\n");
		}
	}

}
