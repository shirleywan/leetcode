package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution13 {
//    public int romanToInt(String s) {
//        int count=0;
//        Map map=new HashMap();
//        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
//        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
//	    for(int i=0;i<strs.length;i++) {
//	    	map.put(strs[i],values[i]);
//	    }
//	    for(int i=0;i<s.length();i++) {
//	    	if(i<s.length()-1) {
//	    	if(map.containsKey(String.valueOf(s.substring(i, i+2)))) {
//	    		System.out.println(String.valueOf(s.substring(i, i+2)));
//	    		count=count+(int) map.get(String.valueOf(s.substring(i, i+2)));i++;continue;}
//	    	}
//	    	if(map.containsKey(String.valueOf(s.charAt(i)))) {
//	    		System.out.println(String.valueOf(s.charAt(i)));
//	    		count=count+(int) map.get(String.valueOf(s.charAt(i)));continue;}
//	    }
//        return count;
//    }
	public int romanToInt(String s) {
	     int sum=0;
	    if(s.indexOf("IV")!=-1){sum-=2;}
	    if(s.indexOf("IX")!=-1){sum-=2;}
	    if(s.indexOf("XL")!=-1){sum-=20;}
	    if(s.indexOf("XC")!=-1){sum-=20;}
	    if(s.indexOf("CD")!=-1){sum-=200;}
	    if(s.indexOf("CM")!=-1){sum-=200;}
	    
	    char c[]=s.toCharArray();
	    int count=0;
	    
	   for(;count<=s.length()-1;count++){
	       if(c[count]=='M') sum+=1000;
	       if(c[count]=='D') sum+=500;
	       if(c[count]=='C') sum+=100;
	       if(c[count]=='L') sum+=50;
	       if(c[count]=='X') sum+=10;
	       if(c[count]=='V') sum+=5;
	       if(c[count]=='I') sum+=1;
	       
	   }
	   
	   return sum;
	    
	}
}

public class romanToInt13 {
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
//            String s = stringToString(line);
            String s= "CMXCIX";
            int ret = new Solution13().romanToInt(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
