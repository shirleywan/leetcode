package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Example 1:
 *      Input: pattern = "abba", str = "dog cat cat dog"
 *      Output: true
 * Example 2:
 *      Input:pattern = "abba", str = "dog cat cat fish"
 *      Output: false
 * Example 3:
 *      Input: pattern = "aaaa", str = "dog cat cat dog"
 *      Output: false
 * Example 4:
 *      Input: pattern = "abba", str = "dog dog dog dog"
 *      Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
class Solution290 {
    /**
     * my method
     */
    public boolean wordPattern1(String pattern, String str) {
        if(pattern == null || pattern.length() == 0 || str == null || str.length() == 0) return false;
        String[] ch = str.split(" ");
        if(pattern.length() != ch.length) {return false;}
        Map<Character , String> map1 = new HashMap<Character , String>();
        Map<String , Character> map2 = new HashMap<String , Character>();
        for(int i = 0 ; i < pattern.length() ; i++){
            if(map1.containsKey(pattern.charAt(i)) || map2.containsKey(ch[i])){
                if(!ch[i].equals(map1.get(pattern.charAt(i)))) return false;
                if(map2.get(ch[i]) != pattern.charAt(i)) return false;
            }
            else{
                map1.put(pattern.charAt(i), ch[i]);
                map2.put(ch[i], pattern.charAt(i));
            }
//            System.out.println("map1: "+map1.toString());
//            System.out.println("map2: "+map2.toString());
        }
        return true;
    }

    /**
     * good method 1 ： notice！
     */
    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i)){
                // 比较能不能放到map里，如果map里有相同的元素，则返回0，不会更新，
                // 如果一个被放入，一个没有，则代表出错；
//                System.out.println(index.put(pattern.charAt(i), i));
//                System.out.println(index.put(words[i], i));
                return false;
            }
            //另一种写法
        //    for (int i=0; i<words.length; ++i)
        //        if (!Objects.equals(index.put(pattern.charAt(i), i),
        //                            index.put(words[i], i)))
        //            return false;
        return true;
    }

    /**
     * good method 2
     */
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map = new HashMap<>();
        char[] s = pattern.toCharArray();
        String[] word = str.split(" ");

        if(s.length!=word.length) return false;

        for(int i=0;i<word.length;i++){
            if(!map.containsKey(s[i])){
                if(i>0 && map.get(s[i-1]).equals(word[i])) return false;//检测不同pattern对应同样的word这种情况
                 // 这句好像是专门为某个例子写的，没有通用性
                else map.put(s[i],word[i]);
            }
            else if(map.containsKey(s[i]) && !map.get(s[i]).equals(word[i])){
                return false;
            }
        }
        return true;
    }
}
public class No290WordPattern {
    public static void main(String[] args){
        String pattern = "abba" ;
        String str = "dog dog dog dog";
        System.out.println(new Solution290().wordPattern(pattern , str));
    }
}
