package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 151. Reverse Words in a String
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *      Input: "the sky is blue",
 *      Output: "blue is sky the".
 * Note:
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 */
class Solution151 {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0 ||s.trim() == "") {return "";}
        int i = 0 , j =0;
        s = s.trim();
        List<String> list = new ArrayList<String>();
        while(i < s.length()){
            while( i < s.length() && s.charAt(i) == ' '){
                i ++;
            }
            j = i ;
            while( j < s.length() && s.charAt(j) != ' ' ){
                j++;
            }
            list.add(s.substring(i , j));
            i = j+1;
        }
        System.out.println(list);
        String newstring = "";
        for( j = list.size()-1; j >=0 ; j--){
            newstring = newstring +" " + list.get(j);

        }
        return newstring.trim();
    }
}
public class No151ReverseWordsInAString {
    public static void main(String[] args){
//        String string = "   a   b ";
        String string = "     a      b  ";
        System.out.println(new Solution151().reverseWords(string));
    }
}
