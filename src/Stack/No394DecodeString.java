package Stack;

import java.util.*;

/**
 * 394. Decode String
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Examples:
 *      s = "3[a]2[bc]", return "aaabcbc".
 *      s = "3[a2[c]]", return "accaccacc".
 *      s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
class Solution394 {
    /**
     * method 1: with stack
     */
    public String decodeString(String s) {
        if(s == null || s.length() == 0){return s;}
        int begin = s.indexOf('[');
        String str = "";
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stack1 = new Stack<Integer>();
        if(begin < 0){return s;}
        else{
            if(begin == 0){
                return s.substring(1,s.length()-1);
            }
            else{
                int i = 0;
                int p = 0;
                while (!stack.isEmpty() || i < s.length()) {
                    if(s.charAt(i)-'0' >=0 && s.charAt(i)-'0' <= 9){
                        p++;
                    }
                    else {
                        if (s.charAt(i) == '[') {stack.push(i-p); p = 0;}
                        if (s.charAt(i) == ']') {
                            int n = stack.pop();
                            String string = find(s, n, i );
                            s = s.substring(0, n - p) + string + s.substring(i + 1, s.length());
                            i = n - p + string.length() - 1;
                        }
                    }
                    if (i >= s.length()) break;
                    i++;
                }
            }
        }
        return s;
    }
    public String find(String s,int begin , int end ){
        if(s.substring(begin , end).indexOf('[') == 0) {return s.substring(begin+1 , end);}
        String string = "";
        int num = 0;
        int p = begin;
        for( p =begin ; p < end ; p++){
            if(s.charAt(p)-'0' >=0 && s.charAt(p) - '0' <= 9){
                num = num *10 + s.charAt(p) -'0';
            }
            else{
                if(s.charAt(p) == '[') break;
            }
        }
        for(int i = 0 ; i < num ; i++){
            string = string + s.substring(p+1 , end);
        }
        return string;
    }
    /**
     * method 2: DFS, without stack
     */
    private int i = 0;
    public String decodeString1(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                i++;
                String str = decodeString(s);
                for (int k = 0; k < num; k++)
                    sb.append(str);
                num = 0;
            } else if (c == ']') {
                return sb.toString();
            } else {
                sb.append(c);
            }
            i++;
        }

        return sb.toString();
    }

    /**
     *method 3：迭代，没有使用到stack
     */
    public String decodeString3(String s) {

        if (s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit_begin = i;
                while (s.charAt(i) != '[') i++;
                int num = Integer.valueOf(s.substring(digit_begin, i));
                int count = 1;
                int str_begin = i+1;
                i ++;
                while (count != 0) { //直接跳到这对[]的最后一项
                    if (s.charAt(i) == '[') count ++;
                    else if (s.charAt(i) == ']') count --;
                    i ++;
                }
                i--;
                String str = decodeString3(s.substring(str_begin, i));//找出这个[]内子串decode后的string结构
                for (int j = 0; j < num; j ++) {
                    sb.append(str);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
public class No394DecodeString {
    public static void main(String[] args){
        String string = "2[abc]3[cd]ef";
        System.out.println(new Solution394().decodeString(string));
    }
    
}
