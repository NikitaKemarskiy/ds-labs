package com.random;

public class Random {
    // Private
    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lower = upper.toLowerCase();
    private static final String digits = "0123456789";
    private static final String symbols = upper + lower + digits;

    private Random() {}

    // Public
    static public String randomString(int size) {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += symbols.charAt((int)(Math.random() * symbols.length()));
        }
        return str;
    }
}
