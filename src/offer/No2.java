package offer;

/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成 “%20”。例如，当字符串为 We Are Happy.
 * 则经过替换之后的字符串为 We%20Are%20Happy。
 */
class Solution2{
    public String replaceSpace(StringBuffer str) {
        if(str.length() == 0){return str.toString();}
        int count = 0;
        String string = str.toString();
        for(int i = 0 ; i < string.length(); i++){
            if(string.charAt(i) == ' ') count ++;
        }
        for(int i = 0; i < count ; i++){
            str.append("  ");
        }
        int n = str.length()-1;
        for(int i = string.length() -1 ; i>=0 ; i--){
            if(string.charAt(i) == ' '){
                str.setCharAt(n , '0');str.setCharAt(n-1 , '2');str.setCharAt(n-2 , '%');n = n-3;
            }
            else{
                str.setCharAt(n , string.charAt(i)); n--;
            }
        }
        return str.toString();
    }
}
public class No2 {
    public static void main(String[] args){
        StringBuffer string = new StringBuffer("We Are Happy");
        System.out.println(new Solution2().replaceSpace(string));
    }
}
