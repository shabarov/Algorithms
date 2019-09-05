package ru.shabarov.common.graph;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph<String> g = new Graph<>();
        g.addVertex("1");
        g.addVertex("2");
        g.addVertex("3");
        g.addVertex("4");
        g.addVertex("5");
        g.addVertex("6");
        g.addVertex("7");
        g.addEdge("1", "2");
        g.addEdge("2", "3");
        g.addEdge("2", "4");
        g.addEdge("4", "5");
        g.addEdge("4", "6");
        g.addEdge("1", "7");
        g.addEdge("7", "6");

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(g);
        depthFirstSearch.search("1");
        List<Graph.Vertex<String>> path = depthFirstSearch.path("1", "6");
        System.out.println("path = " + path);

        System.out.println("colors = " + depthFirstSearch.getColors());

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(g);
        breadthFirstSearch.search("1");
        System.out.println("breadthFirstSearch.getColors() = " + breadthFirstSearch.getColors());
        System.out.println("breadthFirstSearch.getDist() = " + breadthFirstSearch.getDist());
        System.out.println("breadthFirstSearch.getPred() = " + breadthFirstSearch.getPred());

    }
}
