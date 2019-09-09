package stack;

public class AdvancedStack {

	private LinkStack elementStack = new LinkStack();
	private LinkStack minStack = new LinkStack();
	public void push(int data)
	{
		elementStack.Push(data);
		if(minStack.isEmpty() || minStack.top()>data)
		{
			minStack.Push(data);
		}else {
			
		}
	}
	
	public int getMin()
	{
		return minStack.top();
	}
	
	public int top()
	{
		return minStack.top();
	}
	
	public static void main(String args[])
	{
		AdvancedStack stack = new AdvancedStack();
		stack.push(4);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		System.out.println("the minmum element is:"+stack.getMin());
	}
}
