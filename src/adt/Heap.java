package adt;
//基于有序数组实现堆
public class Heap {

	public int[] array;
	public int capacity; //堆大小
	public int count;  //堆中元素的个数
	public int heap_type; //堆类型
	
	public Heap(int capacity,int heap_type)
	{
		this.capacity = capacity;
		this.heap_type = heap_type;
		this.count = 0;
		this.array = new int[capacity];
	}
	
	//获取指定位置的父节点的索引
	public int Parent(int i)
	{
		if(i<0 || i>this.count)
			return -1;
		return (i-1)/2;
	}
	//获取指定位置的座子节点的索引
	public int LeftChild(int i)
	{
		int left = 2*i+1;
		if(left>=this.count)
			return -1;
		return left;
	}
	//获取指定位置的右子节点的索引
	public int RightChild(int i)
	{
		int right = 2*i+2;
		if(right>=this.count)
			return -1;
		return right;
	}
	//获取最大堆的最大元素值
	public int GetMax(int i)
	{
		if(this.count==0)
			return -1;
		return this.array[0];
	}
	
	//堆化当前元素
	public void PercolateDown(int i)
	{
		int l,r,max,temp;
		max = i;
		l = LeftChild(i);
		r = RightChild(i);
		if(l!=-1 && this.array[l]>this.array[i])
			max = l;
		if(r!=-1 && this.array[r]>this.array[i])
			max = r;
		if(max != i)
		{
			temp = this.array[i];
			this.array[i] = this.array[max];
			this.array[max] = temp;
		}
		PercolateDown(max);
	}
	
	//删除元素；为了从堆中删除元素，只需要从根节点删除元素，这是标准堆支持的唯一删除操作。
	//当啊删除根节点后，将堆（树）的最后一个节点复制到这个位置，然后删除最后的元素，再调用堆化函数调整堆
	public int DeleteMax()
	{
		if(this.count==0)
			return -1;
		int data = this.array[0];
		this.array[0] = this.array[this.count-1];
		this.count--;
	    PercolateDown(0);
	    return data;
	}
	
	//插入元素
	public void Insert(int data)
	{
		int i;
		if(this.count == this.capacity)
			ResizeHeap();
		this.count++;
		i = this.count-1;
		while(i>=0 && data>this.array[(i-1)/2])
		{
			this.array[i] = this.array[(i-1)/2];
			i = i-1/2;
		}
		this.array[i] = data;
	}
	public void ResizeHeap()
	{
		int[] array_old = new int[this.capacity];
		System.arraycopy(this.array, 0, array_old, this.count-1, capacity);
		this.array = new int[this.capacity*2];
		if(this.array == null)
		{
			System.out.println("out of momory ");
			return;
		}
		for(int i=0;i<this.capacity;i++)
		{
			this.array[i] = array_old[i];
		}
		this.capacity*=2;
		array_old = null;
	}
	
	//清空堆
	public void DestroyHeap()
	{
		this.count = 0;
		this.array = null;
	}
	
	//数组建堆
	public void BuildHeap(Heap h,int[] A,int n)
	{
		if(h==null)
			return;
		while(n>this.capacity)
			h.ResizeHeap();
		for(int i=0;i<n;i++)
			h.array[i] = A[i];
		this.count = n;
		for(int i=(n-1)/2;i>0;i--)
			h.PercolateDown(i);
	}
	
	//堆排序
	public void SortHeap(int A[],int n)
	{
		Heap h = new Heap(n,0);
		int old_size,i,temp;
		BuildHeap(h,A,n);
		old_size = h.count;
		for(i=n-1;i>0;i--)
		{
			temp = h.array[0];
			h.array[0] = h.array[h.count-1];
			h.array[h.count-1] = temp;
			h.count--;
			h.PercolateDown(i);
		}
		h.count = old_size;
	}
}
