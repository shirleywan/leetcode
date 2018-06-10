package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
//    public boolean isValid(String s) {
//    	if(s.length()==0 || s.length() %2 !=0 ) {return false;}
//    	int count=0;
//    	List list=new ArrayList();
//    	for(int i=0;i<s.length();i++) {
//    		if(list.size()==0) {if(s.charAt(0)==')'||s.charAt(0)==']'||s.charAt(0)=='}') {return false;}}
//    		if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') {list.add(s.charAt(i));count++;}
//    		else {
//    			if(s.charAt(i)==')') {
//    				if(((char)list.get(count-1)) != '(' ) {return false;}
//    				else {list.remove(count-1);count--;}
//    			}
//    			if(s.charAt(i)==']') {
//    				if(((char)list.get(count-1)) != '[' ) {return false;}
//    				else {list.remove(count-1);count--;}
//    			}
//    			if(s.charAt(i)=='}') {
//    				if(((char)list.get(count-1)) != '{' ) {return false;}
//    				else {list.remove(count-1);count--;}
//    			}
//    		}
//    	}
//    	if(list.size()==0) {return true;}
//    	return false;
//    }
	//Good-idea-1:
//	public boolean isValid(String s) {
//		Stack<Character> stack = new Stack<Character>();
//		for (char c : s.toCharArray()) {
//			if (c == '(')
//				stack.push(')');
//			else if (c == '{')
//				stack.push('}');
//			else if (c == '[')
//				stack.push(']');
//			else if (stack.isEmpty() || stack.pop() != c)
//				return false;
//		}
//		System.out.println(stack);
//		return stack.isEmpty();
//	}
	public boolean isValid(String s) {
        Stack<Integer> p = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            int q = "(){}[]".indexOf(s.substring(i, i + 1));
            if(q % 2 == 1) {
                if(p.isEmpty() || p.pop() != q - 1) return false;
            } 
            else p.push(q);
        }
        return p.isEmpty();
    }
}

public class isValid20 {
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
            String s= "()]";
            boolean ret = new Solution().isValid(s);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
//        }
    }
}
