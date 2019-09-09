package stack;

public class DyArrStack {

	private int capacity;
	private int[] array;
	private int top;
	
	public DyArrStack(int capacity) 
	{
	   	this.capacity=capacity;
	   	top=-1;
	   	array = new int[capacity];
	}
	
	public boolean isEmpty()
	{
		return(top==-1);
	}
	public boolean isFull()
	{
		return(top==capacity-1);
	}
	public int pop()  //³öÕ»
	{
		if(isEmpty())
		{
			System.out.println("stack is empty,underflow!");
			return 0;
		}
		else
		{
		   return array[top--];
		}
	}
	public void push(int data)  //ÈëÕ»
	{
		if(isFull())
			doubleStack();
		array[++top] = data;
	}
	public void doubleStack()
	{
		int newArray[]=new int[capacity*2];
		System.arraycopy(array, 0, newArray, 0, capacity);
		capacity*=2;
		array = newArray;
	}
	public void deleteStack()
	{
		top = -1;
	}
	public void printStack()
	{
		for(int i=capacity-1;i>-1;i--)
		{
			System.out.println(array[i]);
		}
	}
	
	public static void main(String args[])
	{
		DyArrStack stack = new DyArrStack(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.printStack();
		System.out.println("stack is empty? -- "+stack.isEmpty());
		System.out.println("stack is full? -- "+stack.isFull());
		System.out.println("get elment:"+stack.pop());
		stack.printStack();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		System.out.println("the new capacity of stack is: "+stack.capacity);
		stack.printStack();
		stack.pop();
		System.out.println("after a element poped");
		stack.printStack();
	}
}
