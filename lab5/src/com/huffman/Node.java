package com.huffman;

class Node implements Comparable<Node> {
    // Private
    private Node left;
    private Node right;
    private Character key;
    private int value;

    // Public
    Node(int value) {
        this.value = value;
    }

    Node(char key, int value) {
        this.key = key;
        this.value = value;
    }

    // Getters
    Node getLeft() {
        return left;
    }

    Node getRight() {
        return right;
    }

    Character getKey() {
        return key;
    }

    int getValue() {
        return value;
    }

    // Setters
    void setLeft(Node left) {
        this.left = left;
    }

    void setRight(Node right) {
        this.right = right;
    }

    // Methods
    boolean isLeaf() {
        return key != null ? true : false;
    }

    boolean hasLeft() {
        return left != null ? true : false;
    }

    boolean hasRight() {
        return right != null ? true : false;
    }

    public String toString() {
        return String.format("(%c; %d)", key, value);
    }

    @Override
    public int compareTo(Node other) {
        return value - other.value;
    }
}
