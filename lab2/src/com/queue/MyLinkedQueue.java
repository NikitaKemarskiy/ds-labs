package com.queue;

// Мои классы
import com.exception.*;

// Классы Java
import java.lang.Math;


public class MyLinkedQueue implements MyQueue {
    // Private
    private int size = 0;
    private QueueItem back = null;
    private QueueItem front = null;

    // Public
    public MyLinkedQueue() { // Конструктор по умолчанию
    }

    public void push_back(int item) { // Вставка элемента в конец очереди
        if (back == null) {
            back = new QueueItem(item);
            front = back;
        } else {
            QueueItem newItem = new QueueItem(item, back, null);
            back.setNext(newItem);
            back = newItem;
        }
        size++;
    }

    public void push_front(int item) { // Вставка элемента в начало очереди
        if (front == null) {
            front = new QueueItem(item);
            back = front;
        } else {
            QueueItem newItem = new QueueItem(item, null, front);
            front.setPrev(newItem);
            front = newItem;
        }
        size++;
    }

    public int pop_back() throws EmptyQueueException { // Удаление элемента в конце очереди
        if (back == null) {
            throw new EmptyQueueException("Queue is already empty.");
        }
        QueueItem oldItem = back;
        back = back.getPrev();
        if (back != null) {
            back.setNext(null);
            oldItem.setPrev(null);
        } else {
            front = null;
        }
        size--;
        return oldItem.getData();
    }

    public int pop_front() throws EmptyQueueException { // Удаление элемента в начале очереди
        if (front == null) {
            throw new EmptyQueueException("Queue is already empty.");
        }
        QueueItem oldItem = front;
        front = front.getNext();
        if (front != null) {
            front.setPrev(null);
            oldItem.setNext(null);
        } else {
            back = null;
        }
        size--;
        return oldItem.getData();
    }

    public int back() throws EmptyQueueException { // Возврат конца очереди без удаления
        if (back == null) {
            throw new EmptyQueueException("Queue is already empty.");
        }
        return back.getData();
    }

    public int front() throws EmptyQueueException { // Возврат начала очереди без удаления
        if (front == null) {
            throw new EmptyQueueException("Queue is already empty.");
        }
        return front.getData();
    }

    public int size() { // Возврат размера очереди
        return size;
    }

    public void clear() { // Очистка очереди
        QueueItem current = front;
        front = null;
        back = null;
        size = 0;

        while (current != null) {
            QueueItem buffer = current;
            current = current.getNext();
            buffer.setNext(null);
            if (current != null) {
                current.setPrev(null);
            }
        }
    }

    public boolean isEmpty() { // Проверка пуста ли очередь
        return size > 0 ? false : true;
    }

    public int indexOf(int item) {
        MyLinkedQueue buffer = new MyLinkedQueue();
        int index = -1;
        int currentIndex = 0;

        while (!this.isEmpty()) {
            try {
                if (this.front() == item) {
                    index = currentIndex;
                    break;
                }
                buffer.push_back(this.pop_front());
                currentIndex++;
            } catch (EmptyQueueException err) {
                System.out.println(err.getMessage());
                break;
            }
        }

        while (!buffer.isEmpty()) {
            try {
                this.push_front(buffer.pop_back());
            } catch (EmptyQueueException err) {
                System.out.println(err.getMessage());
                break;
            }
        }

        return index;
    }

    public int valueOf(int index) throws InvalidIndexException {
        if (index >= size || index < 0) {
            throw new InvalidIndexException("Invalid index was passed.");
        }
        MyLinkedQueue buffer = new MyLinkedQueue();

        for (int i = 0; i < index; i++) {
            try {
                buffer.push_back(this.pop_front());
            } catch (EmptyQueueException err) {
                throw new InvalidIndexException("Invalid index was passed");
            }
        }

        int val = this.front.getData();

        while (!buffer.isEmpty()) {
            try {
                this.push_front(buffer.pop_back());
            } catch (EmptyQueueException err) {
                throw new InvalidIndexException("Invalid index was passed");
            }
        }

        return val;
    }

    public void delete(int index) throws InvalidIndexException {
        if (index >= size || index < 0) {
            throw new InvalidIndexException("Invalid index was passed.");
        }
        MyLinkedQueue buffer = new MyLinkedQueue();

        for (int i = 0; i < index; i++) {
            try {
                buffer.push_back(this.pop_front());
            } catch (EmptyQueueException err) {
                throw new InvalidIndexException("Invalid index was passed");
            }
        }

        try {
            this.pop_front();
        } catch (EmptyQueueException err) {
            throw new InvalidIndexException("Invalid index was passed");
        }

        while (!buffer.isEmpty()) {
            try {
                this.push_front(buffer.pop_back());
            } catch (EmptyQueueException err) {
                throw new InvalidIndexException("Invalid index was passed");
            }
        }
    }

    public void randomFill(int n) {
        for (int i = 0; i < n; i++) {
            this.push_back((int)(Math.random() * 100));
        }
    }

    public String toString() { // Привести очередь к строке
        String str = "["; // Открываем массив в строке
        QueueItem current = front;

        while (current != back) {
            str += current.getData() + ", "; // Добавляем помимо элемента запятую с пробелом в конце
            current = current.getNext();
        }

        if (current != null) {
            str += current.getData();
        }
        str += "]"; // Закрываем массив в строке

        return str;
    }
}

class QueueItem {
    // Private
    int data = 0;
    QueueItem next = null;
    QueueItem prev = null;

    // Public
    QueueItem () {
        data = 0;
    }

    QueueItem (int data) {
        this.data = data;
    }

    QueueItem (int data, QueueItem prev, QueueItem next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public void setNext(QueueItem next) {
        this.next = next;
    }

    public void setPrev(QueueItem prev) {
        this.prev = prev;
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