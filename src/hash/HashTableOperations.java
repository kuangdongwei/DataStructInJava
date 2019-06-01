package hash;

/**
 * hash operations
 * @author Chandler
 *
 */
public class HashTableOperations {

	public final static int LOADFACTOR = 20;
	public static HashTable createHashTable(int size) {
		HashTable h = new HashTable();
		h.settSize(size/LOADFACTOR);
		for(int i=0;i<h.gettSize();i++)
		{
			h.getTable()[i].setStartNode(null);
		}
		return h;
	}
	
	public static int hashSearch(HashTable h, int data) {
		ListNode temp;
		temp = h.getTable()[Hash(data,h.gettSize())].getStartNode();
		while(temp!=null)
		{
			if(temp.getData()==data)
			{
				return 1;
			}
			temp = temp.getNext();
		}
		return 0;
	}
	
	private static int Hash(int data, int gettSize) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unused")
	public static int hashInsert(HashTable h,int data) {
		int index;
		ListNode temp,newNode;
		if(hashSearch(h, data)==1)
			return 0;
		index = Hash(data,h.gettSize());
		temp = h.getTable()[index].getNext();
		newNode = new ListNode();
		if(newNode == null)
		{
			System.out.println("Memory error");
			return 0;
		}
		newNode.setKey(index);
		newNode.setData(data);
		newNode.setNext(h.getTable()[index].getNext());
		h.getTable()[index].setNext(newNode);
		h.getTable()[index].setBlockCount(h.getTable()[index].getBlockCount()+1);
		h.setCount(h.getCount()+1);
		if(h.getCount()/h.gettSize()>LOADFACTOR)
			rehash(h);
		return 0;
	}
	
	public static int hashDelete(HashTable h,int data) {
		ListNode temp,prev;
		int index = Hash(data,h.gettSize());
		for(temp = h.getTable()[index].getNext(),prev = null;temp!=null;
				prev = temp,temp=temp.getNext())
		{
			if(temp.getData()==data)
			{
				if(prev != null)
					prev.setNext(temp.getNext());
				temp = null;
				h.getTable()[index].setBlockCount(h.getTable()[index].getBlockCount()-1);
				h.setCount(h.getCount()-1);
				return 1;
			}
		}
		return 0;
	}
	
	public static void rehash(HashTable h) {
		int oldsize,i,index;
		ListNode temp,temp2;
		HashTableNode[] oldTable;
		oldsize = h.gettSize();
		oldTable = h.getTable();
		h.settSize(h.gettSize()*2);
		h = new HashTable();
		if(h.gettSize()!=0)
		{
			System.out.println("memory error");
		}
		for(i=0;i<oldsize;i++)
		{
			for(temp=oldTable[i].getNext();temp!=null;temp=temp.getNext())
			{
				index = Hash(temp.getData(),h.gettSize());
				temp2 = temp;
				temp = temp.getNext();
				temp2.setNext(h.getTable()[i].getNext());
				h.getTable()[index].setNext(temp2);
			}
		}
		
	}
}
