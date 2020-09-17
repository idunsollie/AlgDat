package org.pg4200.ex04;

/*
Consider the Fibonacci number defined as `f(n) = f(n-2) + f(n-1)`,
where `f(0)=0`, and `f(1)=1`.
Extend the interface `org.pg4200.ex04.Fibonacci` by providing a recursive implementation.

Develop a test class called `FibonacciImplTest` that
does extend `org.pg4200.ex04.FibonacciTestTemplate`,
in which you test your `FibonacciImpl` implementation.
If it is correct, all but 1 test should pass.
Even if the implementation is correct, 1 test will run "forever" without a stack overflow,
due to the exponential complexity of a naive recursive version of Fibonacci.
*/

public class FibonacciImp implements Fibonacci{

    @Override
    public int compute(int n) throws IllegalArgumentException {

        if(n < 0){
            throw new IllegalArgumentException("The number can't be smaller than 0, now it was: " + n);
        }

        //If the element is 0 or 1 we know the answer
        if(n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        return compute(n-1) + compute(n-2);//Using recursion to check the elements

    }
}
