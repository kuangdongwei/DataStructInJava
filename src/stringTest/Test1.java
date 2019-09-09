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

	public static  void FirstRepeated(char[] str) {
        char count[] = new char[256];
		for(int i=0;i<256;i++)
		{
			count[i]=0;
		}
		for(int i=0;i<str.length;i++)
		{
			if(count[str[i]]==1)
			{
				System.out.println(str[i]);
				break;
			}
			else
			{
				count[str[i]]++;
			}
			if(i==str.length)
				System.out.println("no repeated characters");
		}
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
		
		char str[] ={'a','b','d','c','c','a','d'};
	   FirstRepeated(str);
	}
}
