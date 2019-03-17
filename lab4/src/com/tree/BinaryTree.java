package com.tree;

import com.exception.*;

public class BinaryTree {
    // Private
    private BinaryTreeItem root = null;

    // Public
    public BinaryTree() {}

    // Methods
    public void insert(int item) throws InvalidItemException { // Insert an item
        BinaryTreeItem curr = root;
        BinaryTreeItem parent = null;
        boolean isLeft = false;
        while (curr != null) {
            if (item == curr.getData()) {
                throw new InvalidItemException("Invalid item was passed.");
            }
            parent = curr;
            if (item < curr.getData()) {
                isLeft = true;
                curr = curr.getLeftChild();
            } else {
                isLeft = false;
                curr = curr.getRightChild();
            }
        }
        curr = new BinaryTreeItem(item, parent);
        if (curr.hasParent()) { // Current has parent
            if (isLeft) {
                parent.setLeftChild(curr);
            } else {
                parent.setRightChild(curr);
            }
        } else { // Current has no parent
            root = curr; // Assign current as a root
        }
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
}
