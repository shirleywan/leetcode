package Strings;

import java.util.HashSet;
import java.util.*;

/**
 * 8. String to Integer (atoi)
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *      Input: "42"
 *      Output: 42
 * Example 2:
 *      Input: "   -42"
 *      Output: -42
 *      Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *      Input: "4193 with words"
 *      Output: 4193
 *      Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *      Input: "words and 987"
 *      Output: 0
 *      Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *      Input: "-91283472332"
 *      Output: -2147483648
 *      Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 */
class Solution8 {
    /**
     * 很好的写法！学习
     */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;//
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) sum * sign;
    }

    /**
     * 自己写的 有点蠢
     */
    public int myAtoi1(String str) {
        if(str.length() == 0){return 0;}
        if(str == " "){return 0;}
        Set<Character> set = new HashSet<Character>();
//        set.add('+');set.add('-');
        for(int i = 0 ; i <= 9 ; i++){
            set.add(Character.forDigit(i,10));
        }
//        System.out.println(set.toString());
        StringBuffer buffer = new StringBuffer();
        int count = 0;
        str = str.trim();
        boolean flag = true;
        if(!set.contains(str.charAt(0)) &&str.charAt(0) != '+' && str.charAt(0) != '-'){
            return 0;
        }
        if(str.charAt(0) == '+' || str.charAt(0) == '-'){
            if(str.charAt(0) == '+') {flag = true;}
            else {flag = false;}
            buffer.append(str.charAt(0));
            str = str.substring(1,str.length());
        }
        for(int i = 0 ;i < str.length(); i++){
                if (set.contains(str.charAt(i))) {
                    buffer.append(str.charAt(i));
                }
                else{break;}
        }
//        System.out.println(buffer.toString());
        long number = 0;

        if(buffer.length() == 0){return 0;}
        else{
            if(buffer.charAt(0) == '+' || buffer.charAt(0) == '-'){
                if(buffer.charAt(0) == '-'){flag = false;}
                for(int i = 1 ; i < buffer.length() ; i++) {
                    number = number * 10 + (buffer.charAt(i) - '0');
                    if(number > Integer.MAX_VALUE){
                        if(flag){return Integer.MAX_VALUE;}
                        else{return Integer.MIN_VALUE;}
                    }
                }
            }
            else{
                for(int i = 0 ; i < buffer.length() ; i++) {
                    number = number * 10 + (buffer.charAt(i) - '0');
                    if(number > Integer.MAX_VALUE){return Integer.MAX_VALUE;}
                }
            }
//            System.out.println(number);
        }
        if(!flag){
            number = -1 * number;
        }
        if(number > Integer.MAX_VALUE){return Integer.MAX_VALUE;}
        if(number < Integer.MIN_VALUE){return Integer.MIN_VALUE;}
        return (int)number;
    }
}
public class No8StringToInteger {
    public static void main(String[] args){
        String string = "words and 987";
//        String string = "0-1";
        System.out.println(new Solution8().myAtoi(string));
    }
}
