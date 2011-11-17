package interfaces;

import exceptions.StructureEmptyException;
import exceptions.StructureFullException;

/** <p> This interface describes a binary search tree structure </p>
* 	@version Last modified: 3/6/2010
*/


public interface BSTree extends DataStructure {

	/**
	*	<p>	Adds a new item into the tree
	*	@param Comparable
	*	</p>
	*/
	public void add(Comparable item) throws StructureFullException;

	/**
	*	<p>	Removes item from the tree
	*	@param Comparable
	*	</p>
	*/
	public void remove(Comparable item) throws StructureEmptyException;
	
	/**
	*	<p>	Removes the item at the root of the tree
	*	@return Comparable
	*	</p>
	*/
	public Comparable removeRoot() throws StructureEmptyException;
}