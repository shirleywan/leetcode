package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution28 {
//    public int strStr(String haystack, String needle) {
//    	if(haystack.contains(needle)) {return haystack.indexOf(needle);}
//        return -1;
//    }
	//Good-idea1:
	public int strStr(String haystack, String needle) {
		  for (int i = 0; ; i++) {
		      for (int j = 0; ; j++) {
		    	  if (j == needle.length()) return i;
		    	  if (i + j == haystack.length()) return -1;
		    	  if (needle.charAt(j) != haystack.charAt(i + j)) break;
		      }
		  }
	}
}

public class strStr28 {
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
//            String haystack = stringToString(line);
//            line = in.readLine();
//            String needle = stringToString(line);
    		String haystack="abcd";
    		String needle="cb";
            int ret = new Solution28().strStr(haystack, needle);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
