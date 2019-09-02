package test;

import java.util.Stack;

import stackandqueue.StackSortByStack;

public class TestStackSortByStack {

	public static void main(String args[])
	{
		StackSortByStack obj = new StackSortByStack();
		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.push(1);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		System.out.println("original stack:"+stack.toString());
		obj.stackSortstack(stack);
		System.out.println("sorted stack:"+stack.toString());
	}
}
