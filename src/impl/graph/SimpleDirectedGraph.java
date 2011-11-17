package impl.graph;

import impl.SimpleLinkedList;
import interfaces.DataStructure;
import interfaces.DirectedGraph;
import interfaces.UndirectedGraph;

/**
 * <p>
 * This class describes a simple (no use of weights), directed graph
 * implementation, based on the concept of adjacency lists (listes geitniashs).
 * </p>
 * 
 * @version 2/6/2011
 */

public class SimpleDirectedGraph implements DirectedGraph {

    // *******************CONSTRUCTORS
    public SimpleDirectedGraph() {
        graph = new SimpleLinkedList();
    }

    // *******************METHODS included in DataStructure
    /**
     * <p>
     * Returns the number of elements in this structure, which we take to mean
     * the number of vertices.
     * 
     * @return int
     *         </p>
     */
    public int size() {
        return order();
    }

    /**
     * <p>
     * Returns true if this structure contains no vertices.
     * 
     * @return boolean
     *         </p>
     */
    public boolean isEmpty() {
        return (size() == 0);
        // or return (order()==0);
    }

    public boolean isFull() {
        return false;
    }

    /**
     * <p>
     * Returns true if this structure contains the specified vertex name.
     * 
     * @return boolean
     * @param Object
     *            </p>
     */
    public boolean contains(Object obj) {

        return isVertex(obj);
    }

    /**
     * <p>
     * Removes all of the elements from this structure
     * 
     * @param Object
     *            </p>
     */
    public void clear() {
        graph = new SimpleLinkedList();

        // 'h diaforetika
        // graph.clear();
    }

    public boolean equals(DataStructure otherStructure) {
        if (otherStructure.getClass() != SimpleDirectedGraph.class)
            throw new IllegalArgumentException(
                    "SimpleDirectedGraph.equals(): parameter is not a SimpleDirectedGraph");

        SimpleDirectedGraph sdg = (SimpleDirectedGraph) otherStructure;
        // the graphs are equal if and only if the number of vertices and
        // the number of arcs are equal.
        if (this.order() != sdg.order() || this.graphSize() != sdg.graphSize())
            return false;
        boolean result = true;
        int s = order();
        for (int i = 0; (i < s) && result; i++) {
            GraphVertex gv = (GraphVertex) graph.removeFirst();
            // check if the given vertex exists in the otherStructure
            if (!sdg.isVertex(gv.getName()))
                result = false;
            if (result) {
                // store the arcs for the current vertex
                SimpleLinkedList arcList = gv.getArcList();
                int n = arcList.size();
                for (int j = 0; (j < n) && result; j++) {
                    GraphArc ga = (GraphArc) arcList.removeFirst();
                    if (!sdg.isArc(gv.getName(), ga.getEndVertex().getName()))
                        result = false;
                    arcList.insertLast(ga);
                }
            }
            graph.insertLast(gv);
        }
        return result;
    }

    // *******************METHODS included in Graph

    public void addVertex(Object vertex) {
        // if vertex already in graph return
        if (isVertex(vertex))
            return;

        graph.insertLast(new GraphVertex(vertex));
    }

    public boolean deleteVertex(Object vertex) {
        if (isEmpty())
            return false;

        deleteAllArcsFrom(vertex);
        deleteAllArcsTo(vertex);

        boolean found = false;
        int s = order();
        for (int i = 0; i < s; i++) {
            GraphVertex gv = (GraphVertex) graph.removeFirst();
            if (found == false && gv.getName() == vertex) {
                found = true;
                continue;
            }
            graph.insertLast(gv);
        }
        return found;

    }

    public int order() {
        return graph.size();
    }

    /**
     * returns the sum of all the arcs in the graph.
     */
    public int graphSize() {
        int s = order();
        int count = 0;
        for (int i = 0; i < s; i++) {
            GraphVertex gv = (GraphVertex) graph.removeFirst();
            count += gv.outDegree();
            graph.insertLast(gv);
        }
        return count;
    }

    public int degreeOf(Object vertex) {
        return inDegreeOf(vertex) + outDegreeOf(vertex);
    }

    /**
     * return true if the vertex exists in the graph
     */
    public boolean isVertex(Object vertex) {

        int s = graph.size();
        for (int i = 0; i < s; i++) {
            GraphVertex gv = (GraphVertex) graph.removeFirst();
            graph.insertLast(gv);
            if (gv.getName().equals(vertex))
                return true;
        }

        return false;
    }

    // *******************METHODS included in DirectedGraph

    public boolean addArc(Object startVertex, Object endVertex) {
        // if arc already exists return true
        if (isArc(startVertex, endVertex))
            return true;

        GraphVertex sVertex = findVertex(startVertex);
        GraphVertex eVertex = findVertex(endVertex);

        if ((sVertex == null) || (eVertex == null))
            return false;

        sVertex.addArc(eVertex, null); // asks start vertex to add an arc to the
                                       // end vertex with null weight

        return true;
    }

    /**
     * Delete the arc whose vertices names are startVertex and endVertex
     * for the beggining Vertex and ending Vertex respectively.
     * 
     * Returns true if the arc was deleted.
     */
    public boolean deleteArc(Object startVertex, Object endVertex) {
        if (!isArc(startVertex, endVertex))
            return false;

        //TODO null ?!
        GraphVertex sVertex = findVertex(startVertex);
        GraphVertex eVertex = findVertex(endVertex);

        // here we are certain the given arc exists
        sVertex.deleteArc(eVertex); // asks start vertex to delete the arc to
                                    // end vertex

        return true;
    }

    public boolean deleteAllArcsFrom(Object vertex) {
        GraphVertex v = findVertex(vertex);
        if (v == null)
            return false;

        v.deleteAllArcs();

        return true;
    }

    public boolean deleteAllArcsTo(Object vertex) {
        if (!isVertex(vertex))
            return false;

        int s = order();
        for (int i = 0; i < s; i++) {
            GraphVertex gv = (GraphVertex) graph.removeFirst();
            graph.insertLast(gv);
            Object gvName = gv.getName();
            deleteArc(gvName, vertex);
        }
        return true;
    }

    public int outDegreeOf(Object vertex) {
        GraphVertex v = findVertex(vertex);
        if (v == null)
            return -1;

        return v.outDegree();
    }

    public int inDegreeOf(Object vertex) {
        if (!isVertex(vertex))
            return -1;

        int count = 0;
        int s = order();
        // working with graph messes up the Vertex order.
        SimpleLinkedList cloneGraph = cloneGraph();
        for (int i = 0; i < s; i++) {
            GraphVertex gv = (GraphVertex) cloneGraph.removeFirst();
            cloneGraph.insertLast(gv);
            Object gvName = gv.getName();
            if (isArc(gvName, vertex))
                count++;
        }
        return count;
    }

    /**
     * <p>
     * Returns true if the given ordered pair (startVertex,endVertex) constitues
     * an existing arc in the graph
     * 
     * @param GraphVertex
     * @param GraphVertex
     *            </p>
     */
    public boolean isArc(Object startVertex, Object endVertex) {

        GraphVertex sVertex = findVertex(startVertex);
        GraphVertex eVertex = findVertex(endVertex);

        if ((sVertex == null) || (eVertex == null))
            return false;

        return sVertex.isArc(eVertex);
    }

    public UndirectedGraph toUndirected() {
        return null;
    }

    // PRIVATE METHODS
    private GraphVertex findVertex(Object vertex) {
        GraphVertex gv;
        int s = order();
        for (int i = 0; i < s; i++) {
            gv = (GraphVertex) graph.removeFirst();
            graph.insertLast(gv);
            if (gv.getName() == vertex)
                return gv;
        }
        return null;
    }

    // *******************PRIVATE INSTANCE FIELDS
    private SimpleLinkedList graph;
    
    //exercises
    
    @Override
    public String toString() {
        String str = ""; 
        GraphVertex gv;
        int s = order();
        for (int i = 0; i < s; i++) {
            gv = (GraphVertex) graph.removeFirst();
            graph.insertLast(gv);
            str += gv;
        }
        
        return str;
    }
    
    /**
     * Helper method for inDegreeOf
     * @return a copy of the graph
     */
    private SimpleLinkedList cloneGraph() {
        SimpleLinkedList list = new SimpleLinkedList();
        GraphVertex gv;
        int s = order();
        for (int i = 0; i < s; i++) {
            gv = (GraphVertex) graph.removeFirst();
            graph.insertLast(gv);
            list.insertLast(gv);
        }
        return list;
    }

    public int countSource() {
        GraphVertex gv; // a temp vertex
        int count = 0;
        int s = order();
        for (int i = 0; i < s; i++) {
            gv = (GraphVertex) graph.removeFirst();
            graph.insertLast(gv);
            if (gv.outDegree() > 0)
                count++;
        }
        return count;
    }

    public int countSink() {
        GraphVertex gv; // a temp vertex
        int count = 0;
        int s = order();
        for (int i = 0; i < s; i++) {
            gv = (GraphVertex) graph.removeFirst();
            graph.insertLast(gv);
            if (inDegreeOf(gv.getName()) > 0)
                count++;
        }
        return count;
    }

}
