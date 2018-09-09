package xiaozhao;

import java.math.BigDecimal;
import java.util.*;

import java.util.*;

public class jd001 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		int point = Integer.valueOf(line.split("\n")[0]);
        line = in.nextLine();
		int num =0 ;
		for(int j = 0 ; j<point ; j++){
        num = Integer.valueOf(line.split(" ")[1]);
        for(int i = 0 ; i < num ; i++){
            
            
        }
        if( j %  2 == 0) System.out.println("No");
        else {System.out.println("Yes");}
        }
	}
}