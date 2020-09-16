package org.pg4200.ex04;

/*

Consider the Fibonacci number defined as `f(n) = f(n-2) + f(n-1)`,
where `f(0)=0`, and `f(1)=1`.
Extend the interface `org.pg4200.ex04.Fibonacci` by providing a recursive implementation.

*/

public class FibonacciImp implements Fibonacci{

    @Override
    public int compute(int n) throws IllegalArgumentException {

        if(n < 0){
            throw new IllegalArgumentException("The number can't be smaler than 0, now it was: " + n);
        }

        if(n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        return compute(n-1) + compute(n-2);

    }
}
