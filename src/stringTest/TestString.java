package stringTest;

public class TestString {
	
	private static int a = 10;
	
	public static class Internal{
		private int n;
		public Internal(int n) {
			this.n = n;
		}
		public int adder() {
			return a+n;  //˵�����Ա�������Ա���̬�ڲ���ʹ�ã���ʱ��Ա����Ҫ��static����
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
