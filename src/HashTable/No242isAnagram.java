package HashTable;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution242 {
//    public boolean isAnagram(String s, String t) {
//    	if(s.length()!=t.length()) {return false;}
//    	s=s+s;
//    	if(s.contains(t)) {return true;}
//        return false;
//    }
//	public boolean isAnagram(String s, String t) {
//		if(s.length()!=t.length()) {return false;}
//		Map<Character,Integer> map=new HashMap<Character,Integer>();
//		Map<Character,Integer> map1=new HashMap<Character,Integer>();
//		for(char a:s.toCharArray()) {
//			if(map.containsKey(a)) {map.put(a, map.get(a)+1);}
//			else {map.put(a, 1);}
//		}
//		for(char a:t.toCharArray()) {
//			if(map1.containsKey(a)) {map1.put(a, map1.get(a)+1);}
//			else {map1.put(a, 1);}
//		}
//		for(char a:t.toCharArray()) {
//			if(map.get(a)!=map1.get(a)) {return false;}
//		}
//		return true;
//	}
	public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}

public class isAnagram242 {
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
            String s="aa";
            String t="a";
            boolean ret = new Solution242().isAnagram(s, t);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
//        }
    }
}
