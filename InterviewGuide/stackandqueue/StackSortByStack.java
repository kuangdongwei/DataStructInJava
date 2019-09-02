package stackandqueue;

import java.util.Stack;

public class StackSortByStack {

	public void stackSortstack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		while(!stack.isEmpty())
		{
			int cur = stack.pop();
			while(!help.isEmpty() && cur>help.peek())
			{
				stack.push(help.pop());
			}
			help.push(cur);
		}
		while(!help.isEmpty())
		{
			stack.push(help.pop());
		}
	}
}
