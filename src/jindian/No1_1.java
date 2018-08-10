package jindian;

import java.util.*;
/**
 * 	确定字符互异,额外空间复杂度为O(1)
 *
 */

class Different {
    public boolean checkDifferent(String iniString) {
        if (iniString.length() == 0) {return false;}
        if (iniString.length() == 1) {return true;}
        for (int i = 0; i<iniString.length()-1 ;i++){
        	for(int j = i+1 ; j<iniString.length() ; j++){
        		if(iniString.charAt(i) == iniString.charAt(j)) { return false;}
        	}
        }
        return true;
    }
}

public class No1_1 {
	
	public static void main(String[] args) {
		
	}
}
