package Strings;

import java.util.*;

/**
 * 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 * Example:
 *      Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *      Output:
 *      [
 *          ["ate","eat","tea"],
 *          ["nat","tan"],
 *          ["bat"]
 *      ]
 * Note:
 *      All inputs will be in lowercase.
 *      The order of your output does not matter.
 */
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){return null;}
        List<List<String>> total = new ArrayList<List<String>>();
        if(strs.length == 1){
            List<String> list = new ArrayList<String>();
            list.add(strs[0]);total.add(list);return total;
        }
        Map<String,Integer> map = new HashMap<String,Integer>();
        int count = 0;
        for(String string : strs){
            char[] ch = string.toCharArray();
            Arrays.sort(ch);
            String newString = String.valueOf(ch);
            if(map.containsKey(newString)){
                total.get(map.get(newString)).add(string);
            }
            else{
                map.put(newString , count);
                List<String> list = new ArrayList<String>();
                list.add(string);
                total.add(list);
                count ++;

            }
        }
//        System.out.println(total);
        for (List list : total){
            Collections.sort(list);
        }
        return total;
    }
}
public class No49GroupAnagrams {
    public static void main(String[] args){
//        String[] string = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] string = {"a"};
        System.out.println(new Solution49().groupAnagrams(string));
    }
}
