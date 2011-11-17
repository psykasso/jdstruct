package impl;

/** <p> This class describes a tree node that contains a Comparable </p>
* 	@version Last modified: 20/4/2010
*/

public class TreeNode {
	
	/**
	*	<p> Constructs a TreeNode containing a Comparable
	*	@param Comparable
	*	</p>
	*/
	public TreeNode(Comparable obj) {
		
		item = obj;
		left = right = null;
	}

	/**
	*	<p> Returns the data that the node contains
	*	@return Comparable
	*	</p>
	*/
	public Comparable getNodeItem()	{
	
		return item;
	}

	/**
	*	<p> Return left tree node
	*	@return TreeNode
	*	</p>
	*/
	public TreeNode getLeftNode() {

		return left;
	}

	/**
	*	<p> Return right tree node
	*	@return TreeNode
	*	</p>
	*/
	public TreeNode getRightNode() {
	
		return right;
	}

	/**
	*	<p> Return true if the node is leaf
	*	@return boolean
	*	</p>
	*/
	public boolean isLeaf()	{

		return ( (left == null) && (right==null));
	}

	/**
	*	<p> Sets the data that the node contains
	*	@param Comparable
	*	</p>
	*/
	public void setNodeItem(Comparable newItem)	{
	
		item = newItem;
	}

	/**
	*	<p> Set left tree node to the given node
	*	@param TreeNode
	*	</p>
	*/
	public void setLeftNode(TreeNode node) {

		left = node;
	}

	/**
	*	<p> Set right tree node to the given node
	*	@param TreeNode
	*	</p>
	*/
	public void setRightNode(TreeNode node) {

		right = node;
	}

	/**
	*	<p> Overwrites method toString() in class Object. Returns a String representation of this tree node.
	*	</p>
	*/
	public String toString() {

		return item.toString();
	}


	// PRIVATE INSTANCE FIELDS *******************************************
	private TreeNode left;
	private TreeNode right;
	private Comparable item;
}