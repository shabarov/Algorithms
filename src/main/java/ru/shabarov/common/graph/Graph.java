package ru.shabarov.common.graph;

import java.util.*;

class Graph<T> {

    private Map<Vertex<T>, List<Vertex<T>>> adjacencyVertices = new HashMap<>();

    void addVertex(T label) {
        adjacencyVertices.putIfAbsent(new Vertex<T>(label), new ArrayList<>());
    }

    void removeVertex(T label) {
        Vertex v = new Vertex<T>(label);
        adjacencyVertices.values().forEach(e -> e.remove(v));
        adjacencyVertices.remove(new Vertex<T>(label));
    }

    void addEdge(T label1, T label2) {
        Vertex<T> v1 = new Vertex<T>(label1);
        Vertex<T> v2 = new Vertex<T>(label2);
        adjacencyVertices.get(v1).add(v2);
        adjacencyVertices.get(v2).add(v1);
    }

    void removeEdge(T label1, T label2) {
        Vertex v1 = new Vertex<T>(label1);
        Vertex v2 = new Vertex<T>(label2);
        List<Vertex<T>> eV1 = adjacencyVertices.get(v1);
        List<Vertex<T>> eV2 = adjacencyVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    List<Vertex<T>> getAdjVertices(T label) {
        return getAdjVertices(new Vertex<T>(label));
    }

    List<Vertex<T>> getAdjVertices(Vertex<T> v) {
        return adjacencyVertices.get(v);
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
}
