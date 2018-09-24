package offer;

/**
 * 矩形覆盖
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 */
class Solution10 {
    public int RectCover(int target) {
        if(target == 0) {return 0;}
        if(target == 1) {return 1;}
        if(target == 2) {return 2;}
        return RectCover(target-1)+RectCover(target-2);
    }
}

public class No10 {
    public static void main(String[] args){
        Solution10 solution = new Solution10();
        System.out.println(solution.RectCover(3));
    }
}
