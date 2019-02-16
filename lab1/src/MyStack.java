public interface MyStack<T> {
    public void push(T item) throws Exception; // Вставка элемента

    public T pop() throws Exception; // Удаление элемента

    public T top() throws Exception; // Возврат вершины стека без удаления

    public int size(); // Возврат размера массива

    public void clear(); // Очистка стека

    public boolean isEmpty(); // Проверка пуст ли стек

    public String toString(); // Привести к строке
}
