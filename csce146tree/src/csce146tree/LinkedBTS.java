package csce146tree;

public class LinkedBTS <extends Comparable> {
	publc class Node 
	{
		T data;
		Node leftChild;
		Node rightChild;
		public Node(T aData)
		{
			data = aData;
			
		}
	}

}
// MISSING LAST THURSDAYS CODE 







public boolean search (T dAta)
{
	return search(root, aData);
}
private boolean search(Node aNode, T aData);
{
	if(aNode == null)//leaf dead end 
		return false;
	else if(aData.compareTo(aNode.data)<0)
		return search(aNode.leftchild.aData);
	else if(aData.compareTo(aNode.data)>0)
		return search (aNode.rightChild,aData);
	else 
		return true;
}
public void remove(T aData)
{
	root = remove(root,aData);
}
private Node remove(Node aNode, T aData)
{
	if(aNode == null)
		return null;
	else if(aData.compareTo(aNode.data)<0)
		aNode.leftCiold = remove(aNode.leftChild,aData);
	else if(aData.compareTo(aNode.data)>0)
		aNode.leftChild = remove(aNode.rightChild,aData);
	else
	{
		
		
		//case 0
		//case 1
		//case 2
		
		if(aNode.rightChild == null)
			return aNode.leftChild;
		else if(aNode.leftChild == null)
			return aNode.rightChild;
		
		//two children 
		Node temp = findMinInTree(aNode.rightChild);
		aNode.data = temp.data;
		aNode.rightChild = remove(aNode.rightChild,temp.data);
	}
	
	
}
