import com.network.Network;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();

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

        System.out.println(network.findMaxFlow());
    }
}
