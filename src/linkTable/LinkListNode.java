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
	
	
	
	//��ӡ����
	public void printListNode(LinkListNode headNode)
	{
		while(headNode.getNext()!=null)
		{
			System.out.print(headNode.getData()+"->");
			headNode = headNode.getNext();
		}
		System.out.println(headNode.getData());
	}
	//��ȡ������
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
	//��������
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
		if(position ==1) //������ʼ������
		{
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		}
		else  //�������м���߽�β����
		{
			LinkListNode previousNode = headNode;
			int count=1;
			while(count<position-1) //���������ҵ�Ҫ����λ�õ�ǰ���ڵ�
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
	//ɾ������
	LinkListNode DeleteNode(LinkListNode headNode,int position)
	{
		int size = ListLength(headNode);
		if(position >size || position<1)
		{
			System.out.println("position to delete is invalid:");
			return headNode;
		}
		if(position == 1) //ɾ����ͷ�ڵ�
		{
			LinkListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		}
		else //ɾ���м�ڵ��Ϊ�ڵ�
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
	
	//���õ�������
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
	
}
