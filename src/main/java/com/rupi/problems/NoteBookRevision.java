package com.rupi.problems;

import java.math.BigInteger;
import java.util.Scanner;


/**
 * Alice got a notebook with N pages. Each page of the notebook has its own difficulty of the topic denoted by A[i]
 * for the i-th page. If Alice reads a page with difficulty level X, the next time she reads the page of difficulty
 * at least K * X where K is the factor given in the input.
 *
 * In the output, print the maximum length of sequence of pages that is possible to read.
 *
 *
 * For eg.
 *
 * N is the number of pages,
 * A[] is :
 * 2 9 27 81 4 6 18 243
 *
 * K = 3.
 *
 * Output: 5
 *
 * Explanation: Alice can read 2, 9, 27, 81 and 243.
 */

public class NoteBookRevision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger A[] = new BigInteger[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextBigInteger();
        }
        BigInteger K = sc.nextBigInteger();

        // Place of the ith page in the maximum length sequence.
        int[] pageCount = new int[N];

        // All the pages will have at least sub-sequence of length 1 (itself)
        for (int i = 0; i < N; i++) {
            pageCount[i] = 1;
        }

        // For a page i, increment the place of jth (i+1 to N) page if A[j] is greater than or equal to A[i]*K and
        // also temp[j] is the position of the page in the longest sub-sequence.
        for (int i = 0; i < N - 1; i++) {
            BigInteger m = A[i].multiply(K);
            for (int j = i + 1; j < N; j++) {
                if (A[j].compareTo(m) != -1 && pageCount[j] < pageCount[i] + 1) {
                    pageCount[j] = pageCount[i] + 1;
                }
            }
        }

        // Find the max position number in the temp, this is the last page of the longest sub-sequence.
        int max = pageCount[0];
        for (int i = 1; i < N; i++) {
            if (pageCount[i] > max) {
                max = pageCount[i];
            }
        }

        System.out.println(max);
    }


}
