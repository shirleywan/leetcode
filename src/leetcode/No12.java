package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * word-break
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code".
 */
class Solution12{
    public boolean wordBreak(String s, Set<String> dict) {
        return false;
    }
}
public class No12 {
    public static void main(String[] args){
        String s ="catsanddog";
        Set<String> dict = new HashSet<String>();
        dict.add("cat");dict.add("cats");dict.add("and");dict.add("sand");dict.add("dog");
        System.out.println(new Solution12().wordBreak(s,dict));
    }
}
