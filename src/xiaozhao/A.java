package xiaozhao;

import java.awt.print.PrinterJob;

public class A {
    public static int num1 ;
    public static int num2 = 0;
    private static A obj = new A();
    private A(){
        num1 ++;
        num2 ++;
    }
    public static A getInstance(){
        return obj;
    }
    public static void main(String[] args){
        A obj = A.getInstance();
        System.out.println(obj.num1++);
        System.out.println(++obj.num2);
    }
}
