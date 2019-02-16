import java.lang.String;
import java.lang.Exception;
import java.lang.reflect.Array;

public class MyArrayStack<T> {
    // Private
    private final static GenericArrayFactory factory = new GenericArrayFactory();
    private final static int defaultCapacity = 255; // Размер массива по умолчанию
    private Class<T> instance = null;
    private T[] arr = null;
    private int size = 0;
    private int capacity = defaultCapacity;

    // Public
    MyArrayStack(Class<T> instance) { // Конструктор по умолчанию
        this.instance = instance;
        arr = factory.createInstanceArray(instance, defaultCapacity);
    }

    MyArrayStack(Class<T> instance, int capacity) throws Exception { // Конструктор по умолчанию
        this.instance = instance;
        if (capacity <= 0) { // Неверное значение размера стека передано
            arr = factory.createInstanceArray(instance, defaultCapacity);
            throw new Exception("Invalid capacity, current capacity is 16."); // Кидаем исключение
        }
        arr = factory.createInstanceArray(instance, capacity);
        this.capacity = capacity;
    }

    public void push(T item) throws Exception { // Вставка элемента
        if (size >= capacity) { // Стек уже полон
            throw new Exception("Stack is full"); // Кидаем исключение
        }
        arr[size] = item;
        size++;
    }

    public T pop() throws Exception { // Удаление элемента
        if (size == 0) { // Стек уже пуст
            throw new Exception("Stack is empty");// Кидаем исключение
        }
        T item = arr[size - 1];
        arr[size - 1] = null;
        size--;
        return item;
    }

    public T top() throws Exception { // Возврат вершины стека без удаления
        if (size == 0) { // Стек уже пуст
            throw new Exception("Stack is empty"); // Кидаем исключение
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
        for (int i = 0; i < size; i++) { // Добавляем каждый элемент в строку
            if (i < size - 1) { // Элемент не последний
                str += arr[i] + ", "; // Добавляем помимо элемента запятую с пробелом в конце
                continue; // Завершаем итерацию
            }
            str += arr[i]; // Элемент последний, не добавляем запятую с пробелом в конце
        }
        str += "]"; // Закрываем массив в строке
        return str;
    }
}

class GenericArrayFactory {
    // Public
    public <T> T[] createInstanceArray(Class<T> instance, int size) {
        return (T[]) Array.newInstance(instance, size);
    }
}