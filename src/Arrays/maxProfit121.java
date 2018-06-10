package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//No.121. Best Time to Buy and Sell Stock
class Solution121 {
    public int maxProfit(int[] prices) {
    	if(prices.length==0) {
    		return 0;}
        int num=prices[0];
        int max=0;
        for(int n:prices) {
        	if(n>num) {
        		if(n-num>max) max=n-num;
        	}else {
        		num=n;}
        }
        return max;
    }
}

public class maxProfit121 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] prices = stringToIntegerArray(line);
            int[] prices= {};
            int ret = new Solution121().maxProfit(prices);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
