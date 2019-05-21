package com.network;

import java.util.*;

import static java.lang.Math.abs;

public class Network {
    // Private
    private Map<String, Node> nodes;
    private Node source;
    private Node target;

    private void update() {
        for (Node node : nodes.values()) {
            node.setChecked(false);
        }
    }

    private int findMinFlow(Queue<Node> path) {
        int min = Integer.MAX_VALUE;
        while (path.size() > 1) {
            Node from = path.remove();
            Node to = path.peek();
            int additionalFlow;
            if (from.getArc(to.getName()).getFlow() >= 0) {
                additionalFlow = from.getArc(to.getName()).getCapacity() - from.getArc(to.getName()).getFlow();
            } else {
                additionalFlow = abs(from.getArc(to.getName()).getFlow());
            }
            if (additionalFlow < min) {
                min = additionalFlow;
            }
        }
        return min;
    }

    private void addFlow(Queue<Node> path, int flow) {
        while (path.size() > 1) {
            Node from = path.remove();
            Node to = path.peek();
            if (from.getArc(to.getName()).getFlow() >= 0) { // Flow is positive
                from.getArc(to.getName()).addFlow(flow);
                to.getArc(from.getName()).removeFlow(flow);
            } else { // Flow is negative
                from.getArc(to.getName()).removeFlow(flow);
                to.getArc(from.getName()).addFlow(flow);
            }
        }
    }

    // Initialization block
    {
        nodes = new HashMap<>();
    }

    // Public
    public void addNode(String name) {
        if (nodes.containsKey(name)) { return; }
        nodes.put(name, new Node(name));
    }

    public void addArc(String from, String to, int capacity, int flow) {
        if (!nodes.containsKey(from) || !nodes.containsKey(to)) { return; }
        nodes.get(from).addArc(nodes.get(to), capacity, flow);
        nodes.get(to).addArc(nodes.get(from), capacity, (-1) * flow);
    }

    public void setSource(String name) {
        if (!nodes.containsKey(name)) { return; }
        source = nodes.get(name);
    }

    public void setTarget(String name) {
        if (!nodes.containsKey(name)) { return; }
        target = nodes.get(name);
    }

    public int findMaxFlow() {
        if (source == null || target == null) { return 0; }

        int flow = 0;
        Node curr = source;
        Queue<Node> path = new LinkedList<>();

        update(); // Make all nodes unchecked

        while (true) {
            path.add(curr);
            Node next = null;
            for (Arc arc : curr.getArcs()) {
                if (!arc.getTo().isChecked() && arc.hasAdditionalCapacity()) {
                    next = arc.getTo();
                    break;
                }
            }
            if (next == null) { // There's no appropriate next node
                ((LinkedList<Node>) path).removeLast(); // Remove last node from the path queue
                if (path.size() == 0) { break; } // Path queue is empty - break from the loop
                curr.setChecked(true); // Set curr as a checked
                curr = ((LinkedList<Node>) path).getLast(); // Set last node in the path as curr
                ((LinkedList<Node>) path).removeLast(); // Remove last node in the path (curr will be added in the next iteration)
                continue; // Continue the loop
            }
            curr.setChecked(true); // Set curr as a checked
            curr = next; // Set next as a curr
            if (curr == target) { // Curr is a target
                path.add(target);
                int min = findMinFlow((Queue)(((LinkedList) path).clone()));
                addFlow((Queue)(((LinkedList) path).clone()), min);
                path.clear(); // Clear the path queue
                update(); // Make all nodes unchecked
                curr = source; // Set source as a curr
            }
        }

        for (Arc arc : source.getArcs()) {
            if (arc.getFlow() < 0) { continue; }
            flow += arc.getFlow();
        }

        return flow;
    }
}
