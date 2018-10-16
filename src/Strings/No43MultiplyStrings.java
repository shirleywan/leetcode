package Strings;

/**
 * 43. Multiply Strings
 * 详见python代码
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * Example 1:
 *      Input: num1 = "2", num2 = "3"
 *      Output: "6"
 * Example 2:
 *      Input: num1 = "123", num2 = "456"
 *      Output: "56088"
 * Note:
 *      The length of both num1 and num2 is < 110.
 *      Both num1 and num2 contain only digits 0-9.
 *      Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 *      You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
class Solution43 {
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0){return "";}
        if(num2 == null || num2.length() == 0){return "";}
        if((num1.length() == 1 && Integer.valueOf(num1) == 0)||(num2.length() == 1 && Integer.valueOf(num2) == 0)){ return "0"; }
        StringBuffer buffer = new StringBuffer();
        for(int i = 0 ; i < num1.length() ; i++){
            for(int j = 0 ; j < num2.length() ; j++){

            }
        }

        return null;
    }
}
public class No43MultiplyStrings {
    public static void main(String[] args){
        String string1 = "123";
        String string2 = "456";
        System.out.println(new Solution43().multiply(string1 , string2));
    }
}
