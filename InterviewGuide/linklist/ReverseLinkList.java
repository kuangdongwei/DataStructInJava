package linklist;

public class ReverseLinkList {

	public static void main(String arags[]) {
		SingleLinkNode head = new SingleLinkNode(1);
		SingleLinkNode node1 = new SingleLinkNode(2);
		SingleLinkNode node2 = new SingleLinkNode(3);
		SingleLinkNode node3 = new SingleLinkNode(4);
		SingleLinkNode node4 = new SingleLinkNode(5);
		
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		System.out.print(head);	
	}
	
	
}
