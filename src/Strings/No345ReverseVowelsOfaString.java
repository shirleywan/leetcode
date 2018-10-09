package Strings;

/**
 * 345. Reverse Vowels of a String
 * vowels：元音
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *  Input: "hello"
 *  Output: "holle"
 * Example 2:
 *  Input: "leetcode"
 *  Output: "leotcede"
 * Note:
 *  The vowels does not include the letter "y".
 */
class Solution345 {
    public String reverseVowels(String s) {
        if(s.length() == 0 || s.length() == 1 ){return s;}
        char[] ch = s.toCharArray();
        int i = 0 , j = s.length()-1;
        while(i < j && i < s.length() && j >=0){
            while(i < s.length() && ch[i] != 'a' && ch[i] != 'e' && ch[i] != 'i' && ch[i] != 'o' && ch[i] != 'u' && ch[i] != 'A' && ch[i] != 'E' && ch[i] != 'I' && ch[i] != 'O' && ch[i] != 'U'){
                i++;
            }
            while(j >=0 && ch[j] != 'a' && ch[j] != 'e' && ch[j] != 'i' && ch[j] != 'o' && ch[j] != 'u' && ch[j] != 'A' && ch[j] != 'E' && ch[j] != 'I' && ch[j] != 'O' && ch[j] != 'U'){
                j--;
            }
            if( i < j){
                char tmp = ch[i];
                ch[i] = ch[j];
                ch[j] = tmp;
                i++;j--;
            }
        }
        return String.valueOf(ch);
    }
}
public class No345ReverseVowelsOfaString {
    public static void main(String[] args){
        String str = ".,";
        System.out.println(new Solution345().reverseVowels(str));
    }
}
