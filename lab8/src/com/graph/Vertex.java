package com.graph;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    // Private
    private String name;
    private boolean checked;
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

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return checked;
    }

    public Vertex[] getVertices() {
        Vertex[] arr = new Vertex[edges.size()];
        int index = 0;
        for (Edge edge : edges.values()) {
            arr[index++] = edge.getTo();
        }
        return arr;
    }

    public Edge[] getEdges() {
        Edge[] arr = new Edge[edges.size()];
        int index = 0;
        for (Edge edge : edges.values()) {
            arr[index++] = edge;
        }
        return arr;
    }
}
