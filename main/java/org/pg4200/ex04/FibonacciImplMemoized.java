package org.pg4200.ex04;

/*
To solve this issue, we are going to use a technique called _memoization_.
Create a new version called  `FibonacciImplMemoized`, in which internally it keeps track of an
array `x` of values (e.g., `x.length=100`).
Each time we compute `f(n)` for the first time, we will store its result in `x`, i.e., `x[n]=f(n)`.
Each time we ask for `f(n)`, we check first if the value was already computed and stored in `x`.
In such case, we make no recursive call, and rather directly return `x[n]`.
*/

public class FibonacciImplMemoized implements Fibonacci{

    private final Integer [] array = new Integer[100];

    @Override
    public int compute(int n) throws IllegalArgumentException{

        //Integer [] array = new Integer[100];
        int iAL = array.length;

        if(n < 0){
            throw new IllegalArgumentException("Its not ok with negative numbers and now n was: " + n);
        }

        if(n < iAL && array[n] != null){
            return array[n];
        }

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int answer = compute(n-1) + compute(n-2);
        if(n < iAL){
            array[n] = answer;
        }

        return answer;

    }

    /*

    public int compute(int n) throws IllegalArgumentException {

        if(n < 0){
            throw new IllegalArgumentException("Its not ok with negative numbers and now n was: " + n);
        }

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return compute(n-1) + compute(n-2);

    }
    public int computeWithMemo(int n, Integer [] array) throws IllegalArgumentException {

        if(n < 0){
            throw new IllegalArgumentException("Its not ok with negative numbers and now n was: " + n);
        }

        if(array[n] != null){
            return array[n];
        }

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int answer = compute(n-1) + compute(n-2);
        array[n] = answer;
        return answer;


    }

     */
}
