package com.rupi.sorting;

import java.util.Arrays;

public class StringsSorter {

    public static void main(String[] args) {
        final String[] strings = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        StringsSorter.sort(strings, 0, strings.length - 1);
        System.out.println(Arrays.toString(strings));
    }

    private static void sort(final String[] strings, final int left, final int right) {

    }


}
