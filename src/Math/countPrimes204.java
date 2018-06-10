package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution204 {
//    public int countPrimes(int n) {
//    	int count=0;
//    	if( n == 0 || n == 1) {return 0;}
//    	for(int i=2;i<n;i++) {
//    		if( !isSu(i) ) {count++;}
//    	}
//        return count;
//    }
//    public boolean isSu(int num) {
//    	if(num==0 || num==1) {return false;}
//    	for(int i=2;i<num/2;i++) {
//    		if(num % i == 0) {return true;}
//    	}
//    	return false;
//    }
	//Good-idea-1:
//	public int countPrimes(int n) {
//		   boolean[] isPrime = new boolean[n];
//		   for (int i = 2; i < n; i++) {
//		      isPrime[i] = true;
//		   }
//		   // Loop's ending condition is i * i < n instead of i < sqrt(n)
//		   // to avoid repeatedly calling an expensive function sqrt().
//		   for (int i = 2; i * i < n; i++) {
//		      if (!isPrime[i]) continue;
//		      for (int j = i * i; j < n; j += i) {
//		         isPrime[j] = false;
//		      }
//		   }
//		   int count = 0;
//		   for (int i = 2; i < n; i++) {
//		      if (isPrime[i]) count++;
//		   }
//		   return count;
//		}
	public int countPrimes(int n) {
	    if (n < 3)
	        return 0;
	        
	    boolean[] f = new boolean[n];
	    //Arrays.fill(f, true); boolean[] are initialed as false by default
	    int count = n / 2;
	    for (int i = 3; i * i < n; i += 2) {
	        if (f[i])
	            continue;
	        
	        for (int j = i * i; j < n; j += 2 * i) {
	            if (!f[j]) {
	                --count;
	                f[j] = true;
	            }
	        }
	    }
	    return count;
	}
//	//Good-idea2:exordinary
//    public int countPrimes(int n) {
//        boolean[] notPrime = new boolean[n];
//        int count = 0;
//        for (int i = 2; i < n; i++) {
//            if (notPrime[i] == false) {
//                count++;
//                for (int j = 2; i*j < n; j++) {
//                    notPrime[i*j] = true;
//                }
//            }
//        }
//        
//        return count;
//    }

}

public class countPrimes204 {
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int n = Integer.parseInt(line);
            int n=499979;
            int ret = new Solution204().countPrimes(n);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
//        }
    }
}
