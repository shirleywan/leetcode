package zuochengyun;
import java.util.*;

/**
 * 设计一个有getMin功能的栈
 * @author Administrator
 *
 */
class Solution1{
	Stack<Integer> stack1 =new Stack<Integer>();
	Stack<Integer> stack2 =new Stack<Integer>();
	public void Stackpop(){
		if (!stack1.isEmpty() && !stack2.isEmpty() ){
			stack1.pop();
			stack2.pop();
		}
	}
	public void Stackpush(int num){
		stack1.push(num);
		if(stack2.isEmpty()){stack2.push(num);}
		else{
			if (num < stack2.peek()){stack2.push(num);}
			else{stack2.push(stack2.peek());}
		}
	}
	public int getMin(){
		return stack2.peek();
	}
}
public class No1 {
	public static void main(String[] args) {
		Solution1 stack = new Solution1();
		stack.Stackpush(3);
		stack.Stackpush(2);
		stack.Stackpush(4);
		stack.Stackpush(1);
		stack.Stackpush(5);
		System.out.println(stack.getMin());
		stack.Stackpop();
		stack.Stackpop();
		System.out.println(stack.getMin());
	}
}

