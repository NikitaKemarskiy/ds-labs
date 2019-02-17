package com.stack;

import com.exception.CopyingStackException;
import com.exception.EmptyStackException;
import com.exception.FullStackException;
import com.exception.InvalidIndexException;

public class MyStackProcessing {
    // Private
    private MyStackProcessing() {} // Приватный конструктор для того, чтобы запретить создание объектов класса

    // Public
    public static <T extends Number> int maxIndex(MyStack<T> myStack) throws EmptyStackException { // Нахождение индекса максимального элемента
        int currentIndex = -1; // Текущий индекс
        int maxIndex = 0; // Индекс максимального элемента
        T maxVal = null; // Значение максимального элемента
        MyStack<T> buffer = null; // Буферный стек для копирования

        try { // Записываем значение нулевого элемента в maxVal без удаления
            maxVal = myStack.top();
        } catch (EmptyStackException err) {
            throw err;
        }

        try {
            buffer = new MyLinkedStack<>(myStack);
        } catch (CopyingStackException err) {
            throw new EmptyStackException(err.getMessage());
        }

        while (!buffer.isEmpty()) {
            currentIndex++; // Инкремент текущего индекса
            try {
                T num = buffer.pop();
                Long numLong = num.longValue();
                if (numLong.compareTo(maxVal.longValue()) > 0) {
                    maxVal = num;
                    maxIndex = currentIndex;
                }
            } catch (EmptyStackException err) {
                throw err;
            }
        }
        return maxIndex;
    }

    public static <T extends Number> void insert(MyStack<T> myStack, T item, int index) throws InvalidIndexException, EmptyStackException, FullStackException { // Вставка элемента по индексу
        MyStack<T> buffer = new MyLinkedStack<>(); // Буферный стек для копирования

        if (index >= myStack.size() || index < 0) { // Неверный индекс
            throw new InvalidIndexException("Invalid index passed");
        }

        while (!myStack.isEmpty()) {
            try {
                buffer.push(myStack.pop());
            } catch (EmptyStackException err) {
                throw err;
            }
        }

        index = buffer.size() - index;

        for (int i = 0; i < index; i++) {
            try {
                T num = buffer.pop();
                try {
                    myStack.push(num);
                } catch (FullStackException err) {
                    throw err;
                }
            } catch (EmptyStackException err) {
                throw err;
            }
        }

        try {
            myStack.push(item);
        } catch (FullStackException err) {
            throw err;
        }

        while (!buffer.isEmpty()) {
            try {
                myStack.push(buffer.pop());
            } catch (EmptyStackException | FullStackException err) {
                throw err;
            }
        }
    }
}
