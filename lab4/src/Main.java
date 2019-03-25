import com.exception.*;
import com.tree.*;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

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

        Iterator<Integer> infix = tree.infixIterator();
        int min = Integer.MAX_VALUE;

        while (infix.hasNext()) {
            int val = infix.next();
            min = val < min ? val : min;
        }

        tree.delete(min);

        infix = tree.infixIterator();

        while (infix.hasNext()) {
            System.out.println("=> " + infix.next());
        }
    }
}
