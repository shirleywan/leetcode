package offer;

/**
 * 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的元素为 int 类型。
 */

import java.util.*;

class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if(stack1.isEmpty()){stack1.push(node);}
        else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack1.push(node);
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
    }

    public int pop() {
        if(!stack1.isEmpty()) {
            return stack1.pop();
        }
        else{
            return 0;
        }
    }
}
public class No5 {
    public static void main(String[] args){
        System.out.println();
    }
}
