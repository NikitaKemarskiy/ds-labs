package com.huffman;

class Entry {
    // Private
    Character key;
    Integer value;

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
        return "(" + key + "; " + value + ")";
    }
}
