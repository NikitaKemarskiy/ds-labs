import com.deque.*;
import com.exception.*;

public class Main {
    public static void main(String[] args) {
        //MyArrayDeque arrayDeque = new MyArrayDeque();
        MyLinkedDeque linkedDeque = new MyLinkedDeque();

        linkedDeque.randomFill(20);

        /*try {
            arrayDeque.randomFill(15);
        } catch (FullQueueException err) {
            System.out.println(err.getMessage());
        }*/

        int first = 0;
        int middle = 0;
        int last = 0;
        int currentIndex = 0;
        int initSize = linkedDeque.size();

        try {
            first = linkedDeque.front();
            last = linkedDeque.back();
            middle = linkedDeque.valueOf((linkedDeque.size() - 1) / 2);
        } catch (EmptyDequeException | InvalidIndexException err) {
            System.out.println(err.getMessage());
        }

        System.out.println(linkedDeque.toString() + ", size: " + linkedDeque.size());
        System.out.println("First: " + first + ", middle: " + middle + ", last: " + last);

        MyLinkedDeque buffer = new MyLinkedDeque();
        /*MyArrayDeque buffer = null;
        try {
            buffer = new MyArrayDeque(linkedDeque.capacity());
        } catch (InvalidCapacityException err) {
            System.out.println(err.getMessage());
        }*/

        while (!linkedDeque.isEmpty()) {
            int item = 0;
            try {
                item = linkedDeque.pop_front();
            } catch (EmptyDequeException err) {
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