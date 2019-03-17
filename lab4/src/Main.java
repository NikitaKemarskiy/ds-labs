import com.exception.*;
import com.tree.*;

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

        tree.delete(8);
        System.out.println("1: " + tree.search(1));
        System.out.println("6: " + tree.search(6));
        System.out.println("2: " + tree.search(2));
        System.out.println("8: " + tree.search(8));
        System.out.println("11: " + tree.search(11));
        System.out.println("9: " + tree.search(9));
        System.out.println("7: " + tree.search(7));
        System.out.println("5: " + tree.search(5));
        System.out.println("4: " + tree.search(4));
        System.out.println("3: " + tree.search(3));
        System.out.println("-2: " + tree.search(-2));
    }
}
