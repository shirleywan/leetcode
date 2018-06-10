package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution9 {
	/**
	 * to distinguish whether the number is Palindrome 
	 * the first line is so stupid...
	 * @param x
	 * @return
	 */
    public boolean isPalindrome(int x) {
    	if (x<0 || (x!=0 && x==0)) return false;
    	long count=0;
    	int odd=x;
    	while(x != 0) {
    		count=count*10 + x % 10;
    		x = x / 10;
    	}
    	if(odd==count) return true;
    	return false;
    }
}

public class isPalindrome9 {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int x = Integer.parseInt(line);
            int x=-2147447412;
            boolean ret = new Solution9().isPalindrome(x);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
//        }
    }
}