package ru.shabarov.common.graph;

import com.google.common.base.Preconditions;

import java.util.*;
import java.util.stream.Collectors;

class Graph<T> {

    private Map<Vertex<T>, List<Edge<T>>> adjacencyVertices = new HashMap<>();

    void addVertex(T label) {
        Preconditions.checkArgument(label != null);
        adjacencyVertices.putIfAbsent(new Vertex<T>(label), new ArrayList<>());
    }

    void removeVertex(T label) {
        Vertex<T> v = new Vertex<T>(label);
        adjacencyVertices.values().forEach(eList -> eList.removeIf(e -> e.getVertex().equals(v)));
        adjacencyVertices.remove(v);
    }

    void addEdge(T label1, T label2, int weight) {
        Vertex<T> v1 = new Vertex<T>(label1);
        Vertex<T> v2 = new Vertex<T>(label2);
        adjacencyVertices.get(v1).add(new Edge<>(v2, weight));
    }

    void addEdge(T label1, T label2) {
        Vertex<T> v1 = new Vertex<T>(label1);
        Vertex<T> v2 = new Vertex<T>(label2);
        adjacencyVertices.get(v1).add(new Edge<>(v2, 0));
        adjacencyVertices.get(v2).add(new Edge<>(v1, 0));
    }

    void removeEdge(T label1, T label2) {
        Vertex v1 = new Vertex<T>(label1);
        Vertex v2 = new Vertex<T>(label2);
        List<Edge<T>> eV1 = adjacencyVertices.get(v1);
        List<Edge<T>> eV2 = adjacencyVertices.get(v2);
        if (eV1 != null)
            eV1.removeIf(e -> e.getVertex().equals(v2));
        if (eV2 != null)
            eV2.removeIf(e -> e.getVertex().equals(v1));
    }

    List<Vertex<T>> getAdjVertices(T label) {
        return getAdjVertices(new Vertex<T>(label));
    }

    List<Vertex<T>> getAdjVertices(Vertex<T> v) {
        return adjacencyVertices.get(v).stream().map(Edge::getVertex).collect(Collectors.toList());
    }

    Optional<Edge<T>> getWeightedAdjVertices(Vertex<T> from, Vertex<T> to) {
        return adjacencyVertices.get(from).stream().filter(e -> e.getVertex().equals(to)).findFirst();
    }

    Set<Vertex<T>> getVertices() {
        return adjacencyVertices.keySet();
    }

    static class Vertex<T> {

        T label;

        Vertex(T label) {
            this.label = label;
        }

        T getLabel() {
            return label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex<?> vertex = (Vertex<?>) o;
            return label.equals(vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "label=" + label +
                    '}';
        }

        static <T> Vertex<T> fromLabel(T label) {
            return new Vertex<T>(label);
        }
    }

    static class PriorityVertex<T> implements Comparable<PriorityVertex<T>> {

        private int priority;
        private Vertex<T> vertex;

        PriorityVertex(Vertex<T> vertex, int priority) {
            this.vertex = vertex;
            this.priority = priority;
        }

        PriorityVertex(T label, int priority) {
            this(new Vertex<>(label), priority);
        }

        Vertex<T> getVertex() {
            return vertex;
        }

        int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(PriorityVertex<T> o) {
            return Integer.compare(this.priority, o.getPriority());
        }
    }

    static class Edge<T> {
        private Vertex<T> vertex;
        private int weight;

        Edge(Vertex<T> vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        Vertex<T> getVertex() {
            return vertex;
        }

        int getWeight() {
            return weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge<?> edge = (Edge<?>) o;
            return weight == edge.weight &&
                    vertex.equals(edge.vertex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertex, weight);
        }
    }
}
