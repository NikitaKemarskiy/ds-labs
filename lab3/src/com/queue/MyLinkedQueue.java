package com.queue;

import com.exception.EmptyQueueException;
import com.exception.InvalidIndexException;

public class MyLinkedQueue implements MyQueue {
    // Private

    private QueueItem front;
    private QueueItem back;
    private int size = 0;

    // Constructors
    public MyLinkedQueue() {
        front = null;
        back = null;
    }

    // Public
    public void push(int item) { // Вставка элемента в конец очереди
        size++;
        if (front == null) {
            front = new QueueItem(item);
            back = front;
            return;
        }
        QueueItem prev = back;
        back = new QueueItem(item, prev, null);
        prev.setNext(back);
    }

    public int pop() throws EmptyQueueException { // Удаление элемента в начале очереди
        if (front == null) {
            throw new EmptyQueueException("Error: queue is already empty.");
        } else {
            size--;
            int data = front.getData();
            QueueItem next = front.getNext();
            front.setNext(null);
            front = next;
            if (next == null) { // Очередь уже пуста
                back = null;
                return data;
            }
            front.setPrev(null);
            return data;
        }
    }

    public int back() throws EmptyQueueException { // Возврат конца очереди без удаления
        return back.getData();
    }

    public int front() throws EmptyQueueException { // Возврат начала очереди без удаления
        return front.getData();
    }

    public int size() { // Возврат размера очереди
        return size;
    }

    public void clear() { // Очистка очереди
        QueueItem item = front;
        front = null;
        back = null;
        size = 0;
        while (item != null) {
            QueueItem buff = item;
            item = item.getNext();
            buff.setPrev(null);
            buff.setNext(null);
        }
    }

    public boolean isEmpty() { // Проверка пуста ли очередь
        return (size <= 0);
    }

    public int valueOf(int index) throws InvalidIndexException {
        QueueItem item = front;
        while (index > 0) {
            item = item.getNext();
            if (item == null) {
                throw new InvalidIndexException("Error: invalid exception was passed.");
            }
            index--;
        }
        return item.getData();
    }

    public void randomFill(int n) {
        for (int i = 0; i < n; i++) {
            this.push((int)(Math.random() * 100));
        }
    }

    public String toString() { // Привести очередь к строке
        String str = "["; // Открываем массив в строке
        QueueItem item = front;

        while (item != back) {
            str += item.getData() + ", "; // Добавляем помимо элемента запятую с пробелом в конце
            item = item.getNext();
        }

        if (item != null) {
            str += item.getData();
        }

        str += "]"; // Закрываем массив в строке

        return str;
    }
}

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

