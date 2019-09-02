package test;

import java.util.Scanner;

public class Sorts {

public static void quikSort(int [] arr,int low,int high) {
		
		if(low<high)
		{
			int middle = getMiddle(arr, low, high);
			quikSort(arr, low, middle-1);
			quikSort(arr, middle+1, high);
		}
	}
	
	public static int getMiddle(int [] arr,int low,int high) {
		int mid = arr[low];
		while(low<high)
		{
			while(low<high && arr[high]>mid)
			{
				high--;
			}
			arr[low] = arr[high];
			while(low<high && arr[low]<mid)
			{
				low++;
			}
			arr[high] = arr[low];
		}
		arr[low] = mid;
		return low;
	}
	
	public static void main(String args[]) {
	
		int array[] = new int[8];
		Scanner in = new Scanner(System.in);
		System.out.println("please input your array:");
		for(int i=0;i<8;i++)
		{
			array[i] = in.nextInt();
		}
		in.close();
		
		quikSort(array, 0, array.length-1);
		
		System.out.println("afger quikSort:");
		for(int i=0;i<8;i++)
		{
			System.out.print(array[i]+" ");
		}
	}
}
