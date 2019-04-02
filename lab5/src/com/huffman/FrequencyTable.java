package com.huffman;

import java.util.*;

class FrequencyTable {
    // Private
    List<Entry> list;

    // Public
    FrequencyTable(String str) {
        build(str);
    }

    // Getters
    List<Entry> getList() {
        return list;
    }

    // Methods
    void build(String str) { // Build frequency table
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

        Collections.sort(list, new Comparator<Entry>() {
            @Override
            public int compare(Entry entry1, Entry entry2) {
                return entry1.compareTo(entry2);
            }
        });
    }

    public String toString() { // To String method
        return list.toString();
    }
}
