package Strings;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
class Solution17 {
    /**
     * 这里不对，使用queue会导致这层刚放入的元素也被取出来，但是只需要上一层的
     */
    public List<String> letterCombinations1(String digits) {
        if(digits == null || digits.length() == 0){return null;}
        if(Integer.valueOf(digits) == 0){return null;}
        Queue<StringBuilder> queue = new LinkedList<StringBuilder>();
//        List<StringBuilder> list = new ArrayList<StringBuilder>() ;
        List<String> alphabet = new ArrayList<String>();
        List<String> totalList = new ArrayList<String>();
        alphabet.add( " "  ); alphabet.add( ""  ); alphabet.add("abc" ); alphabet.add("def");
        alphabet.add("ghi" ); alphabet.add("jkl"); alphabet.add("mno" );
        alphabet.add("pqrs"); alphabet.add("tuv"); alphabet.add("wxyz");
        if(digits.charAt(0) - '0' == 0 || digits.charAt(0) - '0' == 1){
            digits = digits.substring(1 , digits.length());
        }
        else{
            for(int i = 0 ; i < alphabet.get(digits.charAt(0) - '0').length() ; i ++) {
                StringBuilder buffer = new StringBuilder();
                buffer.append(alphabet.get(digits.charAt(0) - '0').charAt(i));
                queue.add(buffer);
            }
        }
        int i =1 ;
        for( i = 1 ; i < digits.length() ; i++){
            int num = digits.charAt(i) - '0';
            if(num == 0){
                System.out.println("num = 0");
                while(!queue.isEmpty()){
                    StringBuilder buffer = queue.poll();
                    buffer.append(" ");
                    queue.offer(buffer);
                }
            }
            else{
                System.out.println("num != 1");
                if(num != 1){
                    while(!queue.isEmpty()) {
                        StringBuilder buffer = queue.poll();
                        System.out.println(buffer);
                        for (int m = 0; m < alphabet.get(num).length(); m++) {
                            queue.offer(buffer.append(alphabet.get(num).charAt(m)));
                            buffer.deleteCharAt(buffer.length() - 1);
                        }
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            totalList.add(queue.poll().toString().trim());
        }
        return totalList;
    }

    /**
     * 参考方法
     */
    char[][] lettersByDigits = new char[][]{{}, {'*'}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>(0);
        for (int i = digits.length() - 1; i >= 0; i--) {
            char[] letters = lettersByDigits[digits.charAt(i) - '0'];
            List<String> list = new ArrayList<>(combinations.size() * letters.length);
            for (char ch : letters) {
                if (combinations.size() == 0) {
                    list.add("" + ch);
                } else {
                    for (String combination : combinations) {
                        list.add(ch + combination);
                    }
                }
            }
            combinations = list;
        }
        return combinations;
    }

}
public class No17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args){
        String string = "23";
        System.out.println(new Solution17().letterCombinations(string));
    }
}
