package linkTable;
//如何把两个有序链表合并成一个新的有序的链表
/*public class MergeLinkList {

	public static void main(String args[])
	{
		private LinkListNode a;
		private LinkListNode b;
		
		LinkListNode Merge(LinkListNode a,LinkListNode b)
		{
			LinkListNode result = null;
			if(a==null)
				return b;
			if(b==null)
				return a;
			if(a.getData()<=b.getData())
			{
				return a;
				result.setNext(Merge(a.getNext(),b));
			}
			else
			{
				result = b;
				result.setNext(Merge(b.getNext(),a));
			}
			return result;
		}
	}
}
*/