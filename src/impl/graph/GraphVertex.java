package impl.graph;

import impl.SimpleLinkedList;

/**
 * <p>
 * This class describes a graph vertex for use with both simple and weighted
 * graphs.
 * </p>
 * 
 * @version 3/12/2010
 */

public class GraphVertex {

    public GraphVertex(Object n) {
        this(n, null);
    }

    /**
     * 
     * @param n
     *            The name of the graph
     * @param w
     *            The weight of the graph
     */
    public GraphVertex(Object n, Object w) {
        arcList = new SimpleLinkedList();
        name = n;
        weight = w;
    }

    /**
     * 
     * @return A copy of arc list of the current vertex.
     */
    public SimpleLinkedList getArcList() {
        SimpleLinkedList listCopy = new SimpleLinkedList();
        int listSize = arcList.size();

        for (int i = 0; i < listSize; i++) {
            GraphArc gv = (GraphArc) arcList.removeFirst();
            arcList.insertLast(gv);
            listCopy.insertLast(gv);
        }
        return listCopy;
    }

    public int outDegree() {
        return arcList.size();
    }

    public Object getName() {
        return name;
    }

    public void setName(Object n) {
        name = n;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object w) {
        weight = w;
    }

    /**
     * 
     * @param end
     *            The end vertex
     * @param arcWeight
     *            Vertex weigth.
     */
    public void addArc(GraphVertex end, Object arcWeight) {
        GraphArc newArc = new GraphArc(end, arcWeight);
        arcList.insertLast(newArc);
    }

    /**
     * 
     * @param end
     *            The vertex to delete.
     * @return True if the vertex was found (and deleted).
     */
    public boolean deleteArc(GraphVertex end) {

        int s = arcList.size();
        for (int i = 0; i < s; i++) {
            GraphArc ga = (GraphArc) arcList.removeFirst();
            if (ga.getEndVertex().equals(end))
                return true; // if the end was found, return will prevent the
                             // insertion in the arcList
            arcList.insertLast(ga);
        }
        return false;
    }

    public void deleteAllArcs() {
        arcList = new SimpleLinkedList();
    }

    /**
     * Checks if there is an arc for a vertex.
     * 
     * @param end
     *            The vertex to check.
     * @return True if there is.
     */
    public boolean isArc(GraphVertex end) {
        int s = arcList.size();
        for (int i = 0; i < s; i++) {
            GraphArc ga = (GraphArc) arcList.removeFirst();
            arcList.insertLast(ga);
            if (ga.getEndVertex().equals(end))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Graph Vertex [ name : " + name + " ]\n";
    }

    // PRIVATE INSTANCE FIELDS
    private SimpleLinkedList arcList;
    private Object name, weight;
}