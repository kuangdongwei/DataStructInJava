package test;

import stackandqueue.WinMaxArray;

public class TestWinMaxArray {

	public static void main(String args[]) {
		
		WinMaxArray obj = new WinMaxArray();
		int [] array = {4,3,5,4,3,3,6,7};
		System.out.print("original array:");
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]);
		}
		System.out.println();
		System.out.println("the window maximum array:");
		int [] winarray = obj.getWinMax(array, 3);
		for(int i=0;i<winarray.length;i++)
		{
			System.out.print(winarray[i]);
		}
	}
}
