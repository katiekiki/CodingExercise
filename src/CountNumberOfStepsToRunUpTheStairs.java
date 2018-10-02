/*
  CtCi #8.1 A child is running up a staircase with n steps and can hop either 1 step, 2 steps or
  3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs.
 */

import java.util.Arrays;

public class CountNumberOfStepsToRunUpTheStairs {

    public static void main(String[] args) {

        int[] inputArray = {1,2,3,4};


        for(int i = 0; i < 25; i++) {
            System.out.println("The number of ways to run up [" + i + "] steps of stairs : [" + countWay(i) + "]");
        }

    }

    public static int countWays(int n) {

        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n-3) + countWays(n-2) + countWays(n-1);
        }

    }

    public static int countWays2(int n, int[] memo) {

        if (n < 0) {
            return 0;
        } else if (n ==1) {
            return 1;
        } else {
            if (memo[n] == -1) {
                memo[n] = countWays2(n-3, memo) + countWays2(n-2, memo) + countWays2(n-1, memo);
            }

            return memo[n];
        }
    }


    public static int countWay(int n) {

        int[] memo = new int[n+1];

        Arrays.fill(memo,-1);

        return countWays2(n,memo);

    }
}
