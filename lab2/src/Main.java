import com.queue.*;
import com.exception.*;

public class Main {
    public static void main(String[] args) {
        MyArrayQueue arrayQueue = new MyArrayQueue();
        MyLinkedQueue linkedQueue = new MyLinkedQueue();

        linkedQueue.randomFill(20);
        /*try {
            arrayQueue.randomFill(15);
        } catch (FullQueueException err) {
            System.out.println(err.getMessage());
        }*/

        int first = 0;
        int middle = 0;
        int last = 0;
        int currentIndex = 0;
        int initSize = linkedQueue.size();

        try {
            first = linkedQueue.front();
            last = linkedQueue.back();
            middle = linkedQueue.valueOf((linkedQueue.size() - 1) / 2);
        } catch (EmptyQueueException | InvalidIndexException err) {
            System.out.println(err.getMessage());
        }

        System.out.println(linkedQueue.toString() + ", size: " + linkedQueue.size());
        System.out.println("First: " + first + ", middle: " + middle + ", last: " + last);

        MyLinkedQueue buffer = new MyLinkedQueue();
        /*MyArrayQueue buffer = null;
        try {
            buffer = new MyArrayQueue(arrayQueue.capacity());
        } catch (InvalidCapacityException err) {
            System.out.println(err.getMessage());
        }*/

        while (!linkedQueue.isEmpty()) {
            int item = 0;
            try {
                item = linkedQueue.pop_front();
            } catch (EmptyQueueException err) {
                System.out.println(err.getMessage());
                break;
            }
            if (!((currentIndex != 0 && currentIndex != (initSize - 1) / 2 && currentIndex != (initSize - 1)) && (item == first || item == middle || item == last))) {
                buffer.push_back(item);
                /*try {
                    buffer.push_back(item);
                } catch (FullQueueException err) {
                    System.out.println(err.getMessage());
                    break;
                }*/
            }
            currentIndex++;
        }

        System.out.println(buffer.toString() + ", size: " + buffer.size());
    }
}

// Удалить все элем, что равняются первому, среднему и последнему