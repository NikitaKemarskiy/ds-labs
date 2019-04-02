package com.huffman;

class Node {
    // Private
    Node left;
    Node right;

    // Public
    Node() {}

    // Getters
    Node getLeft() {
        return left;
    }

    Node getRight() {
        return right;
    }

    // Setters
    void setLeft(Node left) {
        this.left = left;
    }

    void setRight(Node right) {
        this.right = right;
    }
}
