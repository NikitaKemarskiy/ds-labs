package com.graph;

public class Edge {
    // Private
    private Vertex from;
    private Vertex to;

    // Public
    public Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }
}
