import com.huffman.HuffmanTree;

public class Main {
    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree("beep boop beer!");
        System.out.println(tree.getWeight());
    }
}
