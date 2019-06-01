package sorts;

public class Main {

	public static void main(String args[]) {
		int array[] = {
			1,2,5,7,4,6,3,5,9,8	
		};
		int n =10;
		Sorts test = new Sorts();
		test.BubbleSort(array, n);
		//test.BucketSort(array, n);
		//test.ShellSort(array, n);
        //test.Selection(array, n);
		//test.insertSort(array, n);
		for(int i=0;i<10;i++) {
	     System.out.print(array[i]+",");
		}
		
		//test.QuickSort(array, low, high);
		//test.MergeSort(array, temp, left, right);
		//test.CountSort(array, n, array1, k);
	}
}
