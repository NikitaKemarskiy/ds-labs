package com.queue;

import com.exception.*;

public interface MyQueue {
    void push(int data) throws FullQueueException; // Вставка элемента в конец очереди

    int pop() throws EmptyQueueException; // Удаление элемента в начале очереди

    int back() throws EmptyQueueException; // Возврат конца очереди без удаления

    int front() throws EmptyQueueException; // Возврат начала очереди без удаления

    int size(); // Возврат размера очереди

    void clear(); // Очистка очереди

    boolean isEmpty(); // Проверка пуста ли очередь

    int valueOf(int index) throws InvalidIndexException;

    void randomFill(int n) throws FullQueueException;

    String toString(); // Привести очередь к строке
}