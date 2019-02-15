public class Main {
    public static void main(String[] args) {
        MyLinkedStack stack = new MyLinkedStack();

        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(8);
        stack.push(9);
        stack.push(5);

        System.out.println(stack.toString());
    }
}
