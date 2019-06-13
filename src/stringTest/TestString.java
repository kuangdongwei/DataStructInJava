package stringTest;

public class TestString {
	
	private static int a = 10;
	
	public static class Internal{
		private int n;
		public Internal(int n) {
			this.n = n;
		}
		public int adder() {
			return a+n;  //说明类成员变量可以被静态内部内使用，此时成员变量要被static修饰
		}
		
	}
	
	public static void main(String args[]) {
		String [] s = new String[10];
		System.out.println("the length of s: "+s.length);
		System.out.println(s[9]);
		
		int x = 20,y = 5;
		System.out.println(x+y+""+(x+y)+y);
	}

}
