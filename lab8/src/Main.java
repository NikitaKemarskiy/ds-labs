import com.graph.Graph;
import com.network.Arc;
import com.network.Network;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Max flow
        /*Network network = new Network();

        network.addNode("A");
        network.addNode("B");
        network.addNode("C");
        network.addNode("D");

        network.setSource("A");
        network.setTarget("D");

        network.addArc("A", "B", 1000, 0);
        network.addArc("A", "C", 1000, 0);
        network.addArc("B", "C", 1, 0);
        network.addArc("B", "D", 1000, 0);
        network.addArc("C", "D", 1000, 0);

        System.out.println(network.findMaxFlow());*/

        // Max matching
        /*Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("a", "D");
        graph.addEdge("a", "F");
        graph.addEdge("b", "F");
        graph.addEdge("c", "A");
        graph.addEdge("c", "F");
        graph.addEdge("d", "C");
        graph.addEdge("d", "D");
        graph.addEdge("d", "E");
        graph.addEdge("e", "B");
        graph.addEdge("e", "C");
        graph.addEdge("e", "F");
        graph.addEdge("f", "A");
        graph.addEdge("f", "D");
        graph.addEdge("f", "E");

        List<Arc> matching = graph.findMaxMatching();

        for (Arc arc : matching) {
            System.out.println(arc.getFrom() + " -> " + arc.getTo());
        }*/
    }
}
