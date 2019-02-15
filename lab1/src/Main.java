public class Main {
    public static void main(String[] args) {
        MyArrayStack stack = null;

        try {
            stack = new MyArrayStack(16);
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
        }

        try {
            stack.push(3);
            stack.push(4);
            stack.push(1);
            stack.push(8);
            stack.push(9);
            stack.push(5);
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
        }

        System.out.println(stack.toString());
    }
}
