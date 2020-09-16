package org.pg4200.ex01;

public class ArrayUtilsImp2 implements ArrayUtils{

    private void checkTheArray(int [] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("Array input is invalid");
        }

    }

    @Override
    public int min(int[] array) throws IllegalArgumentException {
        checkTheArray(array);
        int min = array[0];

        for(int i = 1; i < array.length; i++){
            int value = array[i];
            if(value < min){
                min = value;
            }
        }
        return min;
    }

    @Override
    public int max(int[] array) throws IllegalArgumentException {
        checkTheArray(array);
        int max = array[0];

        for(int i = 1; i < array.length; i++){
            int value = array[i];
            if(value > max){
                max = value;
            }
        }
        return max;
    }

    @Override
    public double mean(int[] array) throws IllegalArgumentException {
        checkTheArray(array);
        double sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum / array.length;
    }
}
