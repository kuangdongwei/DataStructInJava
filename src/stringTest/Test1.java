package stringTest;

public class Test1 {
	
	public static String reverse(String s)
	{
		String r = " ";
		for(int i=s.length()-1;i>=0;i--)
		{
			r = r+s.charAt(i);
		}
		return r;
	}

	
	public static void main(String args[])
	{
		System.out.print("roman alphabet:");
		for(char c = 'A';c<='Z';c++)
		{
			System.out.print(c);
		}
		System.out.println();
		System.out.print("Greek alphabet:");
		for(int i=913;i<937;i++)
		{
			System.out.print((char) i);
		}
		
		String name = "Allen Iversion";
		String newName = name.toUpperCase();
		System.out.println(newName);
		int last = name.length()-1;
		char l = name.charAt(last);
		System.out.print(l);
		
		String nameReverse = reverse("james");
		System.out.println(nameReverse);
		
	}
}
