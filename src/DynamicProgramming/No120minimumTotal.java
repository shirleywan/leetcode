package DynamicProgramming;

import java.util.*;

/**
 * 120. Triangle
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
class Solution120 {
    /**
     * Runtime: 6 ms, faster than 23.93% of Java online submissions for Triangle.
     * Memory Usage: 37.9 MB, less than 77.97% of Java online submissions for Triangle.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        List<List<Integer>> nums = new ArrayList<List<Integer>>(triangle.size());
        List<Integer> list = new ArrayList<>();
        list.add(triangle.get(0).get(0));
        nums.add(list);
        for(int i = 1 ; i < triangle.size() ; i++){
            list = new ArrayList<Integer>();
            int sum = 0;
            for(int j = 0 ; j < triangle.get(i).size() ; j++){
                if(j == 0 ){
                    sum = nums.get(i-1).get(0) + triangle.get(i).get(0);
                    list.add(sum);
                }
                else{
                    if(j == triangle.get(i).size()-1){
                        sum = nums.get(i-1).get(nums.get(i-1).size()-1) + triangle.get(i).get(triangle.get(i).size()-1);
//                        sum = nums.get(i-1).get(i-1) + triangle.get(i).get(i);
                        list.add(sum);
                    }
                    else{
                        sum = Math.min(nums.get(i-1).get(j-1), nums.get(i-1).get(j))+ triangle.get(i).get(j);
                        list.add(sum);
                    }
                }
            }
            nums.add(list);
        }
        list = new ArrayList<Integer>();
        list = nums.get(nums.size()-1);
        int min = list.get(0);
        for(int i = 0 ; i < list.size() ; i++){
            if(min > list.get(i)) min = list.get(i);
        }
        return min;
    }

    /**
     * Runtime: 6 ms, faster than 23.93% of Java online submissions for Triangle.
     * Memory Usage: 37.7 MB, less than 82.17% of Java online submissions for Triangle.
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        List<List<Integer>> nums = new ArrayList<List<Integer>>(triangle.size());
        List<Integer> list = new ArrayList<>();
        list.add(triangle.get(0).get(0));
        nums.add(list);
        for(int i = 1 ; i < triangle.size() ; i++){
            list = new ArrayList<Integer>();
            int sum = 0;
            for(int j = 0 ; j < triangle.get(i).size() ; j++){
                if(j == 0 ){
                    sum = nums.get(i-1).get(0) + triangle.get(i).get(0);
                    list.add(sum);
                }
                else{
                    if(j == triangle.get(i).size()-1){
                        sum = nums.get(i-1).get(i-1) + triangle.get(i).get(i);
                        list.add(sum);
                    }
                    else{
                        sum = Math.min(nums.get(i-1).get(j-1), nums.get(i-1).get(j))+ triangle.get(i).get(j);
                        list.add(sum);
                    }
                }
            }
            nums.add(list);
        }
        list = new ArrayList<Integer>();
        list = nums.get(nums.size()-1);
        int min = list.get(0);
        for(int i = 0 ; i < list.size() ; i++){
            if(min > list.get(i)) min = list.get(i);
        }
        return min;
    }
    /**
     * good method : two array
     * only two array to record current and the last sum result
     * the finally result is the Arrays.sort(nums) -- much convinent
     * Runtime: 2 ms, faster than 95.51% of Java online submissions for Triangle.
     * Memory Usage: 37.4 MB, less than 87.06% of Java online submissions for Triangle.
     */
    public int minimumTotal2(List<List<Integer>>triangle) {
        int n=triangle.size();
        if(n<=0)
            return 0;

        int[]pre=new int[1];
        pre[0]=triangle.get(0).get(0);

        int[]cur=pre;

        for(int i=1;i<n;i++) {
            List<Integer> tmpList=triangle.get(i);

            int size=tmpList.size();

            cur=new int[size];
            cur[0]=tmpList.get(0)+pre[0];
            cur[size-1]=tmpList.get(size-1)+pre[pre.length-1];

            for(int j=1;j<size-1;j++) {
                cur[j]=Math.min(pre[j-1], pre[j])+tmpList.get(j);
            }
            pre=cur;

        }
        Arrays.sort(cur);

        return cur[0];

    }
}
public class No120minimumTotal {
    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<>(); list1.add(2);
        List<Integer> list2 = new ArrayList<Integer>();list2.add(3);list2.add(4);
        List<Integer> list3 = new ArrayList<Integer>();list3.add(6);list3.add(5);list3.add(7);
        List<Integer> list4 = new ArrayList<Integer>();list4.add(4);list4.add(1);list4.add(8);list4.add(3);
        triangle.add(list1);triangle.add(list2);triangle.add(list3);triangle.add(list4);
        System.out.println(new Solution120().minimumTotal(triangle));
    }
}
