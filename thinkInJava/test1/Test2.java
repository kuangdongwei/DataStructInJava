package test1;

public class Test2 {

	private static void Test(String s)
	{
		System.out.println(s);
		Test(s);
	}
	public static void main(String args[])
	{
		Test("hello world");
	}
}
