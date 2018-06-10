package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution168 {
    public String convertToTitle(int n) {
        if( n<=0 ) return "";
        StringBuilder line = new StringBuilder();
        while( n > 0 ){
        	n--;
        	line.insert(0, (char)(n%26+'A')); //27就不一定余几了啊!!
        	n = n / 26 ;
        }        
        return line.toString();
    }
}

public class convertToTitle168 {
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int n = Integer.parseInt(line);
            int n=52;
            String ret = new Solution168().convertToTitle(n);
            
            String out = (ret);
            
            System.out.print(out);
//        }
    }
}