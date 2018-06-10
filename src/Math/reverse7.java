package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.NumberUpSupported;

class Solution7 {
	/**
	 * Method1-work well
	 */
//    public long reverse7(int x) {
//    	List<Integer> list=new ArrayList<Integer>();
//    	boolean flag=false;
//    	if(x>=0) {flag=true;}
//    	x=Math.abs(x);
//    	while(x!=0) {
//    		list.add(x%10);
//    		x=x/10;
//    	}
//    	long num=0;
//    	for(int i=0;i<list.size();i++) {
//    		num=num*10+list.get(i);
//    	}
//    	if(flag==false) {num=-num;}
//    	return num;
//    }
	/**
	 * good_idea 1:
	 * if ((newResult - tail) / 10 != result)  { return 0; }
	 * or:if( count > Integer.MAX_VALUE || count < Integer.MIN_VALUE) return 0; 
	 * the former need count is long, because if count is int, it can be convert to some num beyong express
	 * @param x:
	 * @return
	 */
//	public int reverse(int x)
//	{
//	    int result = 0;
//	    while (x != 0)
//	    {
//	        int tail = x % 10;
//	        int newResult = result * 10 + tail;
//	        if ((newResult - tail) / 10 != result) 
//	        { return 0; }
//	        result = newResult;
//	        x = x / 10;
//	    }
//	    return result;
//	}
	/**
	 * Good_idea2:if( count > Integer.MAX_VALUE || count < Integer.MIN_VALUE) return 0; 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		long count=0;
		while(x != 0) {
			count = count * 10 + x % 10;
			x=x/10;
		}
		if( count > Integer.MAX_VALUE || count < Integer.MIN_VALUE) return 0;
		return (int)count;
	}
}

public class reverse7 {
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int x = Integer.parseInt(line);
            int x=1534236469;
            int ret = new Solution7().reverse(x);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
