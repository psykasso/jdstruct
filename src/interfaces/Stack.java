package interfaces;

import exceptions.StructureEmptyException;
import exceptions.StructureFullException;

/**
*	<p> This interface describes a stack data structure </p>
*
*	@version Last modified: 5/8/2007
*/


public interface Stack extends DataStructure {

	/**
	*	<p>	Adds a new element into the Stack
	*	@param Object
	*	</p>
	*/
	public void push(Object element) throws StructureFullException;


	/**
	*	<p>	Removes and returns the top element of the Stack
	*	@return Object
	*	</p>
	*/
	public Object pop() throws StructureEmptyException;


	/**
	*	<p>	Returns the top element of the Stack
	*	@return Object
	*	</p>
	*/
	public Object top() throws StructureEmptyException;
}