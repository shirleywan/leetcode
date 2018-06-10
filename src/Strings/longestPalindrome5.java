package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Solution5 {
	//笨方法 O(n^2) 
//    public String longestPalindrome(String s) {
//    	String str=""+s.charAt(0);
//    	List list=new ArrayList();
//    	int i=0,j=0;
//    	for(i=0;i<s.length();i++){
//    		for(j=i+1;j<s.length();j++){
//    			if(isPalindrome(s.substring(i,j))){
//    				if(str.length()<s.substring(i,j).length()){str=s.substring(i,j);}
//    			}
//    		}
//    		if(isPalindrome(s.substring(i,j))){
//				if(str.length()<s.substring(i,j).length()){str=s.substring(i,j);}
//			}
//    	}
//        return str;
//    }
//	public boolean isPalindrome(String s) {
//        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
//        String rev = new StringBuffer(actual).reverse().toString();
//        return actual.equals(rev);
//    }
	//Good-idea:
	public String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for(int i=0;i<s.length();i++){
        	System.out.print(isPalindrome(s,i-currLength-1,i));
            if(isPalindrome(s,i-currLength-1,i)){
                res = s.substring(i-currLength-1,i+1);//substring(),左闭右开,因此只存入(i-currLength-1,i)
                System.out.println("1"+res);
                currLength = currLength+2;
            }
            else {System.out.println(isPalindrome(s,i-currLength,i)); 
            	if(isPalindrome(s,i-currLength,i)){
                res = s.substring(i-currLength,i+1); //substring(),左闭右开,因此只存入(i-currLength,i)
                System.out.println("2"+res);
                currLength = currLength+1;
            }
            }
        }
        return res;
    }
    
    public boolean isPalindrome(String s, int begin, int end){
        if(begin<0) return false;
        while(begin<end){
        	if(s.charAt(begin++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}

public class longestPalindrome5 {
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
            String s="abcd";
            String ret = new Solution5().longestPalindrome(s);
            
            String out = (ret);
            
            System.out.print(out);
 //       }
    }
}