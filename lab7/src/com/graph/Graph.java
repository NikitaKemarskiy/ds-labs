package com.graph;

import java.util.*;

public class Graph {
    // Private
    private String name;
    private Map<String, Vertex> vertices;

    private static String defaultName = "Graph";

    private void updateStatus() {
        for (Vertex vertex : vertices.values()) {
            vertex.setChecked(false);
        }
    }

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

    public String depthSearch(String name) {
        updateStatus();
        String str = depthBypass(name);
        for (Vertex vertex : vertices.values()) {
            if (vertex.isChecked()) { continue; }
            str += "\n" + depthBypass(vertex.getName());
        }
        return str;
    }

    public String widthSearch(String name) {
        updateStatus();

        Queue<Vertex> queue = new LinkedList<>();
        String str = "";

        queue.add(vertices.get(name));

        while (!queue.isEmpty()) {
            Vertex curr = queue.remove();
            curr.setChecked(true);
            String[] neighbours = curr.getNeighbours();
            for (String neighbour : neighbours) {
                if (vertices.get(neighbour).isChecked() || queue.contains(vertices.get(neighbour))) { continue; }
                queue.add(vertices.get(neighbour));
            }
            str += str.isEmpty() ? curr.getName() : "->" + curr.getName();
        }

        return str;
    }

    public String depthBypass(String name) {
        Vertex curr = vertices.get(name);
        String[] neighbours = curr.getNeighbours();

        String str = curr.getName();
        curr.setChecked(true);

        for (int i = 0; i < neighbours.length; i++) {
            Vertex neighbour = vertices.get(neighbours[i]);
            if (neighbour.isChecked()) { continue; }
            str += "->" + depthBypass(neighbours[i]);
        }
        return str;
    }

    public void printMatrix() { // Adjacency matrix
        String[] arr = new String[vertices.size()];
        int index = 0;
        for (String vertex : vertices.keySet()) {
            arr[index++] = vertex;
        }

        System.out.printf("%-7s", ""); // White space 7 symbols length
        for (int i = 0; i < arr.length; i++) { // First row which contains of all vertices names
            System.out.printf("%-7s", arr[i]);
        }
        System.out.println(); // New line
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-7s", arr[i]); // Current vertex name
            Vertex curr = vertices.get(arr[i]); // Get current vertex
            for (int j = 0; j < arr.length; j++) { // For every vertex
                double length = curr.getLength(arr[j]); // Length from current vertex to another vertex
                if (length == -1) { // There is no edge
                    System.out.printf("%-7s", "-"); // Print "-"
                    continue;
                }
                if (length % 1 == length) { // Length is integer
                    System.out.printf("%-7d", (int) length); // Print an integer value
                    continue;
                }
                System.out.printf("%-7.1f", length); // Print a double value
            }
            System.out.println(); // New line
        }
    }

    // Dijkstra algorithm implementation
    public void dijkstra() {
        //...
    }

    // Floyd Warshall algorithm implementation
    public void floydWarshall() {
        double[][] lengths = new double[vertices.size()][vertices.size()]; // Matrix of the shortest ways lengths
        String[][] ways = new String[vertices.size()][vertices.size()]; // Matrix of the ways
        Vertex[] arr = new Vertex[vertices.size()]; // Array with the vertices

        int index = 0;
        for (Vertex vertex : vertices.values()) { // Fill the array
            arr[index++] = vertex;
        }

        for (int i = 0; i < arr.length; i++) { // Fill the length and ways matrices
            Vertex curr = arr[i]; // Current vertex
            for (int j = 0; j < arr.length; j++) {
                lengths[i][j] = curr.getLength(arr[j].getName()); // Length from [i] to [j]
                if (lengths[i][j] >= 0) {
                    ways[i][j] = arr[j].getName(); // Way from [i] to [j]
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) { // Rows
                if (lengths[j][i] <= 0) { continue; }
                for (int k = 0; k < arr.length; k++) { // Columns
                    if (lengths[i][k] <= 0) { continue; }
                    if (lengths[j][k] == -1 || lengths[j][k] > lengths[j][i] + lengths[i][k]) {
                        lengths[j][k] = lengths[j][i] + lengths[i][k];
                        ways[j][k] = arr[i].getName();
                    }

                }
            }

        }
    }

    // Bellman Ford algorithm implementation
    public void bellmanFord() {
        //...
    }
}
