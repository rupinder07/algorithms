package com.rupi.problems;

public class ChocolateWrapperProblem {

    public static void main(String[] args) {
        System.out.println("Max number of chocolates: " + ChocolateWrapperProblem.maxChocolates(16, 2, 2));
    }

    static int maxChocolates(final int initialMoney, final int price, final int numberOfWrapperForOneChocolate) {
        if (initialMoney <= 0) {
            return 0;
        }
        if (numberOfWrapperForOneChocolate < 2) {
            throw new IllegalArgumentException("Number of wrappers required must be greater than two");
        }
        final int numberOfChocolatesBoughtByMoney = initialMoney / price;
        return numberOfChocolatesBoughtByMoney +
                numberOfChocolatesBoughtByWrappers(numberOfChocolatesBoughtByMoney, numberOfWrapperForOneChocolate);
    }

    private static int numberOfChocolatesBoughtByWrappers(int wrappers, final int requiredWrappers) {
        int chocolates = 0;
        while (wrappers >= requiredWrappers) {
            chocolates += wrappers / requiredWrappers;
            wrappers = (wrappers / requiredWrappers) + (wrappers % requiredWrappers);
        }
        return chocolates;
    }
}
