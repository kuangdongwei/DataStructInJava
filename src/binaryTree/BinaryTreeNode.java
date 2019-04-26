package binaryTree;


public class BinaryTreeNode {

	private int data;
	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;
	
	public int getData()
	{
		return data;
	}
	
	public void setData(int data)
	{
		this.data = data;
	}

	public BinaryTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}
	
	//递归前序遍历
	void PreOrder(BinaryTreeNode root)
	{
		if(root != null)
		{
			System.out.println(root.getData());
			PreOrder(root.getLeftNode());
			PreOrder(root.getRightNode());
		}
	}
	
	//中序遍历
	void InOrder(BinaryTreeNode root)
	{
		if(root !=null)
		{
			InOrder(root.getLeftNode());
			System.out.println(root.getData());
			InOrder(root.getRightNode());
		}
	}
	
	//后序遍历
	void PostOrder(BinaryTreeNode root)
	{
		if(root != null)
		{
			PreOrder(root.leftNode);
			PreOrder(root.getRightNode());
			System.out.println(root.getData());
		}
	}
	
}

