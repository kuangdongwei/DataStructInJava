package hash;
/**
 * 用于实现散列函数分离链接冲突解决技术
 * @author Chandler
 *
 */
public class ListNode {

	private int key;
	private int data;
	private ListNode next;
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
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
	
}
