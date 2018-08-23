package leetcode;

import java.util.*;

/**
 * evaluate-reverse-polish-notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * 遇到数字放入栈，遇到操作符，就取出当前栈顶两个值做计算
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
class Solution2{
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        StringBuffer stringBuffer = new StringBuffer();
        int result= 0 ; 
        if(tokens.length == 0){return 0;}
        if(tokens.length == 1){
        	if(isOperate(tokens[0])){return 0;}
        	else{ return Integer.valueOf(tokens[0]); }
        }
        for(String str: tokens){
        	
        	if(!isOperate(str)){stack.push(Integer.valueOf(str));}
        	else{
        		if(str.equals("+")){result= stack.pop();result = result + stack.pop();stack.push(result);}
        		if(str.equals("-")){result= stack.pop();result = stack.pop() - result;stack.push(result);}
        		if(str.equals("*")){result= stack.pop();result = result * stack.pop();stack.push(result);}
        		if(str.equals("/")){result= stack.pop();result = stack.pop() / result;stack.push(result);}
        	}
        } 
        return result;
    }
    public boolean isOperate(String string){
    	if(string.equals("+") ||string.equals("-")||string.equals("*")||string.equals("/")){
    		return true;
    	}
    	return false;
    }
}
public class No2 {
    public static void main(String[] args){
    	String[] string = {"18"};
    	System.out.println(new Solution2().evalRPN(string));
    }
}
