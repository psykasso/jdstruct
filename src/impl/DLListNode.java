package impl;

/** <p> This class describes a list node structure, used in a double linked list data structure </p>
* 	@author Samaras Apostolis e-mail: samarasa@it.teithe.gr
* 	@version Last modified: 3/2/2007
*/

public class DLListNode extends ListNode{


	/**
	*	<p> Constructs an empty DLListNode
	*	</p>
	*/
	public DLListNode(){

		this(null, null, null);
	}

	/**
	*	<p> Constructs a DLListNode  initialized to the given values
	*	@param DLListNode the previous DLListNode
	*	@param Object the encapsulated object
	*	@param DLListNode the next DLListNode
	*	</p>
	*/
	public DLListNode(DLListNode prevNode, Object obj, DLListNode nextNode){

		super(obj,nextNode);
		previousNode = prevNode;
	}

	// ACCESSOR METHODS

	/**
	*	<p> Returns true if the node has a previous node </p>
	*/
	public boolean hasPrevious(){

		return !(previousNode==null);
	}

	/**
	*	<p> Returns the previous node
	*	@return DLListNode
	*	</p>
	*/
	public DLListNode getPreviousNode(){

		return previousNode;
	}

	// MUTATOR METHODS

	/**
	*	<p> Sets the previous node to the given node
	*	@param DLListNode
	*	</p>
	*/
	public void setPreviousNode(DLListNode n){

		previousNode = n;
	}

	private DLListNode previousNode;
}