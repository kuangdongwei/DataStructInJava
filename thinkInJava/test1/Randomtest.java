package test1;

import java.util.Random;

public class Randomtest {

	//get a random array
	public static int[] getRandom(int size)
	{
		Random random = new Random();
		int[] array = new int[size];
		for(int i=0;i<array.length;i++)
		{
			array[i] = random.nextInt(100);
		}
		return array;
	}
	//count the number of range(a to b)
	public static int Count(int[] a,int low ,int high)
	{
		int count = 0 ;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>=low && a[i]<high)
				count++;
		}
		return count;
	}
	
	public static void main(String args[])
	{
		int[] result = getRandom(30);
		for(int i=0;i<result.length;i++)
		{
			if(i%5==0)
				{System.out.println();}
			System.out.printf("%4d",result[i]);
		}
		System.out.println();
		int notPassed = Count(result,0,60);
		int passed = Count(result,60,100);
		System.out.println("number of students passed exam: "+passed);
		System.out.println("number of students do not passed exam: "+notPassed);
		System.out.println();
		if(passed>notPassed)
			System.out.println("teacher is very happy to this exam");
		System.out.println("teacher is angry to this exam");
	}
}
