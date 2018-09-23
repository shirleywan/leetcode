package offer;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级…… 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
class Solution9 {
    public int JumpFloorII(int target) {
        if(target == 0) {return 1;}
        if(target == 1) {return 1;}
        if(target == 2) {return 2;}
        int num = 1;
        int i = 1;
        while(i < target){
            num = num + JumpFloorII(i);
            i++;
        }
        return num;
    }
}
public class No9 {
    public static void main(String[] args){
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.JumpFloorII(3));
    }
}
