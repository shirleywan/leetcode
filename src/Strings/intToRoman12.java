package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution12 {
//    public String intToRoman(int num) {
//        String str="";
//        switch( num/1000 ) {
//        case 1:str=str+"M";break;
//        case 2:str=str+"MM";break;
//        case 3:str=str+"MMM";break;
//        }
//        num=num%1000;
//        switch( num/100) {
//        case 1:str=str+"C";break;
//        case 2:str=str+"CC";break;
//        case 3:str=str+"CCC";break;
//        case 4:str=str+"CD";break;
//        case 5:str=str+"D";break;
//        case 6:str=str+"DC";break;
//        case 7:str=str+"DCC";break;
//        case 8:str=str+"DCCC";break;
//        case 9:str=str+"CM";break;
//        }
//        num=num%100;
//        switch( num/10 ) {
//        case 1:str=str+"X";break;
//        case 2:str=str+"XX";break;
//        case 3:str=str+"XXX";break;
//        case 4:str=str+"XL";break;
//        case 5:str=str+"L";break;
//        case 6:str=str+"LX";break;
//        case 7:str=str+"LXX";break;
//        case 8:str=str+"LXXX";break;
//        case 9:str=str+"XC";break;
//        }
//        switch( num%10 ) {
//        case 1:str=str+"I";break;
//        case 2:str=str+"II";break;
//        case 3:str=str+"III";break;
//        case 4:str=str+"IV";break;
//        case 5:str=str+"V";break;
//        case 6:str=str+"VI";break;
//        case 7:str=str+"VII";break;
//        case 8:str=str+"VIII";break;
//        case 9:str=str+"IX";break;
//        }
//        return str;
//    }
	//Good-idea-1:想法一样，但是写的远远没有这种方式好
//	public static String intToRoman(int num) {
//	    String M[] = {"", "M", "MM", "MMM"};
//	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//	    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
//	}
	public String intToRoman(int num) {
	    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    StringBuilder sb = new StringBuilder();
	    for(int i=0;i<values.length;i++) {
	        while(num >= values[i]) {
	            num -= values[i];
	            sb.append(strs[i]);
	        }
	    }
	    return sb.toString();
	}
}

public class intToRoman12 {
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int num = Integer.parseInt(line);
            int num=999;
            String ret = new Solution12().intToRoman(num);
            
            String out = (ret);
            
            System.out.print(out);
//        }
    }
}