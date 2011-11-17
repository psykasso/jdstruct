package interfaces;

/**
 * <p> This interface describes a general graph </p>
 *
 * @version 3/6/2010
 */


public interface Graph extends DataStructure {

	/**
	*	<p>	Inserts a vertex in the graph
	*	@param GraphVertex
	*	</p>
	*/
	public void addVertex(Object vertex);

	/**
	*	<p>	Deletes a vertex from the graph together with all connected arcs or edges
	*	@param GraphVertex
	*	</p>
	*/
	public boolean deleteVertex(Object vertex);

	/**
	*	<p>	Returns the number of vertices in the graph
	*	@return int
	*	</p>
	*/
	public int order();

	/**
	*	<p>	Returns the number of arcs or edges in the graph
	*	@return int
	*	</p>
	*/
	public int graphSize();

	/**
	*	<p>	Returns the number of arcs or edges connected to the given vertex
	*	@return int
	*	</p>
	*/
	public int degreeOf(Object vertex);

	/**
	*	<p>	Returns true if the given vertex exists in the graph
	*	@param GraphVertex
	*	</p>
	*/
	public boolean isVertex(Object vertex);

}
