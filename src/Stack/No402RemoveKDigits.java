package Stack;

/**
 * 402. Remove K Digits
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * Note:
 *      The length of num is less than 10002 and will be ≥ k.
 *      The given num does not contain any leading zero.
 * Example 1:
 *      Input: num = "1432219", k = 3
 *      Output: "1219"
 *      Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *      Input: num = "10200", k = 1
 *      Output: "200"
 *      Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *      Input: num = "10", k = 2
 *      Output: "0"
 *      Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * 【注】移除k个数字，不需要是连续的；
 * 要做到O(n)的时间复杂度，需要了解两件事情：
 *  1）如果有一个值，后面有很多0，且这些数字的位数>k，则优先删除这些数字；如num=1000349，k=2；
 *  2）如果不满足1，则优先删除最大的数字及其后续k-1个数字；
 */
class Solution402 {
    /**
     * O(n^n)
     */
    public String removeKdigits1(String num, int k) {
        if(num == null || num.length() == 0){return num;}
        if(k <= 0){return num;}
        if(num.length() == k){return "0";}
        long sub = 0;
        long max = Long.valueOf(num);
        for(int i = 0 ;i < num.length() - k+1 ; i++){
            sub = Long.valueOf(num.substring(0,i)+num.substring(i+k,num.length()));
            if(sub < max) max = sub;
        }
        return String.valueOf(max);
    }

    /**
     *method2：贪心
     * 先判断0是否存在，存在个数与k的关系
     */
    public String removeKdigits(String num, int k) {
        String res = helper(true, num, k);
        return res.isEmpty() ? "0" : res;
    }

    private String helper(boolean isStart, String num, int k){
        if(k == 0) return num;
        if(num.length() == k) return "";
        for(char c = '0'; c <= '9'; c++){
            int pos = num.indexOf(c); //如果num中不存在c，则返回-1；
            if(pos < 0)
                continue;
            if(pos <= k){
                if(isStart && c == '0') {
                    System.out.println("1: " + helper(isStart, num.substring(pos + 1), k - pos));
                    return helper(isStart, num.substring(pos + 1), k - pos);
                }
                System.out.println("2: "+c + helper(false, num.substring(pos + 1), k - pos));
                return c + helper(false, num.substring(pos + 1), k - pos);
            }
        }
        System.out.println("3: "+helper(isStart, num.substring(1), k - 1));
        return helper(isStart, num.substring(1), k - 1);
    }
}
public class No402RemoveKDigits {
    public static void main(String[] args){
        String num = "1002300";
        int k =2;
        System.out.println(new Solution402().removeKdigits(num , k));
    }
}
