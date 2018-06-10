package Strings;

import java.time.format.ResolverStyle;
import java.util.stream.Stream;

public class LCS {
	public static String LCS(String str1,String str2){
		int[][] chess=new int[str1.length()+1][str2.length()+1];
		int i=0,j=0;
		for(i=0;i<=str1.length();i++){chess[i][0]=0;}
		for(j=0;j<=str2.length();j++){chess[0][j]=0;}
		for(i=1;i<=str1.length();i++){
			for(j=1;j<=str2.length();j++){
				if(str1.charAt(i-1)==str2.charAt(j-1)){chess[i][j] = chess[i-1][j-1]+1;}
				else{chess[i][j]=Math.max(chess[i-1][j], chess[i][j-1]);}
			}
		}
		i=str1.length();
		j=str2.length();
		StringBuffer str = new StringBuffer("");  
		while(i!=0 && j!=0){
			if(str1.charAt(i-1)==str2.charAt(j-1)){
				str=str.append(str1.charAt(i-1));
				i--;j--;
			}
			else{
				if(chess[i][j-1]>chess[i-1][j]){j--;}
				else{i--;}
			}
		}
		str.reverse();
		return str.toString();
	}
	
	public static void main(String[] args) {
		String str1="abcbab";
		String str2="bdcaba";
		String str=LCS(str1,str2);
		System.out.println(str);
	}
}
