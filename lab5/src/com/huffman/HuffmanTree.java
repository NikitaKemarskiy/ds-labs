package com.huffman;

import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class HuffmanTree {
    // Private
    private Node root;
    private Map<Character, String> table;
    private int weight;

    private void buildTable() { // Build table method
        table = new HashMap<>();
        weight = 0;
        if (root != null) {
            addToTable(root, "");
        }
    }

    private void addToTable(Node node, String path) { // Add character to table method
        if (node.hasLeft()) {
            addToTable(node.getLeft(), path + "0");
        }
        if (node.isLeaf()) {
            table.put(node.getKey(), path);
            weight += node.getValue() * path.length(); // Increase weight
        }
        if (node.hasRight()) {
            addToTable(node.getRight(), path + "1");
        }
    }

    // Public
    public HuffmanTree(String str) {
        build(str);
    }

    // Getters
    public int getWeight() {
        return weight;
    }

    public Map getTable() {
        return table;
    }

    // Methods
    public void build(String str) { // Build tree method
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
        buildTable();
    }

    public String encode(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += encode(str.charAt(i));
        }
        return result;
    }

    public String encode(Character ch) {
        return table.get(ch);
    }

    public String decode(String str) {
        Node curr = root;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            curr = str.charAt(i) == '0' ? curr.getLeft() : curr.getRight();
            if (curr.isLeaf()) {
                result += curr.getKey();
                curr = root;
            }
        }
        return result;
    }

    public String infix() { // Infix method
        String str = "[";
        if (root != null) {
            str += infix(root, "");
            str = str.substring(0, str.length() - 1);
            str += " ";
        }
        str += "]";
        return str;
    }

    public String infix(Node node, String path) { // Infix method with specified Node
        String str = "";
        if (node.hasLeft()) {
            str += infix(node.getLeft(), path + "0");
        }
        if (node.isLeaf()) {
            str += String.format(" (%c; %s),", node.getKey(), path);
        }
        if (node.hasRight()) {
            str += infix(node.getRight(), path + "1");
        }
        return str;
    }
}
