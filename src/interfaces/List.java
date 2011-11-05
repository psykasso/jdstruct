package interfaces;

import exceptions.StructureEmptyException;
import exceptions.StructureFullException;

/** <p> This interface describes a list data structure </p>
* 	@version Last modified: 24/3/2010
*/


public interface List extends DataStructure{

	/**
	*	<p> Returns the first object of the linked list
	*	@return Object
	*	</p>
	*/
	public Object getFirst() throws StructureEmptyException;

	/**
	*	<p> Returns the last object of the linked list
	*	@return Object
	*	</p>
	*/
	public Object getLast() throws StructureEmptyException;

	/**
	*	<p>	Inserts an object at the beggining of the list
	*	@param Object
	*	</p>
	*/
	public void insertFirst(Object data) throws StructureFullException;

	/**
	*	<p>	Inserts an object at the end of the list
	*	@param Object
	*	</p>
	*/
	public void insertLast(Object data) throws StructureFullException;

	/**
	*	<p>	Removes the first object from the list
	*	@return Object
	*	</p>
	*/
	public Object removeFirst() throws StructureEmptyException;

	/**
	*	<p>	Removes the last object from the list
	*	@return Object
	*	</p>
	*/
	public Object removeLast() throws StructureEmptyException;
}