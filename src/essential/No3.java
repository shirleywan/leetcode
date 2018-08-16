package leetcode;
/**
 * max-points-on-a-line
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * notice:边界条件：
 * 1）(1,1),(1,1),(1,1) -- 3
 * 2)当只有两个坐标相同时，其他点与这两点构成的直线不算，nums=2
 */
import java.util.*;
import leetcode.util.*;
class Solution3 {
    public int maxPoints(Point[] points) {
    	if(points.length == 0 || points.length == 1 || points.length == 2){return points.length;}
    	int[][] nums = new int[points.length][points.length];
    	int count = 0;
    	int k1 = 0;
    	int k2 = 0;
    	for(int i = 0 ;i <points.length;i++){
    		for(int j = i+1 ; j<points.length ; j++){
    			count = 0;
    			for(int p = 0 ;p<points.length ; p++ ){
    				if(p != i && p !=j ){
    					if(points[i].x == points[j].x && points[i].y == points[j].y){
    							if(points[i].x == points[p].x && points[i].y == points[p].y){count ++;continue;}
    							else{count = 0 ;continue;}
    					}
    					else{
	    					k1 = (points[i].y - points[j].y)*(points[i].x - points[p].x);
	    					k2 = (points[i].y - points[p].y)*(points[i].x - points[j].x);
	    					if(k1 == k2){count++;}
    					}
    				}
    				else{continue;}
    			}
    			nums[i][j] = count+2;
    		}
    	}
    	int max = nums[0][0];
    	for(int i = 0; i<points.length-1 ; i++){
    		for(int j = i+1 ; j<points.length ; j++){
    			if(nums[i][j] > max){ max = nums[i][j] ; }
    		}
    	}
        return max;
    }
}

public class No3 {
	public static void main(String[] args) {
		Point p1 = new Point(1,0);
		Point p2 = new Point(1,0);
		Point p3 = new Point(1,0);
//		Point p4 = new Point(0,-70);
//		Point p5 = new Point(0,-70);
//		Point p6 = new Point(1,-1);
//		Point p7 = new Point(21,10);
//		Point p8 = new Point(42,90);
//		Point p9 = new Point(-42 , -230);
		Point[] points = {p1,p2,p3/*,p4,p5,p6,p7,p8,p9*/};
		System.out.println(new Solution3().maxPoints(points));
		
		
	}
}
