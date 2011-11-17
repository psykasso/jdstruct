package interfaces;

/**
 * <p> This interface describes a directed graph </p>
 *
 * @version 3/6/2010
 */


public interface DirectedGraph extends Graph {

	/**
	*	<p>	Inserts an arc in the graph by specifying its start and end vertices.
	*		Returns true if the arc was added or already existed.
	*		Returns false if at least one of the specified vertices does not exist.
	*	@param GraphVertex
	*	@param GraphVertex
	*	</p>
	*/
	public boolean addArc(Object startVertex, Object endVertex);

	/**
	*	<p>	Deletes an arc from the graph. Returns true if arc was deleted.
	*		Returns false if arc does not exist.
	*	@param GraphVertex
	*	@param GraphVertex
	*	</p>
	*/
	public boolean deleteArc(Object startVertex, Object endVertex);

	/**
	*	<p>	Deletes all arcs starting from the given vertex
	*	@param GraphVertex
	*	</p>
	*/
	public boolean deleteAllArcsFrom(Object vertex);

	/**
	*	<p>	Deletes all arcs pointing to the given vertex
	*	@param GraphVertex
	*	</p>
	*/
	public boolean deleteAllArcsTo(Object vertex);

	/**
	*	<p>	Returns the number of arcs starting from the given vertex
	*	@return int
	*	</p>
	*/
	public int outDegreeOf(Object vertex);

	/**
	*	<p>	Returns the number of arcs ending at the given vertex
	*	@return int
	*	</p>
	*/
	public int inDegreeOf(Object vertex);

	/**
	*	<p>	Returns true if the given ordered pair (startVertex,endVertex) constitues an
	*		existing arc in the graph
	*	@param GraphVertex
	*	@param GraphVertex
	*	</p>
	*/
	public boolean isArc(Object startVertex, Object endVertex);

	/**
	*	<p>	Returns the undirected version of this graph
	*	@return UndirectedGraph
	*	</p>
	*/
	public UndirectedGraph toUndirected();
}
