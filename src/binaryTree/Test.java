package binaryTree;

public class Test {

	public static void main(String args[])
	{
		BinaryTreeNode root = new BinaryTreeNode(6);
		BinaryTreeNode leftNode = new BinaryTreeNode(3);
		BinaryTreeNode rightNode = new BinaryTreeNode(8);
		BinaryTreeNode Node1 = new BinaryTreeNode(2);
		BinaryTreeNode Node2 = new BinaryTreeNode(1);
		BinaryTreeNode Node3 = new BinaryTreeNode(5);
		BinaryTreeNode Node4 = new BinaryTreeNode(9);
		BinaryTreeNode Node5 = new BinaryTreeNode(4);
		
		root.setLeftNode(leftNode);
		root.setRightNode(rightNode);
		
		leftNode.setLeftNode(Node2);
		leftNode.setRightNode(Node1);
		rightNode.setLeftNode(Node3);
		rightNode.setRightNode(Node4);
		Node4.setLeftNode(Node5);
		
		root.printer(root);
	}
}
