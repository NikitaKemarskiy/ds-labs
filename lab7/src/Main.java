import com.graph.Graph;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scan = new Scanner(System.in);

        System.out.print("Which graph do you want to have? 1 - from lab; 2 - random: ");
        int option = scan.nextInt();

        switch (option) {
            case 1: {
                String[] vertices = new String[]{ // String array with vertices
                        "v",
                        "v0",
                        "v1",
                        "v2",
                        "v3",
                        "v4",
                        "v5",
                        "v6",
                        "v7",
                        "v8",
                        "v9",
                        "v10",
                        "v11",
                        "v12",
                        "v13",
                        "v14",
                        "v15",
                };
                graph.addVertex(vertices); // Fill the graph with the vertices

                // Fill the graph with the edges
                {
                    graph.addEdge("v", "v5", 2);
                    graph.addEdge("v", "v8", 3);
                    graph.addEdge("v", "v12", 9);
                    graph.addEdge("v", "v14", 1);
                    graph.addEdge("v0", "v1", 1);
                    graph.addEdge("v0", "v2", 3);
                    graph.addEdge("v0", "v3", 10);
                    graph.addEdge("v1", "v4", 5);
                    graph.addEdge("v1", "v9", 11);
                    graph.addEdge("v2", "v4", 8);
                    graph.addEdge("v2", "v11", 7);
                    graph.addEdge("v3", "v10", 5);
                    graph.addEdge("v4", "v5", 2);
                    graph.addEdge("v4", "v6", 5);
                    graph.addEdge("v4", "v10", 9);
                    graph.addEdge("v4", "v15", 3);
                    graph.addEdge("v5", "v7", 7);
                    graph.addEdge("v5", "v12", 8);
                    graph.addEdge("v5", "v13", 8);
                    graph.addEdge("v6", "v8", 4);
                    graph.addEdge("v6", "v10", 1);
                    graph.addEdge("v7", "v9", 8);
                    graph.addEdge("v7", "v11", 8);
                    graph.addEdge("v8", "v9", 9);
                    graph.addEdge("v8", "v12", 4);
                    graph.addEdge("v8", "v15", 5);
                    graph.addEdge("v9", "v12", 8);
                    graph.addEdge("v9", "v14", 2);
                    graph.addEdge("v10", "v11", 4);
                    graph.addEdge("v13", "v15", 1);
                }

                break;
            }
            case 2: {
                System.out.print("Input number of vertices: ");
                int size = scan.nextInt(); // Number of vertices
                String[] vertices = new String[size];
                int index = 0;
                while (graph.getSize() < size) {
                    String rand = random(4);
                    if (graph.hasVertex(rand)) { continue; }
                    graph.addVertex(rand);
                    vertices[index++] = rand;
                }
                for (int i = 0; i < index; i++) {
                    for (int j = 0; j < (Math.random() * 5); j++) {
                        int rand = -1;
                        do {
                            rand = (int) (Math.random() * index);
                        } while (rand == i);
                        graph.addEdge(vertices[i], vertices[rand], Math.random() * 100);
                    }
                }
                break;
            }
        }

        char ch = 0;
        do {
            System.out.print("What you want to do? 1 - Dijkstra; 2 - Floyd Warshall; 3 - Bellman Ford; 4 - adjacency matrix; q - quit: ");
            ch = scan.next().charAt(0);
            switch (ch) {
                case '1': { // Dijkstra
                    graph.dijkstra();
                    break;
                }
                case '2': { // Floyd Warshall
                    graph.floydWarshall();
                    break;
                }
                case '3': { // Bellman Ford
                    graph.bellmanFord();
                    break;
                }
                case '4': { // Adjacency matrix
                    graph.printMatrix();
                    break;
                }
                case 'q': { // Quit
                    break;
                }
                default: { // Invalid input
                    System.out.println("Invalid input: try again");
                    break;
                }
            }
        } while (ch != 'q');

        //System.out.println(graph.depthSearch("v"));
        //System.out.println(graph.widthSearch("v"));
    }

    private static String random(int size) {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += symbols.charAt((int)(Math.random() * symbols.length()));
        }
        return str;
    }

    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lower = upper.toLowerCase();
    private static final String digits = "0123456789";
    private static final String symbols = upper + lower + digits;
}
