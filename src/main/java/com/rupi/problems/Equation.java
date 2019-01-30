package com.rupi.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Ques: Given an integer  S, count the total number of integral solutions of the equation a + b^2 + c^3 + d^4 <= S such
 that 0 <= a,b,c,d <= 10^3


 For e.g.:
 when S = 2

 Following are the possible number of solutions:
 0 + 0^2 + 0^3 + 0^4 = 0
 1 + 0^2 + 0^3 + 0^4 = 1
 0 + 1^2 + 0^3 + 0^4 = 1
 0 + 0^2 + 1^3 + 0^4 = 1
 0 + 0^2 + 0^3 + 1^4 = 1
 1 + 1^2 + 0^3 + 0^4 = 2
 1 + 0^2 + 1^3 + 0^4 = 2
 1 + 0^2 + 0^3 + 1^4 = 2
 0 + 1^2 + 1^3 + 0^4 = 2
 0 + 1^2 + 0^3 + 1^4 = 2
 0 + 0^2 + 1^3 + 1^4 = 2
 2 + 0^2 + 0^3 + 0^4 = 2

 Output : 12


 Note: This solutions works for S <= 10^10




 Solution Explanation: The idea is to find the number of possible values for a, b, c and d such that the equation
 does not exceed S.

  For e.g
  Input: 2
  Let f(a,b,c,d) = a + b^2 + c^3 + d^4

  For d = 2,
   f(a,b,c,d) = 16 > S, therefore, d can only have values 0 and 1.
  for d = 0, f(a,b,c,d) = 0.
        If we take c = 2, f(a,b,c,d) = 8 + 0 > S, thus, c can have values 0 and 1.
  Also, for d = 1,
        If we take c = 2, f(a,b,c,d) = 8 + 1 > S, thus c can have values 0 and 1.


  Similarly,
    when d = 0 and c = 0,
        If b = 2, f(a,b,c,d) = 4 + 0 + 0 > S, and if b = 1, f(a,b,c,d) = 1 + 0 + 0 < S, thus b = 0 and 1
    when d = 0 and c = 1,
        If b = 2, f(a,b,c,d) = 4 + 1 + 0 > S, and if b = 1, f(a,b,c,d) = 1 + 1 + 0 = S, thus b = 0 and 1
    when d = 1 and c = 0,
        If b = 2, f(a,b,c,d) = 4 + 0 + 1 > S, and if b = 1, f(a,b,c,d) = 1 + 0 + 1 = S, thus b = 0 and 1
    when d = 1 and c = 1,
        If b = 1, f(a,b,c,d) = 1 + 1 + 1 > S, and if b = 0, f(a,b,c,d) = 0 + 1 + 1 = S, thus b = 0

  So, we can have following sets in the form {b,c,d} :
  {0,0,0}
  {1,0,0}
  {0,1,0}
  {1,1,0}
  {0,0,1}
  {1,0,1}
  {0,1,1}

  Now, In similar way, we can find the possible values of a and the count of possible values of a will be the
  final solution.

 */

public class Equation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();

        long maxValue = (long) Math.pow(10, 3);

        // level d [0,s^1/4]
        /*
          Set the possible values for d, if S is greater than 10^3, set it to 10^3 else d can have value upto S^(1/4).
         */
        long dCount = S > maxValue
                ? maxValue
                : (long) Math.sqrt(Math.sqrt(S));

        // List to store sum for possible d values.
        List<Long> dNodes = new ArrayList<>();

        /*
          For all the possible d values, solve the equation 0 + d^4 and add in dNodes
         */
        for (long i = 0; i <= dCount; i++) {
            dNodes.add((long) (0 + Math.pow(i, 4)));
        }

        // level c [0, s^1/3]
        List<Long> cNodes = new ArrayList<>();
        dNodes.parallelStream().forEach(dNode ->
        {

            /*
              Set the possible values for c, if S is greater than 10^3, set it to 10^3 else c can have value upto
              S^(1/3).
             */
            final double cbrt = Math.cbrt(S - dNode);
            long cCount = cbrt > maxValue ? maxValue : (long) cbrt;
            for (long i = 0; i <= cCount; i++) {
                cNodes.add((long) (dNode + Math.pow(i, 3)));
            }
        });

        // level b [0, s^1/2]
        List<Long> bNodes = new ArrayList<>();
        cNodes.parallelStream().forEach(cNode ->
        {
            /*
              Set the possible values for b, if S is greater than 10^2, set it to 10^2 else b can have value upto
              S^(1/2).
             */
            final double sqrt = Math.sqrt(S - cNode);
            long bCount = sqrt > maxValue ? maxValue : (long) sqrt;
            for (long i = 0; i <= bCount; i++) {
                bNodes.add((long) (cNode + Math.pow(i, 2)));
            }
        });

        // level a [0,s]
        /*
            Counting all the possible a's
         */
        long aCount = S > maxValue ? maxValue : S;
        long count = bNodes.stream()
                .mapToLong(bNode -> (S - bNode) > aCount ? aCount + 1 : S - bNode + 1)
                .sum();
        System.out.println(count);
    }
}
