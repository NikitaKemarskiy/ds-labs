package com.graph;

import com.network.*;
import com.random.*;
import com.random.Random;

import java.util.*;

public class Graph {
    // Private
    private Map<String, Vertex> vertices;

    private Network toNetwork() {
        Network network = new Network();
        String source;
        String target;
        do {
            source = Random.randomString(10);
            target = Random.randomString(10);
        } while (vertices.containsKey(source) || vertices.containsKey(target));

        for (String vertex : vertices.keySet()) {
            network.addNode(vertex);
        }

        network.addNode(source);
        network.addNode(target);

        network.setSource(source);
        network.setTarget(target);

        // Проверка графа на двудольность, разделение вершин на два множества
        Map<String, Vertex> left = new HashMap<>();
        Map<String, Vertex> right = new HashMap<>();

        update();

        Queue<Vertex> queue = new LinkedList<>();

        queue.add(vertices.get(vertices.keySet().toArray()[0]));
        left.put(queue.peek().getName(), queue.peek());

        while (!queue.isEmpty()) {
            Vertex curr = queue.remove();
            curr.setChecked(true);
            Vertex[] neighbours = curr.getVertices();
            for (Vertex vertex : neighbours) {
                if ((left.containsKey(curr.getName()) && left.containsKey(vertex.getName())) || (right.containsKey(curr.getName()) && right.containsKey(vertex.getName()))) {
                    System.out.println("Error: Graph isn't bipartite");
                    return null;
                }
                if (vertex.isChecked() || queue.contains(vertex)) { continue; }
                if (!left.containsKey(vertex.getName()) && !right.containsKey(vertex.getName())) {
                    if (left.containsKey(curr.getName())) {
                        right.put(vertex.getName(), vertex);
                    } else {
                        left.put(vertex.getName(), vertex);
                    }
                }
                queue.add(vertex);
            }
        }

        for (Vertex vertex : left.values()) {
            Edge[] edges = vertex.getEdges();
            for (Edge edge : edges) {
                network.addArc(edge.getFrom().getName(), edge.getTo().getName(), 1, 0);
            }
            network.addArc(source, vertex.getName(), 1, 0);
        }

        for (Vertex vertex : right.values()) {
            network.addArc(vertex.getName(), target, 1, 0);
        }

        return network;
    }

    private void update() {
        for (Vertex vertex : vertices.values()) {
            vertex.setChecked(false);
        }
    }

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

    public List<Arc> findMaxMatching() {
        List<Arc> matching = new LinkedList<>();
        if (vertices.size() == 0) { return matching; }
        Network network = toNetwork();
        if (network == null) { return matching; }
        network.findMaxFlow();
        List<Arc> arcs = network.getArcs();
        for (Arc arc : arcs) {
            if (arc.getFrom().getName().equals(network.getSource()) || arc.getTo().getName().equals(network.getTarget()) || arc.getFlow() <= 0) {
                continue;
            }
            matching.add(arc);
        }
        return matching;
    }
}
