package stack;


import linkTable.LinkListNode;

public class LinkStack {

	private LinkListNode headNode;
	public LinkStack()
	{
		this.headNode = new LinkListNode(0);
	}
	public void Push(int data)
	{
		if(headNode==null)
		{
			headNode = new LinkListNode(data);
		}else if(headNode.getData()==0)
		{
			headNode.setData(data);
		}else
		{
			LinkListNode llNode = new LinkListNode(data);
			llNode.setNext(headNode);
			headNode=llNode;
		}
	}
	public int pop()
	{
		if(headNode==null)
		{
			System.out.println("stack is empty");
			return 0;
		}else
		{
			int data = headNode.getData();
			headNode = headNode.getNext();
			return data;
		}
	}
	
	public int  top()
	{
		if(headNode == null)
			return 0;
		else return headNode.getData();
	}
	
	public boolean isEmpty()
	{
		if(headNode == null)
			return true;
		else return false;
	}
	
	public void deleteStack()
	{
		headNode.setNext(null);
	}
}
