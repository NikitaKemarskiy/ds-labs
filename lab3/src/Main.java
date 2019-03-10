import java.util.Scanner;

import com.queue.*;
import com.exception.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // MyQueue arrayQueue = new MyArrayQueue(); // Array queue
        // MyLinkedQueue linkedQueue = new MyLinkedQueue(); // Linked queue
        MyPriorityQueue V = new MyPriorityQueue(); // Priority queue
        MyPriorityQueue S = new MyPriorityQueue(); // Priority queue
        MyPriorityQueue R = new MyPriorityQueue(); // Priority queue

        System.out.print("Input n: ");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            V.push((int)(Math.random() * 10), i);
            S.push((int)(Math.random() * 10), i);
        }

        System.out.println("V: " + V.toString());
        System.out.println("S: " + S.toString());

        int dob = 0;

        for (int i = 0; i < n; i++) {
            try {
                dob += V.pop() * S.pop();
            } catch (EmptyQueueException err) {
                System.out.println(err.getMessage());
                System.exit(1);
            }
        }

        System.out.println("Result: " + dob);
    }
}
