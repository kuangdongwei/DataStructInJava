package adt;
//������������ʵ�ֶ�
public class Heap {

	public int[] array;
	public int capacity; //�Ѵ�С
	public int count;  //����Ԫ�صĸ���
	public int heap_type; //������
	
	public Heap(int capacity,int heap_type)
	{
		this.capacity = capacity;
		this.heap_type = heap_type;
		this.count = 0;
		this.array = new int[capacity];
	}
	
	//��ȡָ��λ�õĸ��ڵ������
	public int Parent(int i)
	{
		if(i<0 || i>this.count)
			return -1;
		return (i-1)/2;
	}
	//��ȡָ��λ�õ����ӽڵ������
	public int LeftChild(int i)
	{
		int left = 2*i+1;
		if(left>=this.count)
			return -1;
		return left;
	}
	//��ȡָ��λ�õ����ӽڵ������
	public int RightChild(int i)
	{
		int right = 2*i+2;
		if(right>=this.count)
			return -1;
		return right;
	}
	//��ȡ���ѵ����Ԫ��ֵ
	public int GetMax(int i)
	{
		if(this.count==0)
			return -1;
		return this.array[0];
	}
	
	//�ѻ���ǰԪ��
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
	
	//ɾ��Ԫ�أ�Ϊ�˴Ӷ���ɾ��Ԫ�أ�ֻ��Ҫ�Ӹ��ڵ�ɾ��Ԫ�أ����Ǳ�׼��֧�ֵ�Ψһɾ��������
	//����ɾ�����ڵ�󣬽��ѣ����������һ���ڵ㸴�Ƶ����λ�ã�Ȼ��ɾ������Ԫ�أ��ٵ��öѻ�����������
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
	
	//����Ԫ��
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
	
	//��ն�
	public void DestroyHeap()
	{
		this.count = 0;
		this.array = null;
	}
	
	//���齨��
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
	
	//������
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
