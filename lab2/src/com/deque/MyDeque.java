package com.deque;

import com.exception.*;

public interface MyDeque {
    void push_back(int item) throws FullDequeException; // Вставка элемента в конец очереди

    void push_front(int item) throws FullDequeException; // Вставка элемента в начало очереди

    int pop_back() throws EmptyDequeException; // Удаление элемента в конце очереди

    int pop_front() throws EmptyDequeException; // Удаление элемента в начале очереди

    int back() throws EmptyDequeException; // Возврат конца очереди без удаления

    int front() throws EmptyDequeException; // Возврат начала очереди без удаления

    int size(); // Возврат размера очереди

    void clear(); // Очистка очереди

    boolean isEmpty(); // Проверка пуста ли очередь

    int valueOf(int index) throws InvalidIndexException;

    void randomFill(int n) throws FullDequeException;

    String toString(); // Привести очередь к строке
}
