package com.graph;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    // Private
    private String name;
    private boolean checked;
    private Map<String, Edge> vertices;

    // Initialization block
    {
        checked = false;
        vertices = new HashMap<>();
    }

    // Public
    public Vertex(String name) {
        this.name = name;
    }

    public void addEdge(Edge edge) {
        vertices.put(edge.getTo().getName(), edge);
    }

    public double getLength(String to) {
        return name.equals(to) ? 0 : vertices.get(to) == null ? -1 : vertices.get(to).getLength();
    }

    public String[] getNeighbours() {
        String[] arr = new String[vertices.size()];
        int index = 0;
        for (String vertex : vertices.keySet()) {
            arr[index++] = vertex;
        }
        return arr;
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
