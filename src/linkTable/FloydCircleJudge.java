package linkTable;

public class FloydCircleJudge {

	/*Floyd���ж�����ʹ�������������о��в�ͬ�ƶ��ٶȵ�ָ�룬������ָ�����������ƶ���һ��������������˵��������ڻ�*/

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
	
	//�ж������������Ƿ���NULL���������������ڻ��򷵻ػ��ĳ���
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
