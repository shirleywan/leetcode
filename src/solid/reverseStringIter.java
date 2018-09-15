package solid;

/**
 * 用递归实现字符串的反转
 */
public class reverseStringIter {
    public static String reverse(String originalstr){
        if(originalstr .length() == 0 || originalstr.length() ==1) {return originalstr;}
        return reverse(originalstr.substring(1)) + originalstr.charAt(0);
        //string.substring(int beginIndex) -- 从1开始的子串
    }
    public static void main(String[] args){
        String string = "abcdef";
        System.out.println(reverse(string));
    }
}
