package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String -- easy
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples:
 *      s = "leetcode"
 *      return 0.
 *      s = "loveleetcode",
 *      return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
class Solution387 {
    /**
     * Runtime: 41 ms, faster than 42.17% of Java online submissions for First Unique Character in a String.
     * Memory Usage: 39.3 MB, less than 28.10% of Java online submissions for First Unique Character in a String.
     */
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        Map<Character , Integer> map = new HashMap<Character, Integer>();
        for(int i = 0 ; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))) map.put(s.charAt(i),-1);
            else map.put(s.charAt(i) , i);
        }
        for(int i = 0 ; i < s.length() ; i++){
            if(map.get(s.charAt(i))!= -1) return i;
        }
        return -1;
    }

    /**
     * Runtime: 46 ms, faster than 31.16% of Java online submissions for First Unique Character in a String.
     * Memory Usage: 39.9 MB, less than 16.61% of Java online submissions for First Unique Character in a String.
     */
    public int firstUniqChar2(String s) {
        HashMap<Character,Integer> hMap = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(!hMap.containsKey(ch)){
                hMap.put(ch, 1);
            }else{
                int count = hMap.get(ch);
                count = count +1;
                hMap.replace(ch, count);
            }
        }
        for(int i=0; i< s.length(); i++){
            int count = hMap.get(s.charAt(i));
            if(count == 1){
                return i;
            }
        }
        return -1;
    }
}
public class No387firstUniqChar {
    public static void main(String[] args){
        String string = "loveleetcode";
        System.out.println(new Solution387().firstUniqChar2(string));
    }
}
