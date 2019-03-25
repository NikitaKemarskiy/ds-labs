package com.tree;

import com.exception.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    // Private
    private BinaryTreeItem root = null;

    static private void infix(BinaryTreeItem item, Queue queue) {
        if (item == null) {
            return;
        }
        infix(item.leftChild, queue);
        queue.add(item.getData());
        infix(item.rightChild, queue);
    }

    static private void prefix(BinaryTreeItem item, Queue queue) {
        if (item == null) {
            return;
        }
        queue.add(item.getData());
        prefix(item.leftChild, queue);
        prefix(item.rightChild, queue);
    }

    static private void postfix(BinaryTreeItem item, Queue queue) {
        if (item == null) {
            return;
        }
        postfix(item.leftChild, queue);
        postfix(item.rightChild, queue);
        queue.add(item.getData());
    }

    static private int balanceFactor(BinaryTreeItem item) {
        return height(item.getRightChild()) - height(item.getLeftChild());
    }

    static private int height(BinaryTreeItem item) {
        return item != null ? item.getHeight() : 0;
    }

    static private void fixHeight(BinaryTreeItem item) {
        int leftHeight = height(item.getLeftChild());
        int rightHeight = height(item.getRightChild());
        item.setHeight((leftHeight > rightHeight ? leftHeight : rightHeight) + 1);
    }

    // Public
    public BinaryTree() {}

    // Methods
    public void insert(int item) throws InvalidItemException { // Insert an item
        BinaryTreeItem curr = root;
        BinaryTreeItem parent = null;

        while (curr != null) {
            if (item == curr.getData()) {
                throw new InvalidItemException("Invalid item was passed.");
            }
            parent = curr;
            if (item < curr.getData()) {
                curr = curr.getLeftChild();
            } else {
                curr = curr.getRightChild();
            }
        }

        curr = new BinaryTreeItem(item, parent); // New BinaryTreeItem

        if (curr.hasParent()) { // Current has parent
            if (item < parent.getData()) { // Current is a left child
                parent.setLeftChild(curr);
            } else { // Current is a right child
                parent.setRightChild(curr);
            }
        } else { // Current has no parent
            root = curr; // Assign current as a root
        }

        int iterations = 1;

        /*while (parent != null) { // Increment heights of all the parental BinaryTreeItems
            iterations++;
            if (iterations > height(parent)) {
                parent.setHeight(height(parent) + 1);
            }
            balance(parent);
            parent = parent.getParent();
        }*/
    }

    public void delete(int item) { // Delete an item
        BinaryTreeItem curr = root;
        while (curr != null) {
            if (item == curr.getData()) { // Item was found
                if (!curr.hasLeftChild() && !curr.hasRightChild()) { // Current has no children
                    if (curr.hasParent()) {
                        BinaryTreeItem parent = curr.getParent();
                        if (parent.getLeftChild() == curr) { // Current is a left child of its parent
                            parent.setLeftChild(null);
                        } else { // Current is a right child of its parent
                            parent.setRightChild(null);
                        }
                        curr.setParent(null);
                    } else {
                        root = null;
                    }
                } else if (curr.hasLeftChild() && curr.hasRightChild()) { // Current has both children
                    BinaryTreeItem last = curr.getRightChild();
                    while (last.hasLeftChild()) {
                        last = last.getLeftChild();
                    }
                    int data = last.getData();
                    delete(data);
                    curr.setData(data);
                } else if (curr.hasLeftChild()) { // Current has only left child
                    if (curr.hasParent()) {
                        BinaryTreeItem parent = curr.getParent();
                        if (parent.getLeftChild() == curr) { // Current is a left child of its parent
                            parent.setLeftChild(curr.getLeftChild());
                        } else { // Current is a right child of its parent
                            parent.setRightChild(curr.getLeftChild());
                        }
                        curr.setParent(null);
                    } else {
                        root = curr.getLeftChild();
                    }
                    curr.setLeftChild(null);
                } else { // Current has only right child
                    if (curr.hasParent()) {
                        BinaryTreeItem parent = curr.getParent();
                        if (parent.getLeftChild() == curr) { // Current is a left child of its parent
                            parent.setLeftChild(curr.getRightChild());
                        } else { // Current is a right child of its parent
                            parent.setRightChild(curr.getRightChild());
                        }
                        curr.setParent(null);
                    } else {
                        root = curr.getRightChild();
                    }
                    curr.setRightChild(null);
                }
            }
            curr = item < curr.getData() ? curr.getLeftChild() : curr.getRightChild();
        }
    }

    public boolean search(int item) { // Search an item
        BinaryTreeItem curr = root;
        while (curr != null) {
            if (item == curr.getData()) {
                return true;
            }
            curr = item < curr.getData() ? curr.getLeftChild() : curr.getRightChild();
        }
        return false;
    }

    public Iterator<Integer> infixIterator() {
        Queue<Integer> queue = new LinkedList<>();
        infix(root, queue);
        return queue.iterator();
    }

    public Iterator<Integer> prefixIterator() {
        Queue<Integer> queue = new LinkedList<>();
        prefix(root, queue);
        return queue.iterator();
    }

    public Iterator<Integer> postfixIterator() {
        Queue<Integer> queue = new LinkedList<>();
        postfix(root, queue);
        return queue.iterator();
    }

    static BinaryTreeItem rotateRight(BinaryTreeItem item) {
        BinaryTreeItem leftChild = item.getLeftChild();
        item.setLeftChild(leftChild.getRightChild());
        leftChild.setRightChild(item);
        fixHeight(item);
        fixHeight(leftChild);
        return leftChild;
    }

    static BinaryTreeItem rotateLeft(BinaryTreeItem item) {
        BinaryTreeItem rightChild = item.getRightChild();
        item.setRightChild(rightChild.getLeftChild());
        rightChild.setLeftChild(item);
        fixHeight(item);
        fixHeight(rightChild);
        return rightChild;
    }

    static BinaryTreeItem balance(BinaryTreeItem item) {
        fixHeight(item);
        if (balanceFactor(item) == 2) {
            System.out.println("=> Balance item " + item.getData() + ", balanceFactor == 2");
            if (balanceFactor(item.getRightChild()) < 0) {
                item.setRightChild(rotateRight(item.getRightChild()));
            }
            return rotateLeft(item);
        }
        if (balanceFactor(item) == -2) {
            System.out.println("=> Balance item " + item.getData() + ", balanceFactor == 2");
            if (balanceFactor(item.getLeftChild()) > 0) {
                item.setLeftChild(rotateLeft(item.getLeftChild()));
            }
            return rotateRight(item);
        }
        return item; // Balance isn't needed
    }
}