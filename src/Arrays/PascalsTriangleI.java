package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * No.118
 * @author admin
 *
 */
public class PascalsTriangleI {
//	public static  List<List<Integer>> generate(int numRows) {
//		ArrayList list = new ArrayList();
//		ArrayList a2 = new ArrayList();
//		int m=0,n=0;
//        for(int i=1;i<=numRows;i++) {
//    		ArrayList a1 = new ArrayList();
//    		a1.add(1);
//        	for(int j=1;j<i-1;j++) {
//        		m=(int) a2.get(j-1);n=(int) a2.get(j);
//        		a1.add(m+n);
//        	}
//        	if(i==1) {list.add(a1);continue;}
//        	a1.add(1);
//        	list.add(a1);
//        	a2=a1;
//        }
//        return list;
//    }
	
	public static List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
		
	}
	
	public static void main(String[] args) {
		int num=7;
		List<List<Integer>> list=generate(num);
		for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));  //.get(index)
        }
	}
}
