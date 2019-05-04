package com.graph;

public class Edge {
    // Private
    private Vertex from;
    private Vertex to;
    private double length;

    // Public
    public Edge(Vertex from, Vertex to, double length) {
        this.from = from;
        this.to = to;
        this.length = length;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }

    public double getLength() {
        return length;
    }
}
