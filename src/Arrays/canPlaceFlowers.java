package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
    	Map map=new HashMap<>();
    	int count=0;
    	for(int i=0;i<flowerbed.length;i++) {
    		if(flowerbed[i]==1) {map.put(i, 1);}
    	}
    	
        return false;
    }
}

public class canPlaceFlowers {
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
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] flowerbed = stringToIntegerArray(line);
//            line = in.readLine();
//            int n = Integer.parseInt(line);
            int[] flowerbed= {1,0,0,0,1};
            int n=1;
            boolean ret = new Solution605().canPlaceFlowers(flowerbed, n);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
//        }
    }
}