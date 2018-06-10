package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution119 {
	public static List<Integer> getRow(int numRows)
	{
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<=numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++) {
				row.set(j, row.get(j)+row.get(j+1));
			}
			allrows.add(new ArrayList<Integer>(row));
		}	
		return row;
	}
	//good idea
//	public static List<Integer> getRow(int numRows){
//		List A(rowIndex+1, 0);
//        A[0] = 1;
//        for(int i=1; i<rowIndex+1; i++)
//            for(int j=i; j>=1; j--)
//                A[j] += A[j-1];
//        return A;
//	}
}

public class PascalsTriangleII {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int rowIndex = Integer.parseInt(line);
            int rowIndex=0;
            List<Integer> ret = new Solution119().getRow(rowIndex);
            
            String out = integerArrayListToString(ret);
            
            System.out.print(out);
//        }
    }
}