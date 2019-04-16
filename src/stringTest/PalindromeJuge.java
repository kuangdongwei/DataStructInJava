package stringTest;

import java.util.Scanner;
//判断一个字符串是否是回文字符串
public class PalindromeJuge {

	private String str;
	public PalindromeJuge(String str)
	{
		super();
		this.str = str;
	}
	
	//judge whether the  str is palindrome
	public boolean isPalindrome()
	{
		char A[]=str.toCharArray();
		int i=0,j=A.length-1;
		while(i<j && A[i]==A[j])
		{
			i++;
			j--;
		}
		if(i<j)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("input the string you wanna test:");
		String str = scan.nextLine();
		PalindromeJuge test = new PalindromeJuge(str);
		System.out.println("is this string palindrome? -- "+test.isPalindrome());
	}
}
