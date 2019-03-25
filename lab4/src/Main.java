import com.exception.*;
import com.tree.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        try {
            tree.insert(1);
            tree.insert(6);
            tree.insert(2);
            tree.insert(8);
            tree.insert(11);
            tree.insert(9);
            tree.insert(7);
            tree.insert(5);
            tree.insert(4);
            tree.insert(3);
            tree.insert(-2);
        } catch (InvalidItemException err) {
            System.out.println("Error: " + err.getMessage());
            System.exit(1);
        }

        // Infix
        System.out.println("Infix:");
        Iterator<Integer> infix = tree.infixIterator();

        while (infix.hasNext()) {
            System.out.println("=> Item: " + infix.next());
        }
        System.out.println("======================");

        // Prefix
        System.out.println("Prefix:");
        Iterator<Integer> prefix = tree.prefixIterator();

        while (prefix.hasNext()) {
            System.out.println("=> Item: " + prefix.next());
        }
        System.out.println("======================");

        // Postfix
        System.out.println("Postfix:");
        Iterator<Integer> postfix = tree.postfixIterator();

        while (postfix.hasNext()) {
            System.out.println("=> Item: " + postfix.next());
        }
        System.out.println("======================");
    }
}
