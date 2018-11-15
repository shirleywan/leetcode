package Strings;

/**
 * 459. Repeated Substring Pattern
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 *      Input: "abab"
 *      Output: True
 *      Explanation: It's the substring "ab" twice.
 * Example 2:
 *      Input: "aba"
 *      Output: False
 * Example 3:
 *      Input: "abcabcabcabc"
 *      Output: True
 *      Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
class Solution459 {
    public boolean repeatedSubstringPattern1(String s) {
        if(s == null || s.length() == 0) return true;
        if(s.length() == 1) return false;
        int i = 1;
        if(!s.substring( 1, s.length()).contains((s.substring(0,1)))) return false;
        while(s.substring(i , s.length()).contains(s.substring(0 , i))){
            i++;
        }
        String pattern = s.substring(0 , i-1);
        i--;
        int n = pattern.length();
//        System.out.println(i+","+n);
//        System.out.println(pattern);
        if(s.length()% n != 0) return false;
        int count = 0;
        while( (i+(count+1) *n) <= s.length()){
            if(!pattern.equals(s.substring(i+count*n , i+(count+1) *n))){return false;}
            count ++;
        }
        return true;
    }

    /**
     * 后面和前面对调，查看是否与原str相同；
     */
    public boolean repeatedSubstringPattern(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }
}
public class No459RepeatedSubstringPattern {
    public static void main(String[] args){
        String string = "abababab";
        System.out.println(new Solution459().repeatedSubstringPattern(string));
    }
}
