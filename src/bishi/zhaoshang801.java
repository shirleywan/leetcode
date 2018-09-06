package bishi;

import java.util.*;
/**
 * 判断字符串是否合法
 */
public class zhaoshang801 {
	public static boolean isConcat(String string){
		if(string.length() <= 1){return false;}
		Stack<Character> stack = new Stack<Character>();
		char[] ch = string.toCharArray();
		for(char c:ch){
			if(c == '(') {stack.push('(');}
			if(c == ')'){
				if(!stack.isEmpty()){stack.pop();}
				else{return false;}
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		String string = "()()";
		System.out.println(isConcat(string));
	}
}
