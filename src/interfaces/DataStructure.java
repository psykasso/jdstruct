package interfaces;
/**
*	<p> This interface describes a general data structure </p>
*
*	@version Last modified: 9/3/2010
*/

public interface DataStructure {

	/**
	*	<p>	Returns the number of elements in this structure.
	*	@return int
	*	</p>
	*/
	
	
	public int size();
	

	/**
	*	<p>	Returns true if this structure contains no elements.
	*	@return boolean
	*	</p>
	*/
	public boolean isEmpty();

	/**
	*	<p>	Returns true if this structure cannot accept any more elements
	*	@return boolean
	*	</p>
	*/
	public boolean isFull();

	/**
	*	<p>	 Returns true if this structure contains the specified element.
	*	@return boolean
	*	@param Object
	*	</p>
	*/
	public boolean contains(Object obj);

	/**
	*	<p>	Removes all of the elements from this structure
	*	@param Object
	*	</p>
	*/
	public void clear();

	/**
	*	<p>	Returns true if this structure is equal to the otherStructure
	*	@return boolean
	*	@param DataStructure
	*	</p>
	*/
	public boolean equals(DataStructure otherStructure);

}