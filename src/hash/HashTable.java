package hash;


public class HashTable {

	private int tSize;
	private int count;
	private HashTableNode[] table;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int gettSize() {
		return tSize;
	}
	public void settSize(int size) {
		this.tSize = size;
		setTable(new HashTableNode[size]);
	}
	public HashTableNode[] getTable() {
		return table;
	}
	public void setTable(HashTableNode[] table) {
		this.table = table;
	}
	
}
