package com.huffman;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class FrequencyTable {
    // Private
    List<Entry> list;

    private void sort() { // Sorting method
        for (int i = 0; i < list.size() - 1; i++) {
            int max = list.get(i).getValue();
            int index = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (max < list.get(j).getValue()) {
                    index = j;
                    max = list.get(j).getValue();
                }
            }
            if (index > i) {
                Entry buff = list.get(i);
                list.add(i, list.get(index));
                list.add(index, buff);
            }
        }
    }

    // Public
    public FrequencyTable(String str) {
        build(str);
    }

    // Getters
    public List<Entry> getList() {
        return list;
    }

    // Methods
    public void build(String str) { // Build frequency table
        Map<Character, Integer> chars = new HashMap<>();
        list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (chars.containsKey(ch)) {
                chars.replace(ch, chars.get(ch) + 1);
                continue;
            }
            chars.put(ch, 1);
        }
        while (chars.size() > 0) {
            Character ch = Character.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for (Map.Entry<Character, Integer> item : chars.entrySet()) {
                if (max < item.getValue()) {
                    ch = item.getKey();
                    max = item.getValue();
                }
            }
            list.add(new Entry(ch, max));
            chars.remove(ch);
        }

        sort();
    }

    public String toString() { // To String method
        return list.toString();
    }
}
