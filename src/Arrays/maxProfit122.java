package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution122 {
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i = 0;i<prices.length-1;i++) {
        	if(prices[i]<prices[i+1]) {
        		max=max+prices[i+1]-prices[i];
        	}
        }
        return max;
    }
    
    //好算法，和我的思想一样，格式会好一点
//    public int maxProfit(int[] prices) {
//        int total = 0;
//        for (int i=0; i< prices.length-1; i++) {
//            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
//        }
//        
//        return total;
}

public class maxProfit122 {
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
            int[] prices= {7,1,6,2,5};
            int ret = new Solution122().maxProfit(prices);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}