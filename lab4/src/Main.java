import com.tree.*;

import java.util.Iterator;
import java.util.Scanner;

import static java.lang.Math.ceil;
import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        // Input number of items to insert into a BinaryTree
        System.out.print("Input number of items: ");
        int n = scan.nextInt();
        
        // Fill BinaryTree with random values
        for (int i = 0; i < n; i++) {
            int item = (int)(random() * 50);
            System.out.print(item + "; ");
            tree.insert(item);
        }
        System.out.println();

        // Infix iterate BinaryTree
        Iterator<Integer> infix = tree.infixIterator();
        System.out.print("Infix: ");       
        while (infix.hasNext()) {
            System.out.print(infix.next() + "; ");
        }
        System.out.println();
        
        // Input item to delete min value in its subtree
        System.out.print("Input item to delete min value: ");
        int item = scan.nextInt();

        // Delete min value in its subtree
        tree.removeMin(item);

        // Infix iterate BinaryTree
        infix = tree.infixIterator();
        System.out.print("Infix: ");       
        while (infix.hasNext()) {
            System.out.print(infix.next() + "; ");
        }
        System.out.println();
    }
}
