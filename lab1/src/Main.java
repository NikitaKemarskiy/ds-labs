public class Main {
    public static void main(String[] args) {
        MyArrayStack<Integer> arrayStack = new MyArrayStack<>(Integer.class);
        MyLinkedStack<Integer> linkedStack = new MyLinkedStack<>();

        try {
            linkedStack.push(3);
            linkedStack.push(4);
            linkedStack.push(1);
            linkedStack.push(8);
            linkedStack.push(9);
            linkedStack.push(5);
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
        }

        try {
            System.out.println(linkedStack.top());
            System.out.println(linkedStack.top());
            System.out.println(linkedStack.top());
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
        }

        System.out.println("Size: " + linkedStack.size());

        try {
            while (!linkedStack.isEmpty()) {
                System.out.println(linkedStack.pop());
            }
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
        }

        System.out.println("Size: " + linkedStack.size());
        System.out.println(linkedStack.toString());
    }
}
