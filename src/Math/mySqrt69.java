package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution69 {
    public int mySqrt(int x) {
    	if(x <= 0) { return 0; }
        int n=(int) Math.sqrt((double)x);
        return n;
    }
}

public class mySqrt69 {
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int x = Integer.parseInt(line);
            int x=8;
            int ret = new Solution69().mySqrt(x);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
