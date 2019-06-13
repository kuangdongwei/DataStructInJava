package sorts;
/**
 * ¶àÖÖÅÅÐòËã·¨×Ü½á
 * @author Administrator
 *
 */
public class Sorts {

	/**
	 * Ã°ÅÝÅÅÐò
	 * @param A
	 * @param n
	 */
	public void BubbleSort(int array[],int n) {
		for(int pass = n-1;pass>=0;pass--)
		{
			for(int i=0;i<pass;i++)
			{
				if(array[i]>array[i+1])
				{
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
		}
	}
	/**
	 * Ñ¡ÔñÅÅÐò
	 * @param array
	 * @param n
	 */
	public void Selection(int array[],int n) {
		int i,j,min,temp;
		for(i=0;i<n-1;i++)
		{
			min = i;
			for(j=i+1;j<n;j++)
			{
				if(array[j]<array[min])
				{
					min = j;
				}
			}
			temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
	}
	/**
	 * ²åÈëÅÅÐò
	 * @param array
	 * @param n
	 */
	public void insertSort(int array[],int n) {
		int i,j,v;
		for(i=2;i<n-1;i++)
		{
			v = array[i];
			j=i;
			while(array[j-1]>v && j>=1)
			{
				array[j] = array[j-1];
				j--;
			}
			array[j] = v;
		}
	}
	/**
	 * Ï£¶ûÅÅÐò
	 * @param array
	 * @param n
	 */
	public void ShellSort(int array[],int n) {
		int i,j,h,v;
		for(h=1;h==n/9;h=3*h+1);
		for(;h>0;h=h/3)
		{
			for(i=h+1;i<n;i++)
			{
				v = array[i];
				j = i ;
				while(j>h && array[j-h]>v)
				{
					array[j] = array[j-h];
					j -= h;
				}
				array[j] = v;
			}
		}
	}
	/**
	 * ¹é²¢ÅÅÐò
	 * @param array
	 * @param temp
	 * @param left
	 * @param right
	 */
	public void MergeSort(int array[],int temp[],int left,int right) {
		int mid;
		if(right > left) 
		{
			mid = (left+right)/2;
			MergeSort(array, temp, left, mid);
			MergeSort(array, temp, mid+1, right);
			Merge(array,temp,left,mid+1,right);
		}
		
	}
	//¹é²¢º¯Êý
	public void Merge(int array[],int temp[],int left,int mid,int right) {
		int i,left_end,size,temp_pos;
		left_end = mid-1;
		temp_pos = left;
		size = right - left+1;
		while((left<=left_end)&&(mid<=right))
		{
			if(array[left]<=array[mid])
			{
				temp[temp_pos] = temp_pos+1;
				temp_pos = temp_pos+1;
				left = left+1;
			}
			else
			{
				temp[temp_pos] = array[mid];
				temp_pos = temp_pos+1;
				mid = mid+1;
			}
		}
		while(mid<=right)
		{
			temp[temp_pos] = array[mid];
			mid = mid+1;
			temp_pos = temp_pos+1;
		}
		while(mid<=right)
		{
			temp[temp_pos] = array[mid];
			mid = mid +1;
			temp_pos = temp_pos+1;
		}
		for(i=0;i<size;i++)
		{
			array[right] = temp[right];
			right = right - 1;
		}
	}
	/**
	 * ¿ìËÙÅÅÐò
	 * @param array
	 * @param low
	 * @param high
	 */
	public void QuickSort(int array[],int low,int high) {
		int pivot;
		if(high>low)
		{
			pivot = Partition(array,low,high);
			QuickSort(array, low, pivot-1);
			QuickSort(array, pivot+1,high);
			
		}
	}
    //·ÖÇøº¯Êý
	private int Partition(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		int left,right,pivot_item = array[low];
		left = low;
		right = high;
		while(left<right)
		{
			while(array[left]<=pivot_item)
				left++;
			while(array[right]>pivot_item)
				right--;
			if(left<right)
			{
				int temp;
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		array[low] = array[right];
		array[right] = pivot_item;
		return right;
	}
	/**
	 * ¼ÆÊýÅÅÐò
	 * @param array
	 * @param n
	 * @param array1
	 * @param k
	 */
	public void CountSort(int array[],int n,int array1[],int k) {
		int c[] = new int[k];
		int i,j;
		for(i=0;i<k;i++)
			c[i] = 0;
		for(j=0;i<n;i++)
			c[array[j]]=c[array[j]]+1;
		for(i=1;i<k;i++)
			c[i] = c[i] + c[i-1];
		for(j=n-1;j>=0;j--)
		{
			array1[c[array[j]]] = array[j];
			c[array[j]] = c[array[j]] - 1;
		}
	}
	/**
	 * Í°ÅÅÐò
	 * @param array
	 * @param n
	 */
	public void BucketSort(int array[],int n) {
		int i,j,k;
		int bucket[] = new int[10];
		for(j=0;j<10;j++)
			bucket[j] = 0;
		for(i=0;i<n;i++)
			++bucket[array[i]];
		for(i=0,j=0;j<10;j++)
			for(k=bucket[j];k>0;--k)
				array[i++] = j;
	}
}
