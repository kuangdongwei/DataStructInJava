package stack;

import java.util.Stack;

public class StackReversal {

	private Stack stack;
	public static void reverseStack(Stack stack)
	{
		if(stack.isEmpty()) return;
		int temp = (int) stack.pop();
		reverseStack(stack);
		insertAtBottom(stack,temp);
	}
	
	private static void insertAtBottom(Stack stack,int data)
	{
		if(stack.isEmpty())
		{
			stack.push(data);
			return;
		}
		int temp = (Integer) stack.pop();
		insertAtBottom(stack,data);
		stack.push(temp);
	}
	
	public void printStack()
	{
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop());
		}
	}
	public static void main(String args[])
	{
		
	}
}
