package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution6 {
    public String convert(String s, int numRows) {
    	int n=n=numRows/2;
    	if(numRows%2!=0){n=numRows/2+1;}
    	for(int i=0;i<numRows;i++){
    		int[] numi=new int[n];
    	}
        return "";
    }
}

public class ZigZagconvert6 {
    public static String stringToString(String input) {
        assert input.length() >= 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '\\') {
                char nextChar = input.charAt(i+1);
                switch (nextChar) {
                    case '\"': sb.append('\"'); break;
                    case '/' : sb.append('/'); break;
                    case '\\': sb.append('\\'); break;
                    case 'b' : sb.append('\b'); break;
                    case 'f' : sb.append('\f'); break;
                    case 'r' : sb.append('\r'); break;
                    case 'n' : sb.append('\n'); break;
                    case 't' : sb.append('\t'); break;
                    default: break;
                }
                i++;
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            String s = stringToString(line);
//            line = in.readLine();
//            int numRows = Integer.parseInt(line);
            String s="PAYPALISHIRING";
            int numRows=3;
            String ret = new Solution6().convert(s, numRows);
            
            String out = (ret);
            
            System.out.print(out);
//        }
    }
}
