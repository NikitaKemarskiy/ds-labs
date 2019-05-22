package com.network;

public abstract class Arc {
    // Private
    protected Node from;
    protected Node to;
    protected int flow;
    protected int capacity;

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

    public abstract boolean hasAdditionalCapacity();
}

class ArcIn extends Arc {
    // Public
    public ArcIn(Node from, Node to, int capacity, int flow) {
        super(from, to, capacity, flow);
    }

    @Override
    public boolean hasAdditionalCapacity() {
        return flow < 0 ? true : false;
    }
}

class ArcOut extends Arc {
    // Public
    public ArcOut(Node from, Node to, int capacity, int flow) {
        super(from, to, capacity, flow);
    }

    @Override
    public boolean hasAdditionalCapacity() {
        return capacity - flow > 0 ? true : false;
    }
}