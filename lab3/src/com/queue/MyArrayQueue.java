package com.queue;

import com.exception.*;

public class MyArrayQueue implements MyQueue {
    // Private
    private static int defaultCapacity = 64; // Размер очереди по умолчанию
    private int[] arr;
    private int capacity = defaultCapacity;
    private int size = 0;
    private int front = 0;
    private int back = 0;

    // Constructors
    public MyArrayQueue() {
        arr = new int[capacity];
    }

    public MyArrayQueue(int capacity) throws InvalidCapacityException {
        if (capacity < 0) {
            arr = new int[defaultCapacity];
            throw new InvalidCapacityException("Error: invalid capacity. Current capacity is set to default.");
        }
        this.capacity = capacity;
        arr = new int[capacity];
    }

    // Public
    public void push(int item) throws FullQueueException { // Вставка элемента в конец очереди
        if (size >= capacity || back >= capacity) {
            throw new FullQueueException("Error: queue is already full." + " back: " + back + ", front: " + front + ", size: " + size);
        }
        arr[back] = item;
        size++;

        back = back == capacity - 1 ? 0 : back + 1;
    }

    public int pop() throws EmptyQueueException { // Удаление элемента в начале очереди
        if (size <= 0) {
            throw new EmptyQueueException("Error: queue is already empty.");
        }
        int data = arr[front];
        size--;
        front = front == capacity - 1 ? 0 : front + 1;
        return data;
    }

    public int back() throws EmptyQueueException { // Возврат конца очереди без удаления
        if (size <= 0) {
            throw new EmptyQueueException("Error: queue is already empty.");
        }
        return back == 0 ? arr[capacity - 1] : arr[back - 1];
    }

    public int front() throws EmptyQueueException { // Возврат начала очереди без удаления
        if (size <= 0) {
            throw new EmptyQueueException("Error: queue is already empty.");
        }
        return arr[front];
    }

    public int size() { // Возврат размера очереди
        return size;
    }

    public void clear() { // Очистка очереди
        front = 0;
        back = 0;
        size = 0;
    }

    public boolean isEmpty() { // Проверка пуста ли очередь
        return (size <= 0);
    }

    public int valueOf(int index) throws InvalidIndexException {
        if (index >= size || index < 0) {
            throw new InvalidIndexException("Error: invalid index was passed.");
        }
        int k = 0;
        int curr = front;
        while (k < index) {
            k++;
            curr = curr == capacity - 1 ? 0 : curr + 1;
        }

        return arr[curr];
    }

    public void randomFill(int n) throws FullQueueException {
        for (int i = 0; i < n; i++) {
            this.push((int)(Math.random() * 100));
        }
    }

    public String toString() { // Привести очередь к строке
        String str = "["; // Открываем массив в строке
        int current = front;

        for (int i = 0; i < size; i++) {
            str += arr[current] + ", "; // Добавляем помимо элемента запятую с пробелом в конце
            current = current >= capacity - 1 ? 0 : current + 1;
        }

        if (str.length() > 1) {
            str = str.substring(0, str.length() - 2);
        }
        str += "]"; // Закрываем массив в строке

        return str;
    }
}
