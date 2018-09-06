package xiaozhao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pdd4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		String str = ""; 
		char[] newstr = in.nextLine().toCharArray(); //第一行
		List<String> list = new ArrayList<String>();
		for(int i = 0 ;i< n ;i++){
			str = in.nextLine();
			list.add(str);
			for(int p = 0 ;p< m ;p++){
				if((str.charAt(p) - newstr[p])< 0 ){
					newstr[p] = str.charAt(p);
				}
			}
		}
		if(list.contains(String.valueOf(newstr))){
			
		}
		else{
			System.out.println("-");
		}
		
	}
}
