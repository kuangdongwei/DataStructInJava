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
	
	
	
	//��ӡ����
	public void printListNode(ListNode headNode)
	{
		while(headNode.getNext()!=null)
		{
			System.out.print(headNode.getData()+"->");
			headNode = headNode.getNext();
		}
		System.out.println(headNode.getData());
	}
	//��ȡ������
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
	//��������
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
		if(position ==1) //������ʼ������
		{
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		}
		else  //�������м���߽�β����
		{
			ListNode previousNode = headNode;
			int count=1;
			while(count<position-1) //���������ҵ�Ҫ����λ�õ�ǰ���ڵ�
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
	//ɾ������
	ListNode DeleteNode(ListNode headNode,int position)
	{
		int size = ListLength(headNode);
		if(position >size || position<1)
		{
			System.out.println("position to delete is invalid:");
			return headNode;
		}
		if(position == 1) //ɾ����ͷ�ڵ�
		{
			ListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		}
		else //ɾ���м�ڵ��Ϊ�ڵ�
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
