package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution3 {
//    public int lengthOfLongestSubstring(String s) {
//    	int count=0;
//    	String str="";
//    	for(int i=0;i<s.length();i++){
//    		str=""+s.charAt(i);
//    		for(int j=i+1;j<s.length();j++){
//    			if (!str.contains(String.valueOf(s.charAt(j)))) {str=str+s.charAt(j);}
//    			else{if(str.length()>count){count=str.length();}
//    				break;}
//    		}
//    		count=Math.max(count, str.length());
//    	}
//    	return count;
//    }
    public int lengthOfLongestSubstring(String s) {
    	int count=0;
    	String str="";
    	for(char a:s.toCharArray()){
    		if(!str.contains(String.valueOf(a))){str=str+a;}
    	}
    	System.out.println(str);
    	int[] nums=new int[str.length()];
    	for(int i=0;i<nums.length;i++){
    		nums[i]=s.indexOf(str.charAt(i));
    		System.out.println(nums[i]);
    	}
    	
    	return count;
    }
}

public class lengthOfLongestSubstring3 {
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
            String s="dvdf";
            int ret = new Solution3().lengthOfLongestSubstring(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
