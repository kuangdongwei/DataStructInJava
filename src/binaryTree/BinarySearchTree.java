package binaryTree;

public class BinarySearchTree {

	/**
	 * 二叉树的数据结构如下
	 */
	private int data;
	private BinarySearchTree leftNode;
	private BinarySearchTree rightNode;
	
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinarySearchTree getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinarySearchTree leftNode) {
		this.leftNode = leftNode;
	}
	public BinarySearchTree getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinarySearchTree rightNode) {
		this.rightNode = rightNode;
	}
	
	/**
	 * 打印这棵树
	 */
	public void printer(BinaryTreeNode root)
	{
		if(root!=null)
			System.out.println(root.getData());
		if(root.getLeftNode()!=null)
			{
			  System.out.print(root.getData()+"->left:");
			  printer(root.getLeftNode());
			}
		if(root.getRightNode()!=null)
		{
			System.out.print(root.getData()+"->right:");
			printer(root.getRightNode());
		}
	}
	
	//递归方法实现寻找元素
	public BinarySearchTree Find(BinarySearchTree root,int data)
	{
		if(root==null) return null;
		if(data<root.getData())
			return Find(root.getLeftNode(),data);
		if(data>root.getData())
			return Find(root.getRightNode(),data);
		return root;
	}
	
	//非递归方式实现寻找元素
	public BinarySearchTree FindWay(BinarySearchTree root,int data)
	{
		if(root == null) return null;
		while(root != null)
		{
			if(data == root.getData())
				return root;
			else if(data<root.getData())
    			root = root.getLeftNode();
			else
			    root = root.getRightNode();
		}
		return null;
	}
	
	//递归方式寻找最小元素
	@SuppressWarnings("null")
	public int FindMin(BinarySearchTree root)
	{
		if(root == null)
			System.out.println("error:the tree is null ");
		else
		{
			if(root.getLeftNode() == null)
				return root.getData();
			return FindMin(root.getLeftNode());
		}
		return root.getData();
	}
	
	//非递归方式寻找最小元素
	public int FindMinWay(BinarySearchTree root)
	{
		if(root == null)
			System.out.println("error:the tree is null");
		while(root.getLeftNode() != null)
		{
			root = root.getLeftNode();
		}
		return root.getData();
	}
	
	//递归方式寻找最大元素
		@SuppressWarnings("null")
		public BinarySearchTree FindMax(BinarySearchTree root)
		{
			if(root == null)
				System.out.println("error:the tree is null ");
			else
			{
				if(root.getRightNode() == null)
					return root;
				return FindMax(root.getRightNode());
			}
			return root;
		}
		
		//非递归方式寻找最大元素
		public int FindMaxWay(BinarySearchTree root)
		{
			if(root == null)
				System.out.println("error:the tree is null");
			while(root.getRightNode() != null)
			{
				root = root.getRightNode();
			}
			return root.getData();
		}
		
		//插入元素
		@SuppressWarnings("unused")
		public BinarySearchTree Insert(BinarySearchTree root,int data)
		{
			if(root == null)
			{
				root = new BinarySearchTree();
				if(root == null)
					System.out.println("memory error");
				else
				{
					root.setData(data);
					root.setLeftNode(Insert(root.getLeftNode(),data));
				}
			}
			else
			{
				if(data<root.getData())
				{
					root.setLeftNode(Insert(root.getLeftNode(),data));
				}
				else if(data>root.getData())
				{
					root.setRightNode(Insert(root.getRightNode(),data));
				}
			}
			return root;
		}
	
	     //删除元素
		BinarySearchTree Delete(BinarySearchTree root,int data)
		{
			BinarySearchTree temp;
			if(root == null)
				System.out.println("error:element not in this tree");
			else if(data<root.getData())
				root.leftNode = Delete(root.getLeftNode(),data);
			else if(data>root.getData())
				root.rightNode = Delete(root.getRightNode(),data);
			else //找到这个元素
			{
				if(root.getLeftNode()!=null && root.getRightNode()!=null)
				{
					//用左子树中的最大值代替
					temp = FindMax(root.getLeftNode());
					root.setData(temp.data);
					root.leftNode = Delete(root.getLeftNode(),root.getData());
					
				}
				else
				{
					temp = root;
					if(root.getLeftNode() == null)
						root = root.getRightNode();
					if(root.getRightNode() == null)
						root = root.getLeftNode();
					temp = null;
				}
			}
			return root;
		}
		
}
