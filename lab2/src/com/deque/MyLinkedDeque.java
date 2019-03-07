package com.deque;

// Мои классы
import com.exception.*;

// Классы Java
import java.lang.Math;


public class MyLinkedDeque implements MyDeque {
    // Private
    private int size = 0;
    private DequeItem back = null;
    private DequeItem front = null;

    // Public
    public MyLinkedDeque() { // Конструктор по умолчанию
    }

    public void push_back(int item) { // Вставка элемента в конец очереди
        if (back == null) {
            back = new DequeItem(item);
            front = back;
        } else {
            DequeItem newItem = new DequeItem(item, back, null);
            back.setNext(newItem);
            back = newItem;
        }
        size++;
    }

    public void push_front(int item) { // Вставка элемента в начало очереди
        if (front == null) {
            front = new DequeItem(item);
            back = front;
        } else {
            DequeItem newItem = new DequeItem(item, null, front);
            front.setPrev(newItem);
            front = newItem;
        }
        size++;
    }

    public int pop_back() throws EmptyDequeException { // Удаление элемента в конце очереди
        if (back == null) {
            throw new EmptyDequeException("Queue is already empty.");
        }
        DequeItem oldItem = back;
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

    public int pop_front() throws EmptyDequeException { // Удаление элемента в начале очереди
        if (front == null) {
            throw new EmptyDequeException("Queue is already empty.");
        }
        DequeItem oldItem = front;
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

    public int back() throws EmptyDequeException { // Возврат конца очереди без удаления
        if (back == null) {
            throw new EmptyDequeException("Queue is already empty.");
        }
        return back.getData();
    }

    public int front() throws EmptyDequeException { // Возврат начала очереди без удаления
        if (front == null) {
            throw new EmptyDequeException("Queue is already empty.");
        }
        return front.getData();
    }

    public int size() { // Возврат размера очереди
        return size;
    }

    public void clear() { // Очистка очереди
        DequeItem current = front;
        front = null;
        back = null;
        size = 0;

        while (current != null) {
            DequeItem buffer = current;
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

    public int valueOf(int index) throws InvalidIndexException {
        if (index >= size || index < 0) {
            throw new InvalidIndexException("Invalid index was passed.");
        }
        MyLinkedDeque buffer = new MyLinkedDeque();

        for (int i = 0; i < index; i++) {
            try {
                buffer.push_back(this.pop_front());
            } catch (EmptyDequeException err) {
                throw new InvalidIndexException("Invalid index was passed");
            }
        }

        int val = this.front.getData();

        while (!buffer.isEmpty()) {
            try {
                this.push_front(buffer.pop_back());
            } catch (EmptyDequeException err) {
                throw new InvalidIndexException("Invalid index was passed");
            }
        }

        return val;
    }

    public void randomFill(int n) {
        for (int i = 0; i < n; i++) {
            this.push_back((int)(Math.random() * 10));
        }
    }

    public String toString() { // Привести очередь к строке
        String str = "["; // Открываем массив в строке
        DequeItem current = front;

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

class DequeItem {
    // Private
    int data = 0;
    DequeItem next = null;
    DequeItem prev = null;

    // Public
    DequeItem() {
        data = 0;
    }

    DequeItem(int data) {
        this.data = data;
    }

    DequeItem(int data, DequeItem prev, DequeItem next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public void setNext(DequeItem next) {
        this.next = next;
    }

    public void setPrev(DequeItem prev) {
        this.prev = prev;
    }

    public DequeItem getNext() {
        return next;
    }

    public DequeItem getPrev() {
        return prev;
    }

    public int getData() {
        return data;
    }
}