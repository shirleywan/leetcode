package offer;

/**
 * 跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
class Solution8 {
    public int JumpFloor(int target) {
        if(target == 0) {return 0;}
        if(target == 1) {return 1;}
        if(target == 2) {return 2;}
        return JumpFloor(target-1) + JumpFloor(target-2);
    }
}
public class No8 {
    public static void main(String[] args){
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.JumpFloor(3));
    }
}
