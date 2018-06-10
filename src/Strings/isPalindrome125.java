package Strings;

import java.io.IOException;

class Solution125 {
//    public boolean isPalindrome(String s) {
//    	System.out.println(Character.isLetterOrDigit(s.charAt(0)));
//    	if(s.length()<=1){return true;}
//    	s=s.toLowerCase();
//    	int i=0,j=s.length()-1;
//    	while(i<j) {
//			if(istrue(s.charAt(i)) && istrue(s.charAt(j))){
//				if(s.charAt(i)!=s.charAt(j)){return false;}
//				i++;j--;
//			}
//			if(!istrue(s.charAt(i))){i++;}
//			if(!istrue(s.charAt(j))){j--;}
//		}
//        return true;
//    }
//    public boolean istrue(char a){
//    	if((a>='A' && a<='Z')||(a>='a' &&a<='z')||(a>='0' && a<='9')){return true;}
//    	return false;
//    }
	/**
	 * Good-idea-1:
	 * @param s
	 * @return
	 */
//	public boolean isPalindrome(String s) {
//        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
//        String rev = new StringBuffer(actual).reverse().toString();
//        return actual.equals(rev);
//    }
	/**
	 * good idea 3:
	 */
	private static final char[]charMap = new char[256];
	static{
	    for(int i=0;i<10;i++){
	        charMap[i+'0'] = (char)(1+i);  // numeric
	    }
	    for(int i=0;i<26;i++){
	        charMap[i+'a'] = charMap[i+'A'] = (char)(11+i);  //alphabetic, ignore cases
	    }
	}
	public boolean isPalindrome(String s) {
	    char[]pChars = s.toCharArray();
	    int start = 0,end=pChars.length-1;
	    char cS,cE;
	    while(start<end){
	        cS = charMap[pChars[start]];
	        cE = charMap[pChars[end]];
	        if(cS!=0 && cE!=0){
	            if(cS!=cE)return false;
	            start++;
	            end--;
	        }else{
	            if(cS==0)start++;
	            if(cE==0)end--;
	        }
	    }
	    return true;
	}
}

public class isPalindrome125 {
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
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            String s = stringToString(line);
            String s=".0 P.";
            boolean ret = new Solution125().isPalindrome(s);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
//        }
    }
}
