package interfaces;

import exceptions.StructureEmptyException;
import exceptions.StructureFullException;

/** <p> This interface describes a queue data structure </p>
* 	@version Last modified: 16/3/2010
*/


public interface Queue extends DataStructure {

	/**
	*	<p>	Adds a new element into the Queue
	*	@param Object
	*	</p>
	*/
	public void enqueue(Object element) throws StructureFullException;


	/**
	*	<p>	Removes the front element of the Queue
	*	@return Object
	*	</p>
	*/
	public Object dequeue() throws StructureEmptyException;


	/**
	*	<p>	Returns the front element of the Queue
	*	@return Object
	*	</p>
	*/
	public Object front() throws StructureEmptyException;
}