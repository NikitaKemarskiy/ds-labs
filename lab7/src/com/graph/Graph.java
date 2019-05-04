package com.graph;

import java.util.*;

public class Graph {
    // Private
    private String name;
    private Map<String, Vertex> vertices;

    private static String defaultName = "Graph";


    // Initialization block
    {
        vertices = new LinkedHashMap<>();
    }

    // Public
    public Graph() {
        name = defaultName;
    }

    public Graph(String name) {
        this.name = name;
    }

    public void addVertex(String name) {
        vertices.put(name, new Vertex(name));
    }

    public void addVertex(String[] names) {
        for (String name : names) {
            vertices.put(name, new Vertex(name));
        }
    }

    public void addEdge(String fromName, String toName, double length) {
        addEdge(fromName, toName, length, false);
    }

    public void addEdge(String fromName, String toName, double length, boolean oriented) {
        Vertex from = vertices.get(fromName);
        Vertex to = vertices.get(toName);
        if (from == null || to == null) { return; }
        if (oriented) {
            Edge edge = new Edge(from, to, length);
            from.addEdge(edge);
        } else {
            Edge edge1 = new Edge(from, to, length);
            Edge edge2 = new Edge(to, from, length);
            from.addEdge(edge1);
            to.addEdge(edge2);
        }
    }

    public void printMatrix() { // Adjacency matrix
        String[] arr = new String[vertices.size()];
        int index = 0;
        for (String vertex : vertices.keySet()) {
            arr[index++] = vertex;
        }

        System.out.printf("%-12s", ""); // White space 12 symbols length
        for (int i = 0; i < arr.length; i++) { // First row which contains of all vertices names
            System.out.printf("%-12s", arr[i]);
        }
        System.out.println(); // New line
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-12s", arr[i]); // Current vertex name
            Vertex curr = vertices.get(arr[i]); // Get current vertex
            for (int j = 0; j < arr.length; j++) { // For every vertex
                double length = curr.getLength(arr[j]); // Length from current vertex to another vertex
                if (length == -1) { // There is no edge
                    System.out.printf("%-12s", "-"); // Print "-"
                    continue;
                }
                if (length % 1 == length) { // Length is integer
                    System.out.printf("%-12d", (int) length); // Print an integer value
                    continue;
                }
                System.out.printf("%-12.1f", length); // Print a double value
            }
            System.out.println(); // New line
        }
    }
}
