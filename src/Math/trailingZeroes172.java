package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution172 {
//    public int trailingZeroes(int n) {
//        int count=0,num=0;
//        n=n-n%5;
//        while(n > 0){
//        	num=n;
//        	while(num >= 5){
//        		if(num % 5 == 0){count=count+1;num=num / 5;}
//        		else break;
//        	}
//            n=n-5;
//        }
//        return count;
//    }
	
	public int trailingZeroes(int n){
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}
	
}

public class trailingZeroes172 {
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int n = Integer.parseInt(line);
            int n=1808548329;
            int ret = new Solution172().trailingZeroes(n);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}