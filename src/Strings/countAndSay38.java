package Strings;

import java.io.IOException;

class Solution38 {
    public String countAndSay(int n) {
        String c = "1";
        if(n==1) {return c;}
        int i=0;
        while(i<n-1) {
        	c=say(c);
        	i++;
        }
        return c;
    }
    public String say(String c) {
    	String m="";
    	if(c.length()==1) {return "11";}
    	int count=1,i=0;
    	while(i<c.length()-1) {
    		while (i+1<c.length() && c.charAt(i)==c.charAt(i+1)) {
				count++;
				i++;
			}
    		m=(m+count+c.charAt(i));
    		i++;
    		count=1;
    	}
    	if(c.charAt(c.length()-2)!=c.charAt(c.length()-1)) {m=(m+count+c.charAt(c.length()-1));}
    	return m;
    }
}

public class countAndSay38 {
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int n = Integer.parseInt(line);
            int n=4;
            String ret = new Solution38().countAndSay(n);
            
            String out = (ret);
            
            System.out.print(out);
//        }
    }
}
