package linkTable;

public class TestListNode {

	public static void main(String args[])
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(null);
		ListNode headNode = node1;

		System.out.println("the length of listnode="+headNode.ListLength(headNode));
		headNode.printListNode(headNode); //打印链表
		//插入节点测试
		ListNode nodeToInsert1 = new ListNode(6);
		ListNode nodeToInsert2 = new ListNode(9);
		headNode.InsertInLinkList(headNode, nodeToInsert1, 5);
		headNode.InsertInLinkList(headNode, nodeToInsert2, 7);
		System.out.println("the length of listnode="+headNode.ListLength(headNode));
		headNode.printListNode(headNode);
		//删除节点测试
		headNode.DeleteNode(headNode, 1);
		headNode.printListNode(headNode);

	}
	
}
