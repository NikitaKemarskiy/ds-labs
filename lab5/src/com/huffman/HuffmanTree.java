package com.huffman;

import java.util.List;
import java.util.LinkedList;

public class HuffmanTree {
    // Private
    Node root;

    // Public
    public HuffmanTree(String str) {
        build(str);
    }

    public void build(String str) {
        FrequencyTable frequencyTable = new FrequencyTable(str);
        List<Entry> frequencyList = frequencyTable.getList();
    }
}
