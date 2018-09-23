package offer;
/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，
 * 输出旋转数组的最小元素。 例如数组 {3,4,5,1,2} 为{1,2,3,4,5}的一个旋转，该数组的最小值为 1。
 * NOTE：给出的所有元素都大于 0，若数组大小为 0，请返回 0。
 */

import java.util.ArrayList;
class Solution6 {
    public int minNumberInRotateArray(int [] array) {
        if(array== null || array.length == 0){return 0;}
        int start = 0 ;
        int end = array.length-1;
        int mid = array.length/2;
        while(start < end-1){
            if(array[mid] >= array[start]){start = mid;}
            else{
                end = mid;
            }
            mid = (start + end)/2;
        }
        return Math.min(array[start] , array[end]);
    }
}
public class No6 {
    public static void main(String[] args){
        int[] array= {3,4,5,1,2};
        Solution6 solution = new Solution6();
        System.out.println(solution.minNumberInRotateArray(array));
    }
}
