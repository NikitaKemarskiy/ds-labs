package com.queue;

class QueuePriorityItem extends QueueItem {
    // Private
    private int priority;

    // Public
    QueuePriorityItem(int data, int priority) {
        super(data);
        this.priority = priority;
    }

    QueuePriorityItem(int data, int priority, QueueItem prev, QueueItem next) {
        super(data, prev, next);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
