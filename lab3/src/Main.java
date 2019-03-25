import java.util.Scanner;

import com.queue.*;
import com.exception.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MyPriorityQueue V = new MyPriorityQueue(); // Priority queue
        MyPriorityQueue S = new MyPriorityQueue(); // Priority queue
        MyPriorityQueue R = new MyPriorityQueue(); // Priority queue

        System.out.print("Input n: ");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            V.push((int)(Math.random() * 10), (int)(Math.random() * 100));
            S.push((int)(Math.random() * 10), (int)(Math.random() * 100));
        }

        System.out.println("V queue: " + V.toString());
        System.out.println("V priorities: " + V.toStringPriority());
        System.out.println("S queue: " + S.toString());
        System.out.println("S priorities: " + S.toStringPriority());

        for (int i = 0; i < n; i++) {
            try {
                int priority = Math.min(V.frontPriority(), S.frontPriority());
                R.push(V.pop() * S.pop(), priority);
            } catch (EmptyQueueException err) {
                System.out.println(err.getMessage());
                System.exit(1);
            }
        }

        System.out.println("=============================");
        System.out.println("Result queue: " + R.toString());
        System.out.println("Result priorities: " + R.toStringPriority());
    }
}
