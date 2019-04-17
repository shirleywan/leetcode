package HashTable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Solution {
	/**
	 * 自己实现 我觉得还不错~
	 * @param s1
	 * @param s2
	 * @return
	 */
//    public boolean isIsomorphic(String s, String t) {
//    	if(s.length()!=t.length()) {return false;}
//    	Map map=new HashMap();
//    	for(int i=0;i<s.length();i++) {
//    		if(map.containsKey(s.charAt(i))) {if(t.charAt(i)!=(char)map.get(s.charAt(i))) {return false;}}
//    		else{if(map.containsValue(t.charAt(i))) {return false;}
//    			map.put(s.charAt(i), t.charAt(i));}
//    	}
//        return true;
//    }
	public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        for(int i=0;i<s1.length();i++) {
        	System.out.print(m[i]);
        }
        return true;
    }
}

public class isIsomorphic205 {
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
//            line = in.readLine();
//            String t = stringToString(line);
            String s="foo";
            String t="bar";
            boolean ret = new Solution().isIsomorphic(s, t);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
//        }
    }
}
