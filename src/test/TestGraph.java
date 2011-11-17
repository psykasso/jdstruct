package test;

import impl.graph.GraphVertex;
import impl.graph.SimpleDirectedGraph;

public class TestGraph {
    public static void main(String[] args) {
        SimpleDirectedGraph graph = new SimpleDirectedGraph();
        
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        
        graph.addArc(1, 2);
        graph.addArc(1, 3);
        graph.addArc(1, 4);
        graph.addArc(2, 4);
        graph.addArc(3, 4);
        graph.addArc(3, 5);
        
        
        //System.out.println(graph.graphSize());
        System.out.println(graph.inDegreeOf(5));
        
    }
}
