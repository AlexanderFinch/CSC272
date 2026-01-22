package com.recur;

public abstract class Factorial {

    /**
     * Factorial recursion solves the factorial problem (n!) defined as: n! = n * (n-1)!,
     * <p>
     * Base cases: that stops the process, typically 0! = 1 or 1! = 1;
     * <p>
     * Recursive Step: a function calls itself with a smaller input (n-1) until it hits the base case,
     * then multiplies the results back up the chain of calls.
     *
     * Results: 10 * (9 * (8 * (7 * (6 * (5 * (4 * (3 * (2 * (1))))))))) = 3,628,800
     */

    static public int factorial(int n) {
        // Base case
        int ret = 1;
        if (n == 0 || n == 1) {
            return ret;
        } else {     //Recursive case
            ret = n * factorial(n - 1);
            return ret;
        }
    }

    static public int factorial_iterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    abstract public int newFact();

    static public void main(String[] args){

        System.out.println("The factorial is: " + Factorial.factorial(10));

    }
}
