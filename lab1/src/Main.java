public class Main {
    public static void main(String[] args) {
        MyArrayStack<Integer> arrayStack = new MyArrayStack<>(Integer.class);
        MyLinkedStack<Integer> linkedStack = new MyLinkedStack<>();

        try {
            arrayStack.push(3);
            arrayStack.push(4);
            arrayStack.push(1);
            arrayStack.push(8);
            arrayStack.push(9);
            arrayStack.push(5);
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
        }

        try {
            System.out.println(arrayStack.top());
            System.out.println(arrayStack.top());
            System.out.println(arrayStack.top());
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
        }

        System.out.println("Size: " + arrayStack.size());

        try {
            while (!arrayStack.isEmpty()) {
                System.out.println(arrayStack.pop());
            }
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
        }

        System.out.println("Size: " + arrayStack.size());
        System.out.println(arrayStack.toString());
    }
}
