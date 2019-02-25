import com.queue.*;
import com.exception.*;

public class Main {
    public static void main(String[] args) {
        MyArrayQueue arrayQueue = new MyArrayQueue();
        MyLinkedQueue linkedQueue = new MyLinkedQueue();

        try {
            arrayQueue.randomFill(25);
        } catch (FullQueueException err) {
            System.out.println(err.getMessage());
        }

        System.out.println(arrayQueue.toString() + ", size: " + arrayQueue.size());

        int first = 0;
        int middle = 0;
        int last = 0;

        try {
            first = arrayQueue.front();
            last = arrayQueue.back();
            middle = arrayQueue.valueOf((arrayQueue.size() - 1) / 2);
        } catch (EmptyQueueException | InvalidIndexException err) {
            System.out.println(err.getMessage());
        }

        System.out.println("First: " + first + ", middle: " + middle + ", last: " + last);

        try {
            arrayQueue.delete(8);
            arrayQueue.delete(5);
        } catch (InvalidIndexException err) {
            System.out.println(err.getMessage());
        }
        System.out.println(arrayQueue.toString() + ", size: " + arrayQueue.size());
    }
}

// Удалить все элем, что равняются первому, среднему и последнему