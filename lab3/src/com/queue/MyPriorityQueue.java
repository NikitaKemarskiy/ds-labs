package com.queue;

import com.exception.EmptyQueueException;
import com.exception.InvalidIndexException;

public class MyPriorityQueue {
    // Protected
    protected QueueItem front;
    protected QueueItem back;
    protected int size = 0;

    // Constructors
    public MyPriorityQueue() {
        front = null;
        back = null;
    }

    // Public
    public void push(int data, int priority) { // Вставка элемента по приоритету в очередь
        size++;
        if (front == null) { // Приоритетная очередь пуста
            front = new QueuePriorityItem(data, priority);
            back = front;
            return; // Заканчиваем выполнение функции
        }

        QueuePriorityItem curr = (QueuePriorityItem) front;
        while (curr != null && curr.getPriority() <= priority) {
            curr = (QueuePriorityItem) curr.getNext();
        }

        if (curr == null) { // Новый элемент имеет самый низкий приоритет, ставим в конец очереди
            QueueItem prev = back;
            back = new QueuePriorityItem(data, priority, prev, null);
            prev.setNext(back);
            return;
        }
        QueueItem item = new QueuePriorityItem(data, priority, curr.getPrev(), curr);
        if (curr.getPrev() != null) {
            curr.getPrev().setNext(item);
        } else {
            front = item;
        }
        curr.setPrev(item);
    }

    public int pop() throws EmptyQueueException { // Удаление элемента в начале очереди
        if (front == null) {
            throw new EmptyQueueException("Error: queue is already empty.");
        } else {
            size--;
            int data = front.getData();
            QueueItem next = front.getNext();
            front.setNext(null);
            front = next;
            if (next == null) { // Очередь уже пуста
                back = null;
                return data;
            }
            front.setPrev(null);
            return data;
        }
    }

    public int back() throws EmptyQueueException { // Возврат конца очереди без удаления
        return back.getData();
    }

    public int front() throws EmptyQueueException { // Возврат начала очереди без удаления
        return front.getData();
    }

    public int size() { // Возврат размера очереди
        return size;
    }

    public void clear() { // Очистка очереди
        QueueItem item = front;
        front = null;
        back = null;
        size = 0;
        while (item != null) {
            QueueItem buff = item;
            item = item.getNext();
            buff.setPrev(null);
            buff.setNext(null);
        }
    }

    public boolean isEmpty() { // Проверка пуста ли очередь
        return (size <= 0);
    }

    public int valueOf(int index) throws InvalidIndexException {
        QueueItem item = front;
        while (index > 0) {
            item = item.getNext();
            if (item == null) {
                throw new InvalidIndexException("Error: invalid exception was passed.");
            }
            index--;
        }
        return item.getData();
    }

    public void randomFill(int n) {
        for (int i = 0; i < n; i++) {
            this.push((int)(Math.random() * 100), (int)(Math.random() * 50));
        }
    }

    public String toString() { // Привести очередь к строке
        String str = "["; // Открываем массив в строке
        QueueItem item = front;

        while (item != back) {
            str += item.getData() + ", "; // Добавляем помимо элемента запятую с пробелом в конце
            item = item.getNext();
        }

        if (item != null) {
            str += item.getData();
        }

        str += "]"; // Закрываем массив в строке

        return str;
    }
}

