package com.huffman;

class Entry implements Comparable<Entry> {
    // Private
    private Character key;
    private Integer value;

    // Public
    Entry(Character key, Integer value) {
        this.key = key;
        this.value = value;
    }

    // Getters
    Character getKey() {
        return key;
    }

    Integer getValue() {
        return value;
    }

    // Setters
    void setValue(Integer value) {
        this.value = value;
    }

    // Methods
    public String toString() {
        return String.format("(%c; %d)", key, value);
    }

    @Override
    public int compareTo(Entry other) {
        return value - other.value;
    }
}
