package stack;

//�����ȣ���������A��A[i]�Ŀ��ָ��������֮ǰA[j-1]<=A[j]������Ԫ�صĸ�������A={1,2,3,2,5,6},��������Ϊ{1��2��3��1��2��3}
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
