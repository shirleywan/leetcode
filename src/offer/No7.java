package offer;

/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数 n，请你输出斐波那契数列的第 n 项（从 0 开始，第 0 项为 0）。
 * n<=39
 */
class Solution7 {
    public int Fibonacci(int n) {
        if(n == 0) {return 0;}
        if(n == 1 || n ==2){return 1;}
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
public class No7 {
    public static void main(String[] args){
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.Fibonacci(0));
    }
}
