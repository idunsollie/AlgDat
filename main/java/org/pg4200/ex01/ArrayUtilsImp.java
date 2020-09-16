package org.pg4200.ex01;

/*
Develop a class called `ArrayUtilsImp` that
implements the interface `org.pg4200.ex01.ArrayUtils` in
the `exercises` module.

Create a concrete test class called `ArrayUtilsImpTest` that
does extend the abstract test class `org.pg4200.ex01.ArrayUtilsTestTemplate`.
Recall that test classes are under the `src/test/java` folder.
If your implementation of `ArrayUtilsImp` is correct,
then all tests should pass.
*/

public class ArrayUtilsImp implements ArrayUtils{

    private void checkTheArray(int[] array){
        //check if the array is empty
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("Array is empty");
        }
    }

    @Override
    public int min(int[] array) throws IllegalArgumentException {

        checkTheArray(array); //Double check the array
        int min = array[0];
        int arrayL = array.length;

        for(int i = 1; i < arrayL; i++){
            int value = array[i];
            if(value < min){
                min = value;
            }
        }
        return min;//Returns the min value of the array
    }

    @Override
    public int max(int[] array) throws IllegalArgumentException {

        checkTheArray(array);//Double check the array
        int max = array[0];
        int arrayL = array.length;

        for(int i = 1; i < arrayL; i++){
            int value = array[i];
            if(value > max){
                max = value;
            }
        }
        return max;//Returns the max value of the array
    }

    @Override
    public double mean(int[] array) throws IllegalArgumentException {

        checkTheArray(array);//Double check the array
        double sum = 0;
        int iAL = array.length;

        for(int i = 0; i < iAL; i++){
            sum += array[i];
        }
        return sum / iAL;//Returns avg of sum in the array
    }
}
