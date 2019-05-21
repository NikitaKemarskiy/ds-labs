package com.network;

import static java.lang.Math.abs;

public class Arc {
    // Private
    private Node from;
    private Node to;
    private int flow;
    private int capacity;

    // Public
    public Arc(Node from, Node to, int capacity, int flow) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = flow;
    }

    public void addFlow(int flow) {
        if (this.flow + flow > capacity) { return; }
        this.flow += flow;
    }

    public void removeFlow(int flow) {
        if (this.flow - flow < (-1) * capacity) { return; }
        this.flow -= flow;
    }

    // Getters
    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public int getFlow() {
        return flow;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasAdditionalCapacity() {
        return flow < 0 ? true : capacity - flow > 0 ? true : false;
    }
}
