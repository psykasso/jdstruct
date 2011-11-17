package impl.graph;

/**
 * <p> This class describes an arc. It can be used for both directed and
 *		undirected graphs. </p>
 *
 * @version 3/6/2010
 */

public class GraphArc {

	public GraphArc(GraphVertex end, Object w) {
		endVertex = end;
		weight = w;
	}

	public GraphVertex getEndVertex() {
		return endVertex;
	}

	public Object getWeight() {
		return weight;
	}

	public void setEndVertex(GraphVertex vertex) {
		endVertex = vertex;
	}

	public void setWeight(Object w) {
		weight = w;
	}

   // PRIVATE INSTANCE FIELDS
		private GraphVertex endVertex;
		private Object weight;
}