package Strings;

import java.util.*;

/**
 * 165. Compare Version Numbers
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * Example 1:
 *      Input: version1 = "0.1", version2 = "1.1"
 *      Output: -1
 * Example 2:
 *      Input: version1 = "1.0.1", version2 = "1"
 *      Output: 1
 * Example 3:
 *      Input: version1 = "7.5.2.4", version2 = "7.5.3"
 *      Output: -1
 */
class Solution165 {
    public int compareVersion(String version1, String version2) {
        if(version1.length() == 0 && version2.length() == 0){return 0;}
        if(version1.length() == 0){return -1;}
        if(version2.length() == 0){return 1;}
//        System.out.println(version1);
        String[] str1 = version1.split("\\.");
//        if(str1.length == 0){str1[0] = version1;}
        String[] str2 = version2.split("\\.");
//        if(str2.length == 0 ){str2[0] = version2;}
        int i = str1.length-1 ;
        for(i = str1.length-1 ; i >= 0 ; i--){
            if(Integer.valueOf(str1[i]) != 0){break;}
        }
        String[] string1 = new String[i+1];
        for(int p = 0 ; p < i+1 ; p++){
            string1[p] = str1[p];
        }
        i = str2.length-1 ;
        for(i = str2.length-1 ; i >= 0 ; i--){
            if(Integer.valueOf(str2[i]) != 0){break;}
        }
        String[] string2 = new String[i+1];
        for(int p = 0 ; p < i+1 ; p++){
            string2[p] = str2[p];
        }
        int n = Math.min(string1.length , string2.length);
//        System.out.println(n);
        for(i = 0 ; i < n ; i ++){
            if(Integer.valueOf(string1[i]) > Integer.valueOf(string2[i])){return 1;}
            else{
                if(Integer.valueOf(string1[i]) < Integer.valueOf(string2[i])) {return -1;}
            }
        }
        if( n < string1.length){return 1;}
        else{
            if(n < string2.length) {return -1;}
//            else{return 0;}
        }
        return 0;
    }
}
public class No165CompareVersionNumbers {
    public static void main(String[] args){
        String str1 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
        String str2 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
//        String str2 = "1.1";
        System.out.println(new Solution165().compareVersion(str1 , str2));
    }
}
