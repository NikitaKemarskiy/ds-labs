import java.lang.Integer;
import java.lang.String;
import java.lang.Exception;

public class MyArrayStack {
    // Private
    private final static int defaultCapacity = 255; // Размер массива по умолчанию
    private Integer[] arr;
    private int size = 0;
    private int capacity = defaultCapacity;

    // Public
    MyArrayStack() { // Конструктор по умолчанию
        arr = new Integer[defaultCapacity];
    }

    MyArrayStack(int capacity) throws Exception { // Конструктор по умолчанию
        if (capacity <= 0) { // Неверное значение размера стека передано
            arr = new Integer[defaultCapacity];
            throw new Exception("Invalid capacity, current capacity is 16."); // Кидаем исключение
        }
        arr = new Integer[capacity];
        this.capacity = capacity;
    }

    public void push(Integer item) throws Exception { // Вставка элемента
        if (size >= capacity) { // Стек уже полон
            throw new Exception("Stack is full"); // Кидаем исключение
        }
        arr[size] = item;
        size++;
    }

    public Integer pop() throws Exception { // Удаление элемента
        if (size == 0) { // Стек уже пуст
            throw new Exception("Stack is empty");// Кидаем исключение
        }
        Integer item = arr[size - 1];
        arr[size - 1] = null;
        size--;
        return item;
    }

    public Integer top() throws Exception { // Возврат вершины стека без удаления
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
            arr = new Integer[capacity];
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
