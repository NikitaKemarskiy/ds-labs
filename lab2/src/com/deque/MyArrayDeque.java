package com.deque;

// Мои классы
import com.exception.*;

// Классы Java
import java.lang.Math;

public class MyArrayDeque implements MyDeque {
    // Private
    private static int defaultCapacity = 20; // Размер очереди по умолчанию
    private int[] arr;
    private int size = 0;
    private int capacity = defaultCapacity;
    private int back = 0;
    private int front = 0;

    // Public
    public MyArrayDeque() { // Конструктор по умолчанию
        arr = new int[capacity];
    }

    public MyArrayDeque(int capacity) throws InvalidCapacityException { // Конструктор с передачей вместимости
        if (capacity <= 0) {
            this.capacity = defaultCapacity;
            arr = new int[this.capacity];
            throw new InvalidCapacityException("Invalid capacity, current capacity is set to 64.");
        }
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void push_back(int item) throws FullDequeException { // Вставка элемента в конец очереди
        if (size < capacity) {
            arr[back] = item;
            back = back >= capacity - 1 ? 0 : back + 1;
            size++;
        } else {
            throw new FullDequeException("Queue is already full");
        }
    }

    public void push_front(int item) throws FullDequeException { // Вставка элемента в начало очереди
        if (size < capacity) {
            front = front == 0 ? capacity - 1 : front - 1;
            arr[front] = item;
            size++;
        } else {
            throw new FullDequeException("Queue is already full");
        }
    }

    public int pop_back() throws EmptyDequeException { // Удаление элемента в конце очереди
        if (size > 0) {
            back = back == 0 ? capacity - 1 : back - 1;
            size--;
            return arr[back];
        } else {
            throw new EmptyDequeException("Queue is already empty");
        }
    }

    public int pop_front() throws EmptyDequeException { // Удаление элемента в начале очереди
        if (size > 0) {
            int val = arr[front];
            front = front >= capacity - 1 ? 0 : front + 1;
            size--;
            return val;
        } else {
            throw new EmptyDequeException("Queue is already empty");
        }
    }

    public int back() throws EmptyDequeException { // Возврат конца очереди без удаления
        if (size <= 0) {
            throw new EmptyDequeException("Queue is empty");
        }
        return arr[back == 0 ? capacity - 1 : back - 1];
    }

    public int front() throws EmptyDequeException { // Возврат начала очереди без удаления
        if (size <= 0) {
            throw new EmptyDequeException("Queue is empty");
        }
        return arr[front];
    }

    public int size() { // Возврат размера очереди
        return size;
    }

    public int capacity() { return capacity; }

    public void clear() { // Очистка очереди
        size = 0;
        back = 0;
        front = 0;
    }

    public boolean isEmpty() { // Проверка пуста ли очередь
        return size > 0 ? false : true;
    }

    public int valueOf(int index) throws InvalidIndexException {
        if (index >= size || index < 0) {
            throw new InvalidIndexException("Invalid index was passed.");
        }

        MyArrayDeque buffer = null;
        try {
            buffer = new MyArrayDeque(capacity);
        } catch (InvalidCapacityException err) {
            System.out.println(err.getMessage());
        }

        for (int i = 0; i < index; i++) {
            try {
                buffer.push_back(this.pop_front());
            } catch (FullDequeException | EmptyDequeException err) {
                throw new InvalidIndexException("Invalid index was passed");
            }
        }

        int val = 0;

        try {
            val = this.front();
        } catch (EmptyDequeException err) {
            throw new InvalidIndexException("Invalid index was passed");
        }

        while (!buffer.isEmpty()) {
            try {
                this.push_front(buffer.pop_back());
            } catch (FullDequeException | EmptyDequeException err) {
                throw new InvalidIndexException("Invalid index was passed");
            }
        }

        return val;
    }

    public void randomFill(int n) throws FullDequeException {
        if (n > (capacity - size)) {
            int diff = capacity - size;
            for (int i = 0; i < diff; i++) {
                try {
                    this.push_back((int)(Math.random() * 10));
                } catch (FullDequeException err) {
                    throw err;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                try {
                    this.push_back((int)(Math.random() * 10));
                } catch (FullDequeException err) {
                    throw err;
                }
            }
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