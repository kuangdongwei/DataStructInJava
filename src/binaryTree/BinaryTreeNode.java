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
	
	//�ݹ�ǰ�����
	void PreOrder(BinaryTreeNode root)
	{
		if(root != null)
		{
			System.out.println(root.getData());
			PreOrder(root.getLeftNode());
			PreOrder(root.getRightNode());
		}
	}
	
	//�������
	void InOrder(BinaryTreeNode root)
	{
		if(root !=null)
		{
			InOrder(root.getLeftNode());
			System.out.println(root.getData());
			InOrder(root.getRightNode());
		}
	}
	
	//�������
	void PostOrder(BinaryTreeNode root)
	{
		if(root != null)
		{
			PreOrder(root.leftNode);
			PreOrder(root.getRightNode());
			System.out.println(root.getData());
		}
	}
	
	//�ҳ�������������Ԫ��
	public int FindMax(BinaryTreeNode root)
	{
		int right,left,max = root.getData();
		if(root != null)
		{
			left = FindMax(root.getLeftNode());
			right = FindMax(root.getRightNode());
			if(left>max)
			{
				max = left;
			}
			else if(right>max)
			{
				max = right;
			}
		}
		return max;
	}
	
	//����ĳԪ���Ƿ��ڶ�������
	public boolean findElement(BinaryTreeNode root,int data)
	{
		boolean temp;
		if(root != null)
		{
			if(root.getData() == data)
				{
				  return true;
				}
			else 
			{
				temp  = findElement(root.getLeftNode(), data);
				if(temp == true)
					return temp;
				else 
					temp = findElement(root.getRightNode(), data);
				return temp;
			}
		}
			return false;
	}
	
	//ͳ�ƶ������Ľڵ���
	public int getSizeOfBinary(BinaryTreeNode root )
	{
		int count = 0;
		if(root==null) return 0;
		else
		{
			count++;
		    getSizeOfBinary(root.getLeftNode());
		    getSizeOfBinary(root.getRightNode());
		}
        return count;
	  }
	
	//ɾ����
	public void DeleteBinary(BinaryTreeNode root)
	{
		if(root == null)
			return;
		DeleteBinary(root.getLeftNode());
		DeleteBinary(root.getRightNode());
		root = null;
	}
	
	//�ݹ�������������������ĸ߶ȣ�Ȼ���ҳ������������߶��е����ֵ
	public int HeightTree(BinaryTreeNode root)
	{
		int leftheight,rightheight;
		if(root == null)
			return 0;
		else
		{
			leftheight = HeightTree(root.getLeftNode());
			rightheight = HeightTree(root.getRightNode());
			if(leftheight>rightheight)
			{
				return leftheight;
			}
			return rightheight;
		}
	}
	
	//���ڸ������������ж����ǵĽṹ�Ƿ���ͬ�����ͬ
	boolean isSame(BinaryTreeNode root1,BinaryTreeNode root2)
	{
		if(root1==null && root2 == null)
			return true;
		if(root1==null || root2==null)
			return false;
		return(root1.getData()==root2.getData() && isSame(root1.getLeftNode(),root2.getLeftNode()) && 
				isSame(root1.getRightNode(), root2.getRightNode()));
	}
	
	//�õݹ�������нڵ�����֮��
	public int SumNode(BinaryTreeNode root )
	{
		if(root == null)
			return 0;
		else
		{
			return (root.getData()+SumNode(root.getLeftNode())+SumNode(root.getRightNode()));
		}
	}
	
	//����һ�����������ľ�����
	public BinaryTreeNode MirrorBinary(BinaryTreeNode root)
	{
		BinaryTreeNode temp;
		if(root!=null)
		{
			MirrorBinary(root.getLeftNode());
			MirrorBinary(root.getRightNode());
			//change two pinter of nodes
			temp = root.getLeftNode();
			root.setLeftNode(root.getRightNode());
			root.setRightNode(temp);
		}
		return root;
	}
	
	//�����������ж������Ƿ�Ϊ����
	public boolean AreMirror(BinaryTreeNode root1,BinaryTreeNode root2)
	{
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.getData() != root2.getData())
			return  true;
		else {
			return (AreMirror(root1.getLeftNode(), root2.getLeftNode()) && AreMirror(root1.getRightNode(),
					root2.getRightNode()));
		}
	}
	
	public BinaryTreeNode BuildTree(int inOrder[],int preOrder[],int instrt,int inend)
	{
	    int preIndex = 0;
		BinaryTreeNode newNode = new BinaryTreeNode();
		if(instrt>inend)
		
			{
			System.out.println("memory error");
			return null;
			}
		newNode.setData(preOrder[preIndex]);
		preIndex++;
		if(instrt == inend)
			return newNode;
		
		int inIndex = Search(inOrder,instrt,inend,newNode.getData());
		newNode.setLeftNode(BuildTree(inOrder,preOrder,instrt,inIndex-1));
		newNode.setRightNode(BuildTree(inOrder,preOrder,inIndex+1,inend));
		return newNode;
		
	}

	private int Search(int[] inOrder, int instrt, int inend, int data2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}