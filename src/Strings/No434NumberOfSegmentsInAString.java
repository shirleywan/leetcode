package Strings;

/**
 * 434. Number of Segments in a String
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * Example:
 *      Input: "Hello, my name is John"
 *      Output: 5
 */
class Solution434 {
    /**
     *好蠢啊，居然分隔符只是' '或者'   '；
     */
    public int countSegments(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        boolean flag = false;
        for(char c: s.toCharArray()){
            if(c != ' '){
                if(!flag){count++;}
                flag = true;
            }
            else{
                flag = false;
            }
        }
        return count;
    }
    public int countSegments1(String s) {
        return s.split(" ").length;
    }
}
public class No434NumberOfSegmentsInAString {
    public static void main(String[] args){
        String string = "Hello,  a'b ";
        System.out.println(new Solution434().countSegments(string));
    }
}
