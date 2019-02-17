package com.stack;// My personal classes
import com.exception.*;

// Java classes
import java.lang.String;
import java.lang.reflect.Array;

public class MyArrayStack<T> implements MyStack<T> {
    // Private
    private final static GenericArrayFactory factory = new GenericArrayFactory();
    private final static int defaultCapacity = 64; // Размер массива по умолчанию
    private Class<T> instance = null;
    private T[] arr = null;
    private int size = 0;
    private int capacity = defaultCapacity;

    private void setCapacity(int capacity) {
        this.capacity = capacity;
        T[] buffer = arr;
        arr = factory.createInstanceArray(instance, capacity);
        if (size < capacity) {
            for (int i = 0; i < size; i++) {
                arr[i] = buffer[i];
            }
        } else {
            for (int i = 0; i < capacity; i++) {
                arr[i] = buffer[i];
            }
        }
    }

    // Public
    public MyArrayStack(Class<T> instance) { // Конструктор по умолчанию
        this.instance = instance;
        arr = factory.createInstanceArray(instance, defaultCapacity);
    }

    public MyArrayStack(Class<T> instance, MyStack<T> myStack) throws CopyingStackException { // Конструктор по умолчанию
        this.instance = instance;
        arr = factory.createInstanceArray(instance, myStack.size() + defaultCapacity);
        try {
            this.copyStack(myStack);
        } catch (CopyingStackException err) {
            throw err;
        }
    }

    public MyArrayStack(Class<T> instance, int capacity) throws InvalidCapacityException { // Конструктор по умолчанию
        this.instance = instance;
        if (capacity <= 0) { // Неверное значение размера стека передано
            arr = factory.createInstanceArray(instance, defaultCapacity);
            throw new InvalidCapacityException("Invalid capacity, current capacity is set to 16."); // Кидаем исключение
        }
        arr = factory.createInstanceArray(instance, capacity);
        this.capacity = capacity;
    }

    public void push(T item) throws FullStackException { // Вставка элемента
        if (size >= capacity) { // Стек уже полон
            throw new FullStackException("Stack is full"); // Кидаем исключение
        }
        arr[size] = item;
        size++;
    }

    public T pop() throws EmptyStackException { // Удаление элемента
        if (size == 0) { // Стек уже пуст
            throw new EmptyStackException("Stack is empty");// Кидаем исключение
        }
        T item = arr[size - 1];
        arr[size - 1] = null;
        size--;
        return item;
    }

    public T top() throws EmptyStackException { // Возврат вершины стека без удаления
        if (size == 0) { // Стек уже пуст
            throw new EmptyStackException("Stack is empty"); // Кидаем исключение
        }
        return arr[size - 1];
    }

    public int size() { // Возврат размера массива
        return size;
    }

    public void clear() { // Очистка стека
        if (size > 0) {
            arr = factory.createInstanceArray(instance, capacity);
            size = 0;
        }
    }

    public boolean isEmpty() { // Проверка пуст ли стек
        if (size > 0) {
            return false;
        }
        return true;
    }

    public String toString() { // Привести к строке
        String str = "["; // Открываем массив в строке
        for (int i = size - 1; i >= 0; i--) { // Добавляем каждый элемент в строку
            if (i > 0) { // Элемент не последний
                str += arr[i] + ", "; // Добавляем помимо элемента запятую с пробелом в конце
                continue; // Завершаем итерацию
            }
            str += arr[i]; // Элемент последний, не добавляем запятую с пробелом в конце
        }
        str += "]"; // Закрываем массив в строке
        return str;
    }

    public void copyStack(MyStack<T> myStack) throws CopyingStackException { // Копирование стека
        MyStack<T> buffer = null; // Буферный стек для копирования

        try {
            buffer = new MyArrayStack(instance, myStack.size());
        } catch (InvalidCapacityException err) {
            throw new CopyingStackException(err.getMessage());
        }

        while (!myStack.isEmpty()) {
            try {
                buffer.push(myStack.pop());
            } catch (FullStackException | EmptyStackException err) {
                throw new CopyingStackException(err.getMessage());
            }
        }

        this.clear(); // Очистка стека
        if (this.capacity < myStack.size()) { // Вместимость текущего стека меньше чем копируемого
            this.setCapacity(myStack.size() + defaultCapacity); // Изменяем вместимость стека
        }

        while (!buffer.isEmpty()) { // Перенос элементов из буфера в текущий стек
            try {
                T item = buffer.pop();
                this.push(item);
                myStack.push(item);
            } catch (FullStackException err) {
                throw new CopyingStackException("Stack is already full. Not all items were copied");
            } catch (EmptyStackException err) {
                throw new CopyingStackException("Copied stack is already empty");
            }
        }
    }
}

class GenericArrayFactory {
    // Public
    public <T> T[] createInstanceArray(Class<T> instance, int size) {
        return (T[]) Array.newInstance(instance, size);
    }
}