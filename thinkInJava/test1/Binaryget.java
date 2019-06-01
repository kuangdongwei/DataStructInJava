package test1;

import java.util.Scanner;

public class Binaryget {

	public static void getBinary(int value)
	{
		if(value>0)
		{
			getBinary(value/2);
			System.out.print(value%2);
		}
	}
	
	public static void main(String args[])
	{
		int n;
		while(true)
		{
		System.out.print("input a integer you wanna transform: ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		getBinary(n);
		System.out.println();
		}
	}
}
