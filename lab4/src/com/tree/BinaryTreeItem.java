package com.tree;

public class BinaryTreeItem {
    // Private
    int data;
    int height = 1;
    BinaryTreeItem leftChild = null;
    BinaryTreeItem rightChild = null;

    // Public
    // Constructors
    BinaryTreeItem(int data) {
        this.data = data;
    }

    // Getters
    int getData() {
        return data;
    }

    int getHeight() { return height; }

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

    boolean hasLeftChild() {
        return leftChild == null ? false : true;
    }

    boolean hasRightChild() {
        return rightChild == null ? false : true;
    }
}
