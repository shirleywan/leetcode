package zuochengyun;
import java.util.*;

/**
 * 用一个栈实现另一个栈的排序
 * 从栈顶到栈底是从大到小的顺序
 */
class Solution5{
    public void sort(Stack<Integer> stack){
        if(stack.isEmpty()){return ;}
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(stack.pop());
        int num = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() <= stack1.peek()){
                stack1.push(stack.pop());
            }
            else{
                int node = stack.pop();
                while (node > stack1.peek()){
                    stack.push(stack1.pop());
                    num ++;
                }
                stack1.push(node);
                while(num>0){
                    stack1.push(stack.pop());
                    num--;
                }
            }
        }

        while (!stack1.isEmpty()){
            stack.push(stack1.pop());
        }
    }
}
public class No5 {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(6);
        new Solution5().sort(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
