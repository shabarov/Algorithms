package ru.shabarov.common.graph;

import java.util.*;

/**
 * Complexity: O(V + E)
 *
 * Space: 0(V) for queue, colors, dist, pred
 *
 * Usage: for non-ordered graphs, find shortest path to nodes
 */
class BreadthFirstSearch {

    private Graph<String> graph;

    private Map<Graph.Vertex<String>, Graph.Vertex<String>> pred = new HashMap<>();

    private Map<Graph.Vertex<String>, VertexColor> colors = new HashMap<>();

    private Map<Graph.Vertex<String>, Integer> dist = new HashMap<>();

    BreadthFirstSearch(Graph<String> graph) {
        this.graph = graph;
    }

    void search(String first) {
        Graph.Vertex<String> firstVertex = Graph.Vertex.fromLabel(first);
        this.graph.getVertices().forEach(v -> {
            this.dist.put(v, Integer.MAX_VALUE);
            this.colors.put(v, VertexColor.WHITE);
        });
        this.colors.put(firstVertex, VertexColor.GRAY);
        this.dist.put(firstVertex, 0);
        Deque<Graph.Vertex<String>> q = new LinkedList<>();
        q.add(firstVertex);

        while (!q.isEmpty()) {
            Graph.Vertex<String> u = q.getLast();
            this.graph.getAdjVertices(u).forEach(v -> {
                if (this.colors.get(v).equals(VertexColor.WHITE)) {
                    this.dist.put(v, dist.get(u) + 1);
                    this.pred.put(v, u);
                    this.colors.put(v, VertexColor.GRAY);
                    q.addFirst(v);
                }
            });
            q.pollLast();
            this.colors.put(u, VertexColor.BLACK);
        }
    }

    Map<Graph.Vertex<String>, Graph.Vertex<String>> getPred() {
        return pred;
    }

    Map<Graph.Vertex<String>, VertexColor> getColors() {
        return colors;
    }

    Map<Graph.Vertex<String>, Integer> getDist() {
        return dist;
    }
}
