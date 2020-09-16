package org.pg4200.ex04;

public class FibonacciImpTest extends FibonacciTestTemplate{

    @Override
    protected Fibonacci getInstance() {
        return new FibonacciImp();
    }
}
