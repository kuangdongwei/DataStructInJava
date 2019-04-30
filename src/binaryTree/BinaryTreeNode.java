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
	
	//找出二叉树中最大的元素
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
	
	//查找某元素是否在二叉树中
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
	
	//统计二叉树的节点数
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
	
	//删除树
	public void DeleteBinary(BinaryTreeNode root)
	{
		if(root == null)
			return;
		DeleteBinary(root.getLeftNode());
		DeleteBinary(root.getRightNode());
		root = null;
	}
	
	//递归计算左子树和右子树的高度，然后找出这两棵子树高度中的最大值
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
	
	//对于给定的两棵树判断他们的结构是否相同如果相同
	boolean isSame(BinaryTreeNode root1,BinaryTreeNode root2)
	{
		if(root1==null && root2 == null)
			return true;
		if(root1==null || root2==null)
			return false;
		return(root1.getData()==root2.getData() && isSame(root1.getLeftNode(),root2.getLeftNode()) && 
				isSame(root1.getRightNode(), root2.getRightNode()));
	}
	
	//用递归求出所有节点数据之和
	public int SumNode(BinaryTreeNode root )
	{
		if(root == null)
			return 0;
		else
		{
			return (root.getData()+SumNode(root.getLeftNode())+SumNode(root.getRightNode()));
		}
	}
	
	//给定一棵树生成它的镜像树
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
	
	//给定两棵树判断他们是否互为镜像
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