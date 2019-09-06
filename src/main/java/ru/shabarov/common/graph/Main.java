package ru.shabarov.common.graph;

import java.util.List;
import java.util.PriorityQueue;

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

        // Dijkstra's shortest search

        PriorityQueue<String> strings = new PriorityQueue<>();
        strings.add("a");
        strings.add("d");
        strings.add("b");
        strings.add("c");

        Graph<String> weightedGraph = new Graph<>();
        weightedGraph.addVertex("0");
        weightedGraph.addVertex("1");
        weightedGraph.addVertex("2");
        weightedGraph.addVertex("3");
        weightedGraph.addVertex("4");
        weightedGraph.addVertex("5");

        weightedGraph.addEdge("0", "1", 6);
        weightedGraph.addEdge("1", "4", 11);
        weightedGraph.addEdge("4", "5", 3);
        weightedGraph.addEdge("5", "3", 4);
        weightedGraph.addEdge("0", "3", 18);
        weightedGraph.addEdge("0", "2", 8);
        weightedGraph.addEdge("2", "3", 9);
        weightedGraph.addEdge("5", "2", 7);

        DijkstrasShortestPath dijkstrasShortestPath = new DijkstrasShortestPath(weightedGraph);
        dijkstrasShortestPath.search(new Graph.Vertex<>("0"));
        System.out.println("dijkstrasShortestPath.getDist() = " + dijkstrasShortestPath.getDist());
        System.out.println("dijkstrasShortestPath.getPred() = " + dijkstrasShortestPath.getPred());

        dijkstrasShortestPath.search(new Graph.Vertex<>("1"));
        System.out.println("dijkstrasShortestPath.getDist() = " + dijkstrasShortestPath.getDist());
        System.out.println("dijkstrasShortestPath.getPred() = " + dijkstrasShortestPath.getPred());

    }
}
