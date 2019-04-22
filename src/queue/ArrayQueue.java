package queue;
//基于简单循环数组实现队列
public class ArrayQueue {

	private int front;
	private int rear;
	private int capacity;
	private int[] array;
	
	private  ArrayQueue(int size)
	{
		this.capacity = size;
		front = -1;
		rear = -1;
		array = new int[size];
	}
	
	public ArrayQueue createQueue(int size)
	{
		return new ArrayQueue(size);
	}
	
	public boolean isEmpty()
	{
		return (front == -1);
	}
	
	public boolean isFull()
	{
		return ((rear+1)%capacity == front );
	}
	
	public int getQueueSize()
	{
		return ((capacity-front+rear+1)%capacity);
	}
	
	public void enQueue(int data)
	{
		if(isFull())
		{
			System.out.println("queue is full");
		}
		else
		{
			rear = (rear+1)%capacity;
			array[rear] = data;
			if(front == -1)
			{
				front = rear;
			}
		}
	}
	
	public int deQueue()
	{
		int data = 0;
		if(isEmpty())
		{
			System.out.println("queue is empty");
		}else
		{
			data = array[front];
			if(front == rear)
			{
				front = rear-1;
			}else
			{
				front = (front+1)%capacity;
			}
		}
		return data;
	}
}
