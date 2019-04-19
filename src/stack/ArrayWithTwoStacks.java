package stack;

//如何使用一个数组实现两个栈
public class ArrayWithTwoStacks {

	private int[] dataArray;
	private int size;
	private int topOne;
	private int topTwo;
	
	public ArrayWithTwoStacks(int size)
	{
		this.size = size;
		dataArray = new int[size];
		topOne = -1;
		topTwo = size;
	}
	public void push(int stackID,int data)
	{
		if(size<2)
			System.out.println("size is too small to test!");
		if(stackID==1)
		{
			dataArray[++topOne] = data;
		}else if(stackID==2)
		{
			dataArray[--topTwo] = data;
		}else
			return;
	}
	public int pop(int stackID)
	{
		if(stackID==1)
		{
			if(topOne==-1)
				System.out.println("the stack 1 is empty!");
			int toPop = dataArray[topOne];
			dataArray[topOne--] =  0;
			return toPop;
		}
		else if(stackID==2)
		{
			if(topTwo == this.size)
				System.out.println("the stack 2 is empty");
			int toPop = dataArray[topTwo];
			dataArray[topTwo++] = 0;
			return toPop;
		}
		else return 0;
	}
	public int top(int stackID)
	{
		if(stackID==1)
		{
			if(topOne==-1)
				System.out.println("the stack 1 is empty!");
			return dataArray[topOne];
		}
		else if(stackID==2)
		{
			if(topTwo == this.size)
				System.out.println("the stack 2 is empty");
			return dataArray[topTwo];
		}
		else return 0;
	}
	public boolean isEmpty(int stackID)
	{
		if(stackID==1)
		{
			return topOne == -1;
		}else if(stackID==2)
		{
			return topTwo == this.size;
		}else return true;
	}
	
	//test run
	public static void main(String args[])
	{
		int size = 6;
		ArrayWithTwoStacks object = new ArrayWithTwoStacks(size);
		object.push(1, 1);
		object.push(1, 2);
		object.push(1, 4);
		//object.push(2, 3);
		//object.push(2, 5);
		System.out.println("is the stack 1 empty? -- "+object.isEmpty(1));
		System.out.println("is the stack 2 empty? -- "+object.isEmpty(2));
		System.out.println("get top of stack1 = "+object.top(1));
		System.out.println("*****after a element pop*****");
		object.pop(1);
		System.out.println("get top of stack1 = "+object.top(1));
	}
}
