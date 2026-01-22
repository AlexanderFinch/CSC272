package com.recur;

public class RangeSum {

    /** Definition: Add numbers from 1 up to the provided number: N + sum(N-1)
     *
     * Base case: like reaching zero or the end of an array
     *
     * Recursive step: Summing a range with a function that adds the current number to the sum of the rest of the range,
     * stopping at a base case (like reaching zero or the end of an array) and adding results back up the call stack.
     *
     * Results: range 10 = 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 55
     *
     * Results: range 10 = 10 + (9 + (8 + (7 + (6 + (5 + (4 + (3 + (2 + (1))))))))) = 55
     */

    public int sum(int k) {
        if(k <= 0)
            return 0;

        return k + sum(k - 1);
    }

    public int sum2(int k){
        int returnValue = 0;
        for(int i = 1; i <=k; i++){
            returnValue += i;
        }
        return returnValue;
    }

    /**
     * When to choose recursion:
     * Hierarchical/Nested Data: Working with trees (file systems, organizational charts), graphs (social networks), or nested JSON/XML structures.
     * Self-Similar Problems: Tasks that can be defined as solving a simpler version of the same problem (e.g., factorial, Fibonacci).
     * Elegant Code: When the recursive solution is significantly cleaner and easier to understand than an iterative loop.
     * Branching Paths: Searching complex structures with many potential paths, like a file system, where you need to explore multiple branches.
     * Common Use Cases:
     * Tree/Graph Traversal: Finding nodes, summing values, or mapping data.
     * Sorting Algorithms: Merge Sort, Quick Sort.
     * Pathfinding: Finding routes in graphs or games.
     * Parsing: Handling nested data formats like XML or JSON.
     */

    public static void main(String[] args){
        RangeSum rangeSum = new RangeSum();
        System.out.println("The value of the range is: " + rangeSum.sum(11));

    }
}
