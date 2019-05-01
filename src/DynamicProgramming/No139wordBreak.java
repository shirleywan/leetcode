package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 139. Word Break
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *      Input: s = "leetcode", wordDict = ["leet", "code"]
 *      Output: true
 *      Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *      Input: s = "applepenapple", wordDict = ["apple", "pen"]
 *      Output: true
 *      Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *      Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 *      Output: false
 */
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        if(wordDict == null || wordDict.size() == 0) return false;
        return wordBreak(s , 0 , s.length() , wordDict);
    }
    public boolean wordBreak(String s, int start, int end, List<String> wordDict){
        if(start == end ) return true;
        boolean flag = false;
        for(int i = start , j = i +1 ; j <= end ; j++){
            System.out.println(s.substring(i , j));
            if (wordDict.contains(s.substring(i, j))) {
                flag = wordBreak(s, j, end, wordDict);
            }
        }
        return flag ;
    }
    /**
     * good method
     *
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        /**
         * First DP
         * Runtime: 2 ms, faster than 98.30% of Java online submissions for Word Break.
         * Memory Usage: 36.7 MB, less than 77.76% of Java online submissions for Word Break.
         */
        for(int i = 1; i <= s.length(); i++){
            for(String str: wordDict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        /**
         * Second DP
         * Runtime: 4 ms, faster than 86.58% of Java online submissions for Word Break.
         * Memory Usage: 37.3 MB, less than 59.20% of Java online submissions for Word Break.
         */
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }


        return f[s.length()];
    }
}
public class No139wordBreak {
    public static void main(String[] args){
        String s = "abcd";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("a");wordDict.add("abc");wordDict.add("b");wordDict.add("cd");//wordDict.add("cat");
        System.out.println(new Solution139().wordBreak(s , wordDict));
    }
}
