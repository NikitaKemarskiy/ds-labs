package com.graph;

import java.util.*;
import java.util.Map.*;

public class Graph {
    // Private
    private Map<String, Vertex> vertices;

    // Initialization block
    {
        vertices = new LinkedHashMap<>();
    }

    // Public
    public void addVertex(String name) {
        vertices.put(name, new Vertex(name));
    }

    public void addVertex(String[] names) {
        for (String name : names) {
            vertices.put(name, new Vertex(name));
        }
    }

    public void addEdge(String fromName, String toName) {
        Vertex from = vertices.get(fromName);
        Vertex to = vertices.get(toName);
        if (from == null || to == null) { return; }
        Edge edge1 = new Edge(from, to);
        Edge edge2 = new Edge(to, from);
        from.addEdge(edge1);
        to.addEdge(edge2);
    }

    public int findMaxMatching() {
        return 0;
    }
}
