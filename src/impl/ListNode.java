package impl;

/** <p> This class describes a list node, used to construct a simple linked list structure </p>
* 	@version Last modified: 31/3/2010
*/


public class ListNode {

	/**
	*	<p> Constructs an empty ListNode with no next node
	*	</p>
	*/
	public ListNode() {

		this(null,null);
	}

	/**
	*	<p> Constructs a ListNode containing obj and having no next node
	*	@param Object The encapsulated object
	*	</p>
	*/
	public ListNode(Object obj) {

		this(obj,null);
	}

	/**
	*	<p> Constructs a ListNode containing obj and pointing to n as the next node
	*	@param Object The encapsulated object
	*	@param ListNode The next ListNode
	*	</p>
	*/
	public ListNode(Object obj, ListNode n) {

		item = obj;
		nextNode = n;
	}

	/**
	*	<p> Returns the object that the node contains
	*	@return Object
	*	</p>
	*/
	public Object getNodeItem() {

		return item;
	}

	/**
	*	<p> Returns true if the node has a next node </p>
	*	@return boolean
	*/
	public boolean hasNext() {

		return (nextNode!=null);
	}

	/**
	*	<p> Returns the next node
	*	@return ListNode
	*	</p>
	*/
	public ListNode getNextNode(){

		return nextNode;
	}

	/**
	*	<p> Sets the node's item to the given object
	*	@param Object
	*	</p>
	*/
	public void setNodeItem(Object obj) {

		item = obj;
	}

	/**
	*	<p> Sets n to be the next node
	*	@param ListNode
	*	</p>
	*/
	public void setNextNode(ListNode n) {

		nextNode = n;
	}

	/**
	*	<p> toString method </p>
	*/
	public String toString() {

		return item.toString();
	}


	// PRIVATE INSTANCE FIELDS *************************************************
	private Object item;
	private ListNode nextNode;
}