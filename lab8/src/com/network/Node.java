package com.network;

import java.util.HashMap;
import java.util.Map;

public class Node {
    // Private
    private Map<String, Arc> arcs;
    private String name;
    private boolean checked;

    // Initialization block
    {
        arcs = new HashMap<>();
    }

    // Public
    public Node(String name) {
        this.name = name;
    }

    public void addArc(Node to, int capacity, int flow) {
        if (arcs.containsKey(to.getName())) { return; }
        arcs.put(to.getName(), new Arc(this, to, capacity, flow));
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public Arc[] getArcs() {
        Arc[] arr = new Arc[arcs.size()];
        int index = 0;
        for (Arc arc : arcs.values()) {
            arr[index++] = arc;
        }
        return arr;
    }

    public Arc getArc(String to) {
        return arcs.get(to);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
