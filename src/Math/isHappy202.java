package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution202 {
	/**
	 * 这道题的重点是判断递归边界，我这里可以实现递归，却没有确定好边界
	 */
//    public boolean isHappy(int n) {
//    	int sum=0;
//    	while(n!=0){
//    		sum=sum+(n%10)*(n%10);
//    		n = n/10;
//    	}
//    	if(sum != 1){isHappy(sum);}
//    	return true;
//    }
	
	/**
	 * Good_idea 1:
	 */
	public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            System.out.println(x);
            if(x==1) return true ;
            y = cal(cal(y));
            System.out.println(y);
            if(y==1) return true ;

            if(x==y) return false;//这里的想法是：如果是死循环且结果不为1
            			//那么1次循环和2次循环一定会在某一值处相遇
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
	
	//Method-1:use HashMap! 注意循环内的调用！在goodidea1的基础上改出来的
//	public boolean isHappy(int n) {
//		Map map=new HashMap();
//		int sum=n;
//		while(sum != 1){
//			sum=cal(sum);
//			if(map.containsKey(sum)){return false;}
//			else {map.put(sum, 1);}
//
//		}
//    	return true;
//	}
//    public int cal(int n){
//        int x = n;
//        int s = 0;
//        while(x>0){
//            s = s+(x%10)*(x%10);
//            x = x/10;
//        }
//        return s ;
//    }
}

public class isHappy202 {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int n = Integer.parseInt(line);
            int n=1;
            boolean ret = new Solution202().isHappy(n);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
//        }
    }
}