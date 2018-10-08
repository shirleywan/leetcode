package Strings;

/**
 * 344. Reverse String
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example 1:
 *      Input: "hello"
 *      Output: "olleh"
 * Example 2:
 *      Input: "A man, a plan, a canal: Panama"
 *      Output: "amanaP :lanac a ,nalp a ,nam A"
 */
import java.util.*;
class Solution344 {
    public String reverseString(String s) {
        if(s.length() == 0 || s.length() == 1){return s;}
        char[] ch = s.toCharArray();
        char tmp ;
        int n = ch.length-1;
        for(int i = 0 ; i < ch.length/2 ; i++){
            tmp = ch[i];
            ch[i] = ch[n-i];
            ch[n-i] = tmp;
        }
        return String.valueOf(ch);
    }
}
public class No344ReverseString {
    public static void main(String[] args){
        String str = "hello";
        System.out.println(new Solution344().reverseString(str));
    }
}
