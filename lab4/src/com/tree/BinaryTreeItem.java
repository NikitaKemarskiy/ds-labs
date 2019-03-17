package com.tree;

class BinaryTreeItem {
    // Private
    int data;
    BinaryTreeItem parent = null;
    BinaryTreeItem leftChild = null;
    BinaryTreeItem rightChild = null;

    // Public
    // Constructors
    BinaryTreeItem(int data) {
        this.data = data;
    }

    BinaryTreeItem(int data, BinaryTreeItem parent) {
        this.data = data;
        this.parent = parent;
    }

    BinaryTreeItem(int data, BinaryTreeItem parent, BinaryTreeItem leftChild, BinaryTreeItem rightChild) {
        this.data = data;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    // Getters
    int getData() {
        return data;
    }

    BinaryTreeItem getParent() {
        return parent;
    }

    BinaryTreeItem getLeftChild() {
        return leftChild;
    }

    BinaryTreeItem getRightChild() {
        return rightChild;
    }

    // Setters
    void setData(int data) {
        this.data = data;
    }

    void setParent(BinaryTreeItem parent) {
        this.parent = parent;
    }

    void setLeftChild(BinaryTreeItem leftChild) {
        this.leftChild = leftChild;
    }

    void setRightChild(BinaryTreeItem rightChild) {
        this.rightChild = rightChild;
    }

    // Methods
    boolean hasParent() {
        return parent == null ? false : true;
    }

    boolean hasLeftChild() {
        return leftChild == null ? false : true;
    }

    boolean hasRightChild() {
        return rightChild == null ? false : true;
    }
}
