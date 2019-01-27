package com.rupi.problems;

import java.util.Arrays;

public class MultinomialCombinations {


    public static void main(String[] args) {
        System.out.println(new MultinomialCombinations().numberOfCombinations(5));
    }

    private int numberOfCombinations(final int sum) {
        int[] values = new int[4];
        values[0] = sum;
        values[1] = (int) Math.sqrt(sum);
        values[2] = (int) Math.cbrt(sum);
        values[3] = (int) Math.sqrt(Math.sqrt(sum));

        int combinations = 0;
        for (int i = 0; i < 4; i++) {
            int v = values[i];
            for (int j = 0; j < 4; j++) {
                v+=values[j];
                if(v >= sum){
                    values[i] --;
                    combinations++;
                }
            }
        }

        System.out.println(Arrays.toString(values));
        return 0;
    }


}
