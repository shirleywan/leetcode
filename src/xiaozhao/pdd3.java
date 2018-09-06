package xiaozhao;

/**
 * 求小数循环节开始和循环节长度,模拟除法;
 */
import java.awt.Frame;
import java.math.BigDecimal;
import java.util.Scanner;

public class pdd3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		String[] str = string.split(" ");
		BigDecimal n = new BigDecimal(str[0]);
		BigDecimal m = new BigDecimal(str[1]);
//		String res = "";
		BigDecimal res = new BigDecimal(0);
		int count = 0;
		if(isNonterminating(n, m)){
			res = n.divide(m,10,BigDecimal.ROUND_CEILING);
			System.out.println(res);
			String line = res.toString().split(".")[1];
			for(int i = 0 ;i < line.length() ; i++){
				if(line.charAt(i) == line.charAt(i+1)){
					
				}
			}
		}
		else{
			System.out.println("0"+" "+"1");
		}
		
	}
	public static boolean isNonterminating(BigDecimal n , BigDecimal m){  
	     try{  
//	         BigDecimal bigA=new BigDecimal(n);  
//	         BigDecimal bigB=new BigDecimal(m);  
//	         System.out.println("a/b="+bigA.divide(bigB));
	    	 System.out.println("a/b="+n.divide(m));
	         return false;  
	     }catch(Exception e){  
	         return true;  
	     }  
	} 
}
