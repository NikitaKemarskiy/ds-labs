package com.queue;

class QueueItem {
    // Private
    int data;
    QueueItem next;
    QueueItem prev;

    // Public
    QueueItem() {
        data = 0;
        prev = null;
        next = null;
    }

    QueueItem(int data) {
        this.data = data;
        prev = null;
        next = null;
    }

    QueueItem(int data, QueueItem prev, QueueItem next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public void setPrev(QueueItem prev) {
        this.prev = prev;
    }

    public void setNext(QueueItem next) {
        this.next = next;
    }

    public QueueItem getNext() {
        return next;
    }

    public QueueItem getPrev() {
        return prev;
    }

    public int getData() {
        return data;
    }
}
