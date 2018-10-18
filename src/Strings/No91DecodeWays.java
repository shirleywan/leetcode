package Strings;

/**
 * 91. Decode Ways
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *      'A' -> 1
 *      'B' -> 2
 *      ...
 *      'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * Example 1:
 *      Input: "12"
 *      Output: 2
 *      Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *      Input: "226"
 *      Output: 3
 *      Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
class Solution91 {
    /**
     * 动态规划 -- 迭代实现，复杂性较高
     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){return 0;}
        if(s.length() == 1 && Long.valueOf(s) == 0){return 0;}
        return numDecodings(s , 0 );
    }
    public int numDecodings(String s , int start){
        if(start > s.length()-1 || start > s.length()-1){return 1;}
        if(s.charAt(start) - '0' == 0){return 0;}
        int count = 0 ;
        if(start == s.length()-1) {return 1;}
        else{
            if(start+1 <= s.length()-1){
//                System.out.println(Integer.valueOf(s.charAt(start)));
                if((s.charAt(start)-'0') *10 + (s.charAt(start+1)-'0') <= 26) {
                    count = 1;
                }
                else{
                    count = 0;
                }
            }
        }
//        System.out.println("count:"+count);
        return 1 * numDecodings(s,start+1 ) + count * numDecodings(s,start+2 );
    }
    /**
     * 动态规划 -- 数组记录计算结果
     */
    public int numDecodings1(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
public class No91DecodeWays {
    public static void main(String[] args){
        String string = "10";
        System.out.println(new Solution91().numDecodings(string));
    }
}
