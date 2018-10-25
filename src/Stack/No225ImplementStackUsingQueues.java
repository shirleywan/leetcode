package Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * Implement the following operations of a stack using queues.
 *      push(x) -- Push element x onto stack.
 *      pop() -- Removes the element on top of the stack.
 *      top() -- Get the top element.
 *      empty() -- Return whether the stack is empty.
 * Example:
 *      MyStack stack = new MyStack();
 *      stack.push(1);
 *      stack.push(2);
 *      stack.top();   // returns 2
 *      stack.pop();   // returns 2
 *      stack.empty(); // returns false
 */
class MyStack {
    Queue<Integer> queue1 ;
    Queue<Integer> queue2 ;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int x = queue1.peek();
        while(!queue1.isEmpty()){
            x = queue1.poll();
            if(!queue1.isEmpty()){
                queue2.offer(x);
            }
        }
        while(!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        return x;
    }

    /** Get the top element. */
    public int top() {
        int x = queue1.peek();
        while(!queue1.isEmpty()){
            x = queue1.poll();
            queue2.offer(x);
        }
        while(!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        return x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()){
            return true;
        }
        else return false;
    }
}

public class No225ImplementStackUsingQueues {
    public static void main(String[] args){
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
