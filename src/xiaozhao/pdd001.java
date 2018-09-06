package xiaozhao;

import java.math.BigDecimal;
import java.util.Scanner;

import Math.addBinary67;

/**
 * 打怪物，贪心，比一下蓄力和不蓄力区别就行了;
 *
 */
public class pdd001 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigDecimal total = new BigDecimal(in.nextLine());
		BigDecimal n = new BigDecimal(in.nextLine());
		BigDecimal m = new BigDecimal(in.nextLine());
		BigDecimal res = new BigDecimal(0);
		if(total.compareTo(n)==-1){System.out.println(1);}
		if( m .compareTo(n.add(n)) == 1){
			res = (total.divide(m,0,BigDecimal.ROUND_UP)).add(total.divide(m,0,BigDecimal.ROUND_UP));
			if(res.multiply(m).subtract(total).compareTo(n) == -1 ){res = res.subtract(new BigDecimal(1));}
			System.out.println(res);
		}
		else{
			System.out.println(total.divide(n,0,BigDecimal.ROUND_UP));
		}
	}
}
