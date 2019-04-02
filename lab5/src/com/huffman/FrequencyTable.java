package com.huffman;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class FrequencyTable {
    // Private
    List<Entry> list = new LinkedList<>();

    private void sort() { // Sorting function
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

    public void build(String str) { // Build frequency table
        Map<Character, Integer> chars = new HashMap<>();
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

    public String toString() {
        String str = "[";
        for (Entry item : list) {
            str += " " + item.getKey() + " - " + item.getValue() + ";";
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 1);
            str += " ";
        }
        str += "]";
        return str;
    }
}