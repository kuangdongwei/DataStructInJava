package binaryTree;

public class PrintPaths {

	
	
	@SuppressWarnings("unused")
	private void printPaths(BinaryTreeNode node,int[] path,int pathlen)
	{
		if(node==null) return;
		//将节点添加到路径数组中
		path[pathlen] = node.getData();
		pathlen++;
		if(node.getLeftNode() == null&&node.getRightNode() == null)
			printArray(path,pathlen);
		else
		{
			printPaths(node.getLeftNode(),path,pathlen);
			printPaths(node.getRightNode(),path,pathlen);
		}
	}
	
	private void printArray(int[] ints,int len)
	{
		for(int i=0;i<len;i++)
		{
			System.out.print(ints[i] + " ");
		}
		System.out.println();
	}
}
