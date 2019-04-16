package Stack;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 *      Input: ["2", "1", "+", "3", "*"]
 *      Output: 9
 *      Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *      Input: ["4", "13", "5", "/", "+"]
 *      Output: 6
 *      Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *      Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 *      Output: 22
 *      Explanation:
 *          ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 *      = ((10 * (6 / (12 * -11))) + 17) + 5
 *      = ((10 * (6 / -132)) + 17) + 5
 *      = ((10 * 0) + 17) + 5
 *      = (0 + 17) + 5
 *      = 17 + 5
 *      = 22
 */
class Solution150 {
    /**
     * Runtime: 7 ms, faster than 40.75% of Java online submissions for Evaluate Reverse Polish Notation.
     * Memory Usage: 38.3 MB, less than 29.24% of Java online submissions for Evaluate Reverse Polish Notation.
     */
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0 ) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(String str : tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (str.equals("+")) { stack.push(num2 + num1); }
                if (str.equals("-")) { stack.push(num2 - num1); }
                if (str.equals("*")) { stack.push(num2 * num1); }
                if (str.equals("/")) { stack.push(num2 / num1); }
            }
            else{
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.peek();
    }
}
public class No150evalRPN {
    public static void main(String[] args){
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution150().evalRPN(tokens));
    }
}
