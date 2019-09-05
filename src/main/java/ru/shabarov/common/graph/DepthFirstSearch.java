package ru.shabarov.common.graph;

import java.util.*;

class DepthFirstSearch {

    private Graph<String> graph;

    private Map<Graph.Vertex<String>, Graph.Vertex<String>> pred = new HashMap<>();

    private Map<Graph.Vertex<String>, VertexColor> colors = new HashMap<>();

    DepthFirstSearch(Graph<String> graph) {
        this.graph = graph;
    }

    void search(String first) {
        this.graph.getVertices().forEach(v -> this.colors.put(v, VertexColor.WHITE));
        visit(new Graph.Vertex<>(first));
    }

    List<Graph.Vertex<String>> path(String from, String to) {
        Graph.Vertex<String> current = new Graph.Vertex<>(to);

        LinkedList<Graph.Vertex<String>> result = new LinkedList<>();
        result.addFirst(current);

        Graph.Vertex<String> fromVertex = new Graph.Vertex<>(from);
        while (!current.equals(fromVertex)) {
            current = this.pred.get(current);
            result.addFirst(Graph.Vertex.fromLabel(current.getLabel()));
        }

        return result;
    }

    Map<Graph.Vertex<String>, VertexColor> getColors() {
        return this.colors;
    }

    private void visit(Graph.Vertex<String> u) {
        this.colors.put(u, VertexColor.GRAY);
        this.graph.getAdjVertices(u).forEach(v -> {
            if (this.colors.get(v).equals(VertexColor.WHITE)) {
                this.pred.put(v, u);
                visit(v);
            }
        });
        this.colors.put(u, VertexColor.BLACK);
    }
}
