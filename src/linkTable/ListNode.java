package linkTable;

public class ListNode {

	private int data;
	private ListNode next;
	public ListNode(int data)
	{
		this.setData(data);
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	
	
	//打印链表
	public void printListNode(ListNode headNode)
	{
		while(headNode.getNext()!=null)
		{
			System.out.print(headNode.getData()+"->");
			headNode = headNode.getNext();
		}
		System.out.println(headNode.getData());
	}
	//获取链表长度
	int ListLength(ListNode headNode)
	{
		int length = 0;
		ListNode currentNode = headNode;
		while(currentNode!=null)
		{
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	//插入链表
	public ListNode InsertInLinkList(ListNode headNode,ListNode nodeToInsert,int position)
	{
		if(headNode==null)
		{
			return nodeToInsert;
		}
		int size = ListLength(headNode);
		if(position>size+1 || position<1)
		{
			System.out.println("position to insert is invalid");
			return headNode;
		}
		if(position ==1) //在链表开始出插入
		{
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		}
		else  //在链表中间或者结尾插入
		{
			ListNode previousNode = headNode;
			int count=1;
			while(count<position-1) //遍历链表找到要插入位置的前驱节点
			{
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
		}
		return headNode;
	}
	//删除链表
	ListNode DeleteNode(ListNode headNode,int position)
	{
		int size = ListLength(headNode);
		if(position >size || position<1)
		{
			System.out.println("position to delete is invalid:");
			return headNode;
		}
		if(position == 1) //删除表头节点
		{
			ListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		}
		else //删除中间节点或为节点
		{
			ListNode previousNode = headNode;
			int count=1;
			while(count<position)
			{
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
		}
		return headNode;
	}
	
}
