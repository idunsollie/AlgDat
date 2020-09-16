package org.pg4200.ex01;

public class ArrayUtilsImp implements ArrayUtils{

    private void checkTheArray(int[] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("Empty input in array");
        }

    }

    @Override
    public int min(int[] array) throws IllegalArgumentException {
        checkTheArray(array);
        int min = array[0];
        int arrayL = array.length;

        for(int i = 1; i < arrayL; i++){
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
        int arrayL = array.length;

        for(int i = 1; i < arrayL; i++){
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
        double avg = 0;
        double sum = 0;
        int arrayL = array.length;

        for(int i = 1; i < arrayL; i++){
            sum += array[i];
        }
        avg = sum / arrayL;
        return avg;
    }
}
