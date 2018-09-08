package xiaozhao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class wangyi006 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		int num = Integer.valueOf(line.split("\n")[0]);
		BigDecimal n = new BigDecimal(0);
		BigDecimal m = new BigDecimal(0);
		BigDecimal count = new BigDecimal(0);
		BigDecimal p = new BigDecimal(2);
		for(int i = 0 ; i < num ;i++){
			line = in.nextLine();
			m= new BigDecimal(line.split(" ")[0]);
			n =  new BigDecimal(line.split(" ")[1]);
			if( n.compareTo(new BigDecimal(2)) == 1 && m.compareTo(new BigDecimal(2)) == 1){count = (n.subtract(p).multiply(m.subtract(p)));}
				else {
					if (n.compareTo(new BigDecimal(1)) == 0 &&m.compareTo(new BigDecimal(1)) == 0 ){count = new BigDecimal(1);}
					else{
						if(n.compareTo(m) == 1){count = n.subtract(p);}
						else{count = m.subtract(p);}
//						count = BigDecimal.valueOf(n.compareTo(m) == 1 ? new BigInteger(n.subtract(new BigDecimal(2))):new BigInteger(m.subtract(new BigDecimal(2))) );}
				}
//				System.out.println(count);
		}
			System.out.println(count);
		
	}
}
}
