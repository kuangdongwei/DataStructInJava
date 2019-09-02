package linklist;

public class SingleLinkNode {

	private int data;
	private SingleLinkNode next;
	
	public SingleLinkNode(int data) {
		this.setData(data);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SingleLinkNode getNext() {
		return next;
	}

	public void setNext(SingleLinkNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return this.data+"-->"+(this.getNext() != null?this.getNext().toString():null);
	}
}
