package test1;

import java.util.Scanner;

public class Test1 {

	public static void nLines(int n)
	{
		if(n==0)
		{
			System.out.println("***over***");
			return;
		}
	else
		{
			System.out.println("*** "+n+" ***");
			nLines(n-1);
		}
	}
	
	public static void main(String args[])
	{
		int N ;
		Scanner in = new Scanner(System.in);
		System.out.print("please input a integer: ");
		N = in.nextInt();
        nLines(N);
        in.close();
	}
}
