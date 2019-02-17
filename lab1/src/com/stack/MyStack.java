package com.stack;

import com.exception.*;

public interface MyStack<T> {
    public void push(T item) throws FullStackException; // Вставка элемента

    public T pop() throws EmptyStackException; // Удаление элемента

    public T top() throws EmptyStackException; // Возврат вершины стека без удаления

    public int size(); // Возврат размера массива

    public void clear(); // Очистка стека

    public boolean isEmpty(); // Проверка пуст ли стек

    public String toString(); // Привести к строке

    public void copyStack(MyStack<T> myStack) throws CopyingStackException; // Копирование стека
}
