package Strings;

/**
 * 383. Ransom Note
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note: You may assume that both strings contain only lowercase letters.
 *  canConstruct("a", "b") -> false
 *  canConstruct("aa", "ab") -> false
 *  canConstruct("aa", "aab") -> true
 */
import java.util.*;
class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() == 0) return true;
        if(magazine.length() <= 0) return false;
        int[] nums = new int[26];
        for(int i = 0 ; i < magazine.length() ; i++){
            nums[magazine.charAt(i) - 'a'] ++;
        }
        for(int i = 0 ; i < ransomNote.length() ; i++){
            nums[ransomNote.charAt(i)-'a'] --;
            if(nums[ransomNote.charAt(i)- 'a'] < 0) return false;
        }
        return true;
    }
}
public class No383RansomNote {
    public static void main(String[] args){
        System.out.println(new Solution383().canConstruct("aa" , "ab"));
    }
}
