package org.pg4200.ex04;

/*
A naive recursive version of Fibonacci is extremely inefficient, as it does an exponential number
of function calls.
When for example we compute `f(100)`, we need to compute `f(98)` and `f(99)`.
Once we are done with `f(98)`, and we start to compute `f(99)`, then `f(99) = f(97) + f(98)`,
in which we have to recompute `f(98)`.
Unfortunately, this problem happens an exponential number of times.

To solve this issue, we are going to use a technique called _memoization_.
Create a new version called  `FibonacciImplMemoized`, in which internally it keeps track of an
array `x` of values (e.g., `x.length=100`).
Each time we compute `f(n)` for the first time, we will store its result in `x`, i.e., `x[n]=f(n)`.
Each time we ask for `f(n)`, we check first if the value was already computed and stored in `x`.
In such case, we make no recursive call, and rather directly return `x[n]`.

Develop a test class called `FibonacciImplMemoizedTest` that
does extend `org.pg4200.ex04.FibonacciTestTemplate`,
in which you test your `FibonacciImplMemoized` implementation.
If it is correct, all tests should pass.
*/

public class FibonacciImplMemoized implements Fibonacci{

    private final Integer [] array = new Integer[100];

    @Override
    public int compute(int n) throws IllegalArgumentException{

        int iAL = array.length;

        if(n < 0){
            throw new IllegalArgumentException("Its not ok with negative numbers and now n was: " + n);
        }

        //If the n is smaller than the length of the array and the element of index n is not null we return the element
        if(n < iAL && array[n] != null){
            return array[n];
        }

        //If the element is 0 or 1 we know the answer
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int answer = compute(n-1) + compute(n-2);//Using recursion to check the elements

        //If n is smaller than the length of the array we set the element on n index to be the answer
        if(n < iAL){
            array[n] = answer;
        }
        return answer;
    }

}
