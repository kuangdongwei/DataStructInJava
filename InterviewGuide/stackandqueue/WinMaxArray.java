package stackandqueue;
/**
 * 
 * @author Chandler
 * 暴力法求窗口最大值数组（O（n）时间复杂度的解法在后面的注释代码中)
 *
 */
public class WinMaxArray {

	public static int findMax(int[] array) {
		int max = array[0] ;
		for(int i=1;i<array.length;i++)
		{
			if(array[i]>max)
				max = array[i];
		}
		return max;
	}
	
	public int[] getWinMax(int [] arr,int w)
	{
		if(arr==null || arr.length<3 || w<1)
		{
			System.out.println("the array is unsupported!!!");
			return null;
		}
		int [] outarray = new int[arr.length-w+1];
		for(int i=0;i<=arr.length-w;i++)
		{
			int [] helparray = new int[w];
			for(int j=0;j<w;j++)
			{
				helparray[j] = arr[i+j];
			}
			int max = findMax(helparray);
			outarray[i] = max;
		}
		return outarray;
	}
}


/*
 //更好的解法
public int [] getWinMax(int [] arr,int w)
{
   .....
   LinkedList<Integer> qmax = new LinkedList<Integer>();
   int [] res = new int[arr.length-w+1];
   int index =0;
   for(int i=0;i<arr.length;i++)
   {
      while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i])
      {
         qmax.pollLast();
       }
       qmax.addLast(i);
       }
      if(qmax.peekFirst() == i-w)
      {
        qmax.pollFirst();
      }
      if(i>=w-1)
      {
         res[index++] = arr[qmax.peekFirst()];
      }
    }
    return res;
  }
*/    