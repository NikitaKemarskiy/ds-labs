import java.lang.String;
import java.lang.Exception;

public class MyLinkedStack<T> implements MyStack<T> {
    // Private
    private StackItem<T> head = null;
    private int size = 0;

    // Public
    public void push(T item) { // Вставка элемента
        if (head != null) { // Стек не пуст
            StackItem<T> newItem = new StackItem<>(item, head); // Вставка нового элемента со ссылкой на следующий
            head = newItem; // Переприсваиваем вершину стека
        } else {
            head = new StackItem<>(item); // Вставка нового элемента
        }
        size++; // Инкрементируем размер
    }

    public T pop() throws Exception { // Удаление элемента
        if (head == null) { // Стек уже пуст
            throw new Exception("Stack is empty"); // Кидаем исключение
        }
        T data = head.getData(); // Сохраняем данные вершины стека
        head = head.getNext(); // Удаляем вершину стека
        size--; // Декрементируем размер
        return data; // Возвращаем данные
    }

    public T top() throws Exception { // Возврат вершины стека без удаления
        if (head == null) { // Стек уже пуст
            throw new Exception("Stack is empty"); // Кидаем исключение
        }
        return head.getData(); // Возвращаем вершину стека
    }

    public int size() { // Возврат размера массива
        return size;
    }

    public void clear() { // Очистка стека
        StackItem item = head;
        head = null;
        size = 0;
        while (item != null) {
            StackItem next = item.getNext();
            item.clearNext();
            item = next;
        }
    }

    public boolean isEmpty() { // Проверка пуст ли стек
        if (head != null) {
            return false;
        }
        return true;
    }

    public String toString() { // Привести к строке
        String str = "["; // Открываем массив в строке
        StackItem item = head;
        while (item != null) { // Добавляем каждый элемент в строку
            str += item.getData() + ", ";
            item = item.getNext();
            if (item == null) { // Элемент последний
                str = str.substring(0, str.length() - 2); // Удаляем запятую с пробелом в конце
            }
        }
        str += "]"; // Закрываем массив в строке
        return str;
    }
}

class StackItem<T> { // Класс элемента стека
    // Private
    private StackItem next = null;
    private T data;

    // Public
    StackItem(T data) {
        this.data = data;
    }

    StackItem(T data, StackItem next) {
        this.next = next;
        this.data = data;
    }

    public StackItem getNext() {
        return next;
    } // Возврат ссылки на следующий элемент

    public T getData() {
        return data;
    } // Возврат данных

    public void clearNext() { next = null; } // Удаление ссылки на следующий элемент
}
