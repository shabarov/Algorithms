package ru.shabarov.common.graph;

import java.util.*;

class DijkstrasShortestPath {
    
    private Map<Graph.Vertex<String>, Graph.Vertex<String>> pred = new HashMap<>();
    private Map<Graph.Vertex<String>, Integer> dist = new HashMap<>();
    private Graph<String> graph;

    DijkstrasShortestPath(Graph<String> graph) {
        this.graph = graph;
    }

    void search(Graph.Vertex<String> first) {
        this.dist.clear();
        this.pred.clear();
        PriorityQueue<Graph.PriorityVertex<String>> pq = new PriorityQueue<>();

        this.graph.getVertices().forEach(v -> {
            int dist = v.equals(first) ? 0 : Integer.MAX_VALUE;
            this.dist.put(v, dist);
            pq.add(new Graph.PriorityVertex<>(v, dist));
        });

        while (!pq.isEmpty()) {
            Graph.Vertex<String> u = pq.remove().getVertex();
            this.graph.getAdjVertices(u).forEach(v -> {
                Optional<Graph.Edge<String>> edge = this.graph.getWeightedAdjVertices(u, v);
                int w = edge.orElseThrow(
                        () -> new IllegalStateException(String.format("No edge found between %s and %s", u, v))).getWeight();
                int newLength = this.dist.get(u) + w;
                newLength = newLength < 0 ? Integer.MAX_VALUE : newLength;
                if (newLength < this.dist.get(v)) {
                    pq.add(new Graph.PriorityVertex<>(v, newLength));
                    this.dist.put(v, newLength);
                    this.pred.put(v, u);
                }
            });
        }
    }

    Map<Graph.Vertex<String>, Graph.Vertex<String>> getPred() {
        return pred;
    }

    Map<Graph.Vertex<String>, Integer> getDist() {
        return dist;
    }
}
