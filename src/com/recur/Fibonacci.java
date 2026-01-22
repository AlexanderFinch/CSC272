package com.recur;

/**
 * Definition:
 * The Fibonacci sequence is defined as (F(n)=F(n-1)+F(n-2)).
 * <p>
 * Base Cases: The recursion stops at the simplest conditions: if (n) is 0, return 0; if (n) is 1, return 1.
 * <p>
 * Recursive Step: For any (n>1), the function calls itself twice, once for (n-1) and once for (n-2), then adds the results.
 * <p>
 * Results: 1,1,2,3,5,8,13,21,34,55...
 *
 * n-2 = 0
 * n-1 = 1
 * sum = 1
 *
 * 28657
 * 46368
 * 75,025
 *
 */
public class Fibonacci {

    // enums
    // static and/or final variables
    // member variables
    // member methods
    // static methods
    // main

    private static int fibonacci(int n) {
        if(n == 0)
            return n;
        if(n == 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciIterator(int n){
        // TODO: show this update

        //  need to keep track of the first (n-2) and second (n-1) terms
        int firstTerm = 0;
        int secondTerm = 1;
        // nextTerm will hold the addition of the 2 terms and also act as the return value
        int nextTerm = 0;
        for(int i = 0; i <= n - 2; i++){ // iterate through i = 0 to n - 2. This is because we already have the n-2 and n-1 as first and second terms
            nextTerm = firstTerm + secondTerm; // first iteration simply adds 0 (n-2) and 1 (n-1)
            firstTerm = secondTerm; // since we add the last two terms, save the second term into the first to prep for the next iteration
            secondTerm = nextTerm; // since we add the last two terms, save the next into the second to prep for the next iteration
        }
        return nextTerm;
    }

    public static void main(String[] args) {
        int in = 25;
        System.out.println("Fibonacci value is: " + Fibonacci.fibonacci(in));
        System.out.println("Fibonacci Iterator value is: " + Fibonacci.fibonacciIterator(in));
    }
}
