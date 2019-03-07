package com.queue;

import com.exception.EmptyQueueException;
import com.exception.InvalidIndexException;

public class MyPriorityQueue implements MyQueue {
    // Private
    //...

    // Constructors
    //...

    // Public
    public void push(int item) { // Вставка элемента в конец очереди
        //...
    }

    public int pop() throws EmptyQueueException { // Удаление элемента в начале очереди
        return 0;
    }

    public int back() throws EmptyQueueException { // Возврат конца очереди без удаления
        return 0;
    }

    public int front() throws EmptyQueueException { // Возврат начала очереди без удаления
        return 0;
    }

    public int size() { // Возврат размера очереди
        return 0;
    }

    public void clear() { // Очистка очереди
        //...
    }

    public boolean isEmpty() { // Проверка пуста ли очередь
        return true;
    }

    public int valueOf(int index) throws InvalidIndexException {
        return 0;
    }

    public void randomFill(int n) {
        //....
    }

    public String toString() { // Привести очередь к строке
        return null;
    }
}
