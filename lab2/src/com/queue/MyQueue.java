package com.queue;

import com.exception.*;

public interface MyQueue {
    void push_back(int item) throws FullQueueException; // Вставка элемента в конец очереди

    void push_front(int item) throws FullQueueException; // Вставка элемента в начало очереди

    int pop_back() throws EmptyQueueException; // Удаление элемента в конце очереди

    int pop_front() throws EmptyQueueException; // Удаление элемента в начале очереди

    int back() throws EmptyQueueException; // Возврат конца очереди без удаления

    int front() throws EmptyQueueException; // Возврат начала очереди без удаления

    int size(); // Возврат размера очереди

    void clear(); // Очистка очереди

    boolean isEmpty(); // Проверка пуста ли очередь

    int indexOf(int val);

    int valueOf(int index) throws InvalidIndexException;

    void delete(int index) throws InvalidIndexException;

    void randomFill(int n) throws FullQueueException;

    String toString(); // Привести очередь к строке
}
