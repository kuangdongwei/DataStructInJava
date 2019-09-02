package test;

public class JumpStage {

	public static int jumpStage(int N) {
		if(N < 2 ) 
			return 1;
        int array[] = new int [N+1];
        array[0] = 1;
        array[1] = 1;
        int position = 0;
        for(int i=2;i<array.length;i++)
        {
        	array[i] = array[i-1] + array[i-2];
        	position = i;
        }
		return array[position];
	}
	
	public static void main(String args[]) {
		
		int N = 6;
		int jumps = jumpStage(N);
		System.out.print("the number of jump ways:"+jumps);
	}
}
