import com.exception.EmptyStackException;
import com.exception.FullStackException;
import com.exception.InvalidIndexException;
import com.stack.MyArrayStack;
import com.stack.MyLinkedStack;
import com.stack.MyStackProcessing;

public class Main {
    public static void main(String[] args) {
        MyArrayStack<Integer> arrayStack = new MyArrayStack<>(Integer.class);
        MyLinkedStack<Integer> linkedStack = new MyLinkedStack<>();

        try {
            arrayStack.push(51);
            arrayStack.push(13);
            arrayStack.push(82);
            arrayStack.push(11);
            arrayStack.push(35);
            arrayStack.push(93);
            arrayStack.push(7);
            arrayStack.push(34);
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
        }

        int maxIndex = -1;

        try {
            maxIndex = MyStackProcessing.maxIndex(arrayStack);
        } catch (EmptyStackException err) {
            System.out.println(err.getMessage());
        }

        try {
            MyStackProcessing.insert(arrayStack, 0, maxIndex + 1);
        } catch (InvalidIndexException | EmptyStackException | FullStackException err) {
            System.out.println("Error: " + err.getMessage());
        }

        System.out.println(arrayStack.toString());
        System.out.println("Max index: " + maxIndex);
    }
}