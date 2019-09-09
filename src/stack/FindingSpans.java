package stack;

//计算跨度：给定数组A，A[i]的跨度指满足在它之前A[j-1]<=A[j]的连续元素的个数，如A={1,2,3,2,5,6},则跨度数组为{1，2，3，1，2，3}
public class FindingSpans {

	
	public void findings(int[] inputArray)
	{
		int[] spans=new int[inputArray.length];
		for(int i=0;i<inputArray.length;i++)
		{
			int span = 1;
			int j=i-1;
			while(j>=0 && inputArray[j]<=inputArray[j+1])
			{
				span++;
				j--;
			}
			spans[i]=span;
		}
		for(int i=0;i<spans.length;i++)
		{
			System.out.print(spans[i]+" ");
		}
	}
	
	public static void main(String args[])
	{
		int[] inputArray = {1,2,3,2,5,6};
		System.out.println("the original array is :");
		for(int i=0;i<inputArray.length;i++)
		{
			System.out.print(inputArray[i]+",");
		}
		System.out.println();
		FindingSpans array = new FindingSpans();
		array.findings(inputArray);
	}
}
