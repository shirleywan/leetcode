package zuochengyun;
import java.util.*;
/**
 * 用两个栈组成的队列
 * @author Administrator
 *
 */
class Solution2{
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	public void add(int num){
		stack1.push(num);
	}
	public int poll(){
		if(!stack1.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			int num = stack2.pop();
			while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
			return num;
		}
		else{
			throw new RuntimeException("queue is empty!");
		}
	}
	public int peek(){
		if(!stack1.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			int num = stack2.peek();
			while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
			return num;
		}
		else{
			throw new RuntimeException("queue is empty!");
		}
	}
}
public class No2 {
	public static void main(String[] args) {
		Solution2 queue = new Solution2();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
	}
}
