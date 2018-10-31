package com.rupi.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        final int[] array = {2, 5, 1, -10, 32, 100, 3, 4, 6, 1, 0, 4};
        MergeSort.mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(final int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(final int[] array, final int left, final int middle, final int right) {
        System.out.println(left + " : " + middle + " : " + right);
        int lengthOfFirstArray = middle - left + 1;
        int lengthOfSecondArray = right - middle;
        int[] firstArrayCopy = new int[lengthOfFirstArray];
        int[] secondArrayCopy = new int[lengthOfSecondArray];

        for (int i = 0; i < lengthOfFirstArray; i++) {
            firstArrayCopy[i] = array[left + i];
        }

        for (int i = 0; i < lengthOfSecondArray; i++) {
            secondArrayCopy[i] = array[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < lengthOfFirstArray && j < lengthOfSecondArray) {
            if (firstArrayCopy[i] <= secondArrayCopy[j]) {
                array[k] = firstArrayCopy[i];
                i++;
                k++;
            } else {
                array[k] = secondArrayCopy[j];
                j++;
                k++;
            }
        }
        while (i < lengthOfFirstArray) {
            array[k] = firstArrayCopy[i];
            i++;
            k++;
        }

        while (j < lengthOfSecondArray) {
            array[k] = secondArrayCopy[j];
            j++;
            k++;
        }
    }
}
