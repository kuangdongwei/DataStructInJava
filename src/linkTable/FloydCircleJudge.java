package linkTable;

public class FloydCircleJudge {

	/*Floyd环判定方法使用两个在链表中具有不同移动速度的指针，这两个指针在链表中移动，一旦他们两相遇就说明链表存在环*/

	boolean DoseLinkedListContainsLoop(LinkListNode head)
	{
		if(head==null)
		{
			return false;
		}
		LinkListNode slowPtr = head;
		LinkListNode fastPtr = head;
		while(slowPtr.getNext()!=null && fastPtr.getNext().getNext()!=null)
		{
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
			if(slowPtr==fastPtr)
				return true;
		}
		return false;
	}
	
	//判定给定的链表是否以NULL结束。如果链表存在环则返回环的长度
	int FindLoopLength(LinkListNode head)
	{
		LinkListNode slowPtr = head;
		LinkListNode fastPtr = head;
		boolean loopExist = false;
		int counter = 0;
		if(head==null)
			return 0;
		while(slowPtr.getNext()!=null && fastPtr.getNext().getNext()!=null)
		{
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
			if(slowPtr==fastPtr)
				{
				loopExist = true;
				break;
				}
		}
		if(loopExist)
		{
			fastPtr = fastPtr.getNext();
			while(slowPtr != fastPtr)
			{				
				counter++;
				fastPtr = fastPtr.getNext();
			}
			return counter;		
		}
		return 0;
	}
}
