package linkTable;

public class TestLinkListNode {

	public static void main(String args[])
	{
		LinkListNode node1 = new LinkListNode(1);
		LinkListNode node2 = new LinkListNode(2);
		LinkListNode node3 = new LinkListNode(3);
		LinkListNode node4 = new LinkListNode(4);
		LinkListNode node5 = new LinkListNode(5);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(null);
		LinkListNode headNode = node1;

		System.out.println("the length of listnode="+headNode.ListLength(headNode));
		headNode.printListNode(headNode); //打印链表
		//插入节点测试
		LinkListNode nodeToInsert1 = new LinkListNode(6);
		LinkListNode nodeToInsert2 = new LinkListNode(20);
		headNode.InsertInLinkList(headNode, nodeToInsert1, 5);
		headNode.InsertInLinkList(headNode, nodeToInsert2, 7);
		System.out.println("the length of listnode="+headNode.ListLength(headNode));
		headNode.printListNode(headNode);
		//删除节点测试
		headNode.DeleteNode(headNode, 1);
		headNode.printListNode(headNode);

	}
	
}
