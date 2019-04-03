import com.huffman.HuffmanTree;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree("nikita kemarskiy");
        Map<Character, String> table = tree.getTable();

        System.out.println("Tree weight: " + tree.getWeight());
        for (Map.Entry<Character, String> item : table.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }

        String encoded = tree.encode("nikita kemarskiy");
        System.out.println(encoded);
    }
}
