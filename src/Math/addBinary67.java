package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution67 {
	/**
	 * 1、把两个字符串从右向左遍历，进行加和，直到至少有一个字符串遍历完成为止。注意有进位。 
       2、此时应检查是否还有另一个字符串没有被遍历完。若发现存在则继续遍历。 	
	   3、遍历完两个字符串后，还需检查进位是否为 0，若进位不为 0，还要加上进位。 
	   4、保存加和完的结果。一开始想用 append 方法，
		    但是想到还要对字符串进行逆置，稍显麻烦。后发现了另一个方法 insert，
		    可以将每次加和的结果直接插入到第一个字符的位置，这样从一开始结果字符串就是逆序存放的。
	 * @return
	 */
//	public String addBinary(String a, String b) {  
//        int m = a.length();  
//        int n = b.length();  
//        String res = "";  
//        int carry = 0;  
//        int i = 0;  
//        while(i<m || i<n || carry!=0){  
//             int x = (i<m) ? a.charAt(m - 1 - i) - '0' : 0;//把字符转换成数字，从最末尾开始读  
//             System.out.println(x);
//             int y = (i<n) ? b.charAt(n - 1 - i) - '0' : 0;  
//             System.out.println(y);
//             res = (x + y + carry)%2 + res;  //是否进位
//             carry = (x + y + carry)/2;  
//             i++;  
//        }  
//        return res;  
//    }  
	/**
	 * 采用了 StringBuilder 这样的数据结构
	 * sum % 2用这种形式确定是否进位
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary(String a, String b) { 
        if(a == null || b == null || a.length() == 0 || b.length() == 0)
            return null;
        int aLen = a.length();
        int bLen = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = 0;
        for(; i < aLen && i < bLen; i ++) {
            int sum = (a.charAt(aLen - 1 - i) - '0') + (b.charAt(bLen - 1 - i) - '0') + carry;
            sb.insert(0, sum % 2); 
            carry = sum / 2;
        }
        while(i < aLen) {
            int sum = (a.charAt(aLen - 1 - i) - '0') + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            i ++;
        }
        while(i < bLen) {
            int sum = (b.charAt(bLen - 1 - i) - '0') + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            i ++;
        }
        if(carry != 0)
            sb.insert(0, carry);
        return sb.toString();
    }
	
}

public class addBinary67 {
    public static String stringToString(String input) {
        assert input.length() >= 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '\\') {
                char nextChar = input.charAt(i+1);
                switch (nextChar) {
                    case '\"': sb.append('\"'); break;
                    case '/' : sb.append('/'); break;
                    case '\\': sb.append('\\'); break;
                    case 'b' : sb.append('\b'); break;
                    case 'f' : sb.append('\f'); break;
                    case 'r' : sb.append('\r'); break;
                    case 'n' : sb.append('\n'); break;
                    case 't' : sb.append('\t'); break;
                    default: break;
                }
                i++;
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            String a = stringToString(line);
//            line = in.readLine();
//            String b = stringToString(line);
            String a="111111";
            String b="1";
            String ret = new Solution67().addBinary(a, b);
            
            String out = (ret);
            
            System.out.print(out);
//        }
    }
}
