package com.graph;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    // Private
    private String name;
    private Map<String, Edge> edges;

    // Initialization block
    {
        edges = new HashMap<>();
    }

    // Public
    public Vertex(String name) {
        this.name = name;
    }

    public void addEdge(Edge edge) {
        edges.put(edge.getTo().getName(), edge);
    }

    public String getName() {
        return name;
    }
}
