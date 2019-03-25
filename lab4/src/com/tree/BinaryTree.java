package com.tree;

import com.exception.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    // Private
    private BinaryTreeItem root = null;

    static private BinaryTreeItem insert(BinaryTreeItem curr, int item) {
        if (curr == null) {
            return new BinaryTreeItem(item);
        }
        if (item < curr.getData()) {
            curr.setLeftChild(insert(curr.getLeftChild(), item));
        } else {
            curr.setRightChild(insert(curr.getRightChild(), item));
        }
        return balance(curr);
    }

    static private BinaryTreeItem remove(BinaryTreeItem curr, int item) {
        if (curr == null) {
            return null;
        }
        if (item < curr.getData()) {
            curr.setLeftChild(remove(curr.getLeftChild(), item));
        } else if (item > curr.getData()) {
            curr.setRightChild(remove(curr.getRightChild(), item));
        } else {
            BinaryTreeItem leftChild = curr.getLeftChild();
            BinaryTreeItem rightChild = curr.getRightChild();
            if (rightChild == null) {
                return leftChild;
            }
            BinaryTreeItem min = findMin(rightChild);
            min.setRightChild(removeMin(rightChild));
            min.setLeftChild(leftChild);
            return balance(min);
        }
        return balance(curr);
    }

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

    static private BinaryTreeItem findMin(BinaryTreeItem item) {
        return item.hasLeftChild() ? findMin(item.getLeftChild()) : item;
    }

    static private BinaryTreeItem removeMin(BinaryTreeItem item) {
        if (!item.hasLeftChild()) {
            return item.getRightChild();
        }
        item.setLeftChild(removeMin(item.getLeftChild()));
        return balance(item);
    }

    // Public
    public BinaryTree() {}

    // Methods
    public void insert(int item) throws InvalidItemException {
        root = insert(root, item);
    }

    public void remove(int item) { // Delete an item
        remove(root, item);
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
        fixHeight(leftChild);
        fixHeight(item);
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
            if (balanceFactor(item.getRightChild()) < 0) {
                item.setRightChild(rotateRight(item.getRightChild()));
            }
            item = rotateLeft(item);
        } else if (balanceFactor(item) == -2) {
            if (balanceFactor(item.getLeftChild()) > 0) {
                item.setLeftChild(rotateLeft(item.getLeftChild()));
            }
            item = rotateRight(item);
        }
        return item; // Balance isn't needed
    }
}