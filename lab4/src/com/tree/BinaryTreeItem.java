package com.tree;

class BinaryTreeItem {
    // Private
    int data;
    int height;
    BinaryTreeItem parent = null;
    BinaryTreeItem leftChild = null;
    BinaryTreeItem rightChild = null;

    // Public
    // Constructors
    BinaryTreeItem(int data, int height) {
        this.data = data;
        this.height = height;
    }

    BinaryTreeItem(int data, int height, BinaryTreeItem parent) {
        this.data = data;
        this.height = height;
        this.parent = parent;
    }

    BinaryTreeItem(int data, int height, BinaryTreeItem parent, BinaryTreeItem leftChild, BinaryTreeItem rightChild) {
        this.data = data;
        this.height = height;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    // Getters
    int getData() {
        return data;
    }

    int getHeight() { return height; }

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

    void setHeight(int height) { this.height = height; }

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
    int balanceFactor() {
        int rightHeight = this.rightChild != null ? this.rightChild.balanceFactor() : 0;
        int leftHeight = this.leftChild != null ? this.leftChild.balanceFactor() : 0;

        return rightHeight - leftHeight;
    }

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
