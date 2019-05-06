import com.graph.Graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        String[] vertices = new String[] { // String array with vertices
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

        // Fill the graph with the vertices
        graph.addVertex(vertices);

        // Fill the graph with the edges
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

        //graph.printMatrix();
        //System.out.println(graph.depthSearch("v"));
        System.out.println(graph.widthSearch("v"));
    }
}
