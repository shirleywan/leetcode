package Strings;

import java.io.IOException;

class Solution58 {
	/**
	 * 这里判断，只能输出最后一个以大写字母开头的单词；
	 */
//    public int lengthOfLastWord(String s) {
//    	if(s.length()==0){return 0;}
//    	if(s.length()==1){if(s.charAt(0)-'A'<26 && s.charAt(0)-'A'>=0){return 1;}
//    	                  else return 0;}
//    	int count=0,i=0;
//    	for(i=0;i<s.length()-1;i++){
//    		if (s.charAt(i)==' ') {
//    			count=i;
//			}
//    	}
//    	if(s.charAt(count+1)-'A'<26 && s.charAt(count+1)-'A'>=0){return s.length()-1-count;}
//    	if(s.charAt(s.length()-1)==' '){return 0;}
//        return 0;
//    }
	/**
	 * Good-idea!
	 */
//	public int lengthOfLastWord(String s) {
//		return s.trim().length()-s.trim().lastIndexOf(" ")-1;
//	}
	/**
	 * good-idea 2!
	 */
	public int lengthOfLastWord(String s){
	    String[] words = s.split(" ");
	    if (words.length==0) return 0;
	    else return words[words.length-1].length();
	}
}

public class lengthOfLastWord58 {
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
            String s=" a a";
            int ret = new Solution58().lengthOfLastWord(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
