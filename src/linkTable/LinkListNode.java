package linkTable;

public class LinkListNode {

	private int data;
	private LinkListNode next;
	public LinkListNode(int data)
	{
		this.setData(data);
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkListNode getNext() {
		return next;
	}
	public void setNext(LinkListNode next) {
		this.next = next;
	}
	
	
	
	//打印链表
	public void printListNode(LinkListNode headNode)
	{
		while(headNode.getNext()!=null)
		{
			System.out.print(headNode.getData()+"->");
			headNode = headNode.getNext();
		}
		System.out.println(headNode.getData());
	}
	
	//逆向打印链表
	public void printListFromEnd(LinkListNode headNode)
	{
		if(headNode==null)
			return;
		printListFromEnd(headNode.getNext());
		System.out.printf(headNode.getData()+"->");
	}
	//获取链表长度
	int ListLength(LinkListNode headNode)
	{
		int length = 0;
		LinkListNode currentNode = headNode;
		while(currentNode!=null)
		{
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	//插入链表
	public LinkListNode InsertInLinkList(LinkListNode headNode,LinkListNode nodeToInsert,int position)
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
			LinkListNode previousNode = headNode;
			int count=1;
			while(count<position-1) //遍历链表找到要插入位置的前驱节点
			{
				previousNode = previousNode.getNext();
				count++;
			}
			LinkListNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
		}
		return headNode;
	}
	//删除链表
	LinkListNode DeleteNode(LinkListNode headNode,int position)
	{
		int size = ListLength(headNode);
		if(position >size || position<1)
		{
			System.out.println("position to delete is invalid:");
			return headNode;
		}
		if(position == 1) //删除表头节点
		{
			LinkListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		}
		else //删除中间节点或为节点
		{
			LinkListNode previousNode = headNode;
			int count=1;
			while(count<position)
			{
				previousNode = previousNode.getNext();
				count++;
			}
			LinkListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
		}
		return headNode;
	}
	
	//逆置单向链表
	LinkListNode ReverseList(LinkListNode head)
	{
		LinkListNode temp = null,nextNode = null;
		while(head!=null)
		{
			nextNode = head.getNext();
			head.setNext(temp);
			temp = head;
			head = nextNode;
		}
		return temp;
	}
	
	//交换链表中的相邻节点
	void ExchangeAdjacentNodes(LinkListNode head)
	{
		LinkListNode curNode,temp,nextNode;
		curNode = head;
		if(curNode==null || curNode.getNext()==null)
			return;
		head = curNode.getNext();
		while(curNode!=null&&curNode.getNext()!=null)
		{
        	nextNode = curNode.getNext();
			curNode.setNext(nextNode.getNext());
			temp = curNode.getNext();
			nextNode.setNext(curNode);
			if(temp!=null&&temp.getNext()!=null)
				curNode.setNext(curNode.getNext().getNext());
			curNode = temp;
		}
	}
	
	//约瑟夫环问题
	@SuppressWarnings("null")
	public void getJosephus(int N,int M)
	{
		LinkListNode p = null,q=null;
		p.setData(1);
		q=p;
		for(int i=2;i<=N;i++)
		{
			p = p.getNext();
			p.setData(i);
		}
		p.setNext(q);
		for(int count=N;count>1;count--)
		{
			for(int i=0;i<M;i++)
			{
				p=p.getNext();
			}
			p.setNext(p.getNext().getNext());
		}
		System.out.println("last player left standing is :"+p.getData());
		
	}
	
}
