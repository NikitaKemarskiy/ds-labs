package com.huffman;

import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;

public class HuffmanTree {
    // Private
    private Node root;

    // Public
    public HuffmanTree(String str) {
        build(str);
    }

    public void build(String str) {
        FrequencyTable frequencyTable = new FrequencyTable(str);
        List<Entry> frequencyList = frequencyTable.getList();
        List<Node> frequencyNodeList = new LinkedList<>();

        for (Entry item : frequencyList) { // Fill frequencyNodeList with frequencyList content converting it into Nodes
            frequencyNodeList.add(new Node(item.getKey(), item.getValue()));
        }

        while (frequencyNodeList.size() > 1) {
            // Create new Node with new frequency
            Node node = new Node(frequencyNodeList.get(0).getValue() + frequencyNodeList.get(1).getValue());
            node.setLeft(frequencyNodeList.get(0)); // Set left child of the new Node
            node.setRight(frequencyNodeList.get(1)); // Set right child of the new Node
            frequencyNodeList = frequencyNodeList.subList(2, frequencyNodeList.size()); // Remove first two items of frequencyNodeList
            frequencyNodeList.add(node); // Add new item to the frequencyNodeList
            frequencyNodeList.sort(new Comparator<Node>() {
                @Override
                public int compare(Node node1, Node node2) {
                    return node1.compareTo(node2);
                }
            });
        }

        root = frequencyNodeList.size() == 1 ? frequencyNodeList.get(0) : null;
    }
}
