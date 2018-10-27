package Stack;

import java.util.*;

/**
 * 232. Implement Queue using Stacks
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stack1.isEmpty()){
            return stack1.pop();
        }
        else{
            return 0;
        }
    }

    /** Get the front element. */
    public int peek() {
        if(!stack1.isEmpty()){
            return stack1.peek();
        }
        else{
            return 0;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()){return true;}
        return false;
    }
}
public class No232ImplementQueueUsingStacks {
    public static void main(String[] args){
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }
}
