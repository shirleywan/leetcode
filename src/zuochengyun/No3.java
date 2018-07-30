package zuochengyun;
import java.util.*;
/**
 * 仅用递归函数和一个栈操作，逆序一个栈
 */
class Solution3{
    /**
     * 用来返回栈底的元素并移除
     * @param stack
     * @return
     */
    public int reverse(Stack<Integer> stack){
        int num = stack.pop();
        if(stack.isEmpty()) {
            return num;
        }
        else{
            int last = reverse(stack);
            stack.push(num);
            return last;
        }
    }

    /**
     * 实现逆序
     * @param stack
     */
    public void getback(Stack<Integer> stack){
        if (stack.isEmpty()){
            return ;
        }
        int num = reverse(stack);//用这句来保存当前的栈底元素
        getback(stack);//逆序剩下的栈内元素
        stack.push(num);//把当前值压入栈中

    }
}
public class No3 {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        new Solution3().getback(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
