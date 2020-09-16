package org.pg4200.ex04;

/*
        Write a class `MixedSort` that extends `MySort`. It should implement a Merge Sort algorithm.
        However, when recursively it arrives to sort a sub-section of the array with size less than
        a certain threshold, eg `high - low < bubbleLimit` where `bubbleLimit` can be for example `4`,
        then it should rather use a Bubble Sort to sort that subsection of the array.

        Explain what might be the *possible* benefits of doing something like this.

        Write a test class that extends `SortTestTemplate` to test if your `MixedSort` implementation is correct.
*/

import org.pg4200.les03.sort.MySort;

public class MixedSort implements MySort {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {

        if(array == null){
            return;
        }

        int iAL = array.length;

        T[] array2 = (T[]) new Comparable[iAL];
        mergeSort(0, iAL -1, array, array2);


    }

    public <T extends Comparable<T>> void bubbleSort(int low, int high, T[] array){

        int iLastSwap = high;
        int iTarget = high;
        boolean bSwap = true;

        while (bSwap){
            bSwap = false;
            iTarget = iLastSwap;

            for(int i = low; i < iTarget; i++){
                int j = i + 1;
                if(array[i].compareTo(array[j]) > 0){
                    T tTmp = array[i];
                    array[i] = array[j];
                    array[j] = tTmp;

                    bSwap = true;
                    iLastSwap = i;
                }
            }

        }

    }

    public <T extends Comparable<T>> void mergeSort (int low, int high, T[] array, T[] array2){

        if(low >= high){
            return;
        }

        int bubbleLimit = 4;

        if((high - low) < bubbleLimit){
            bubbleSort(low, high, array);
            return;
        }else{
            int middle = low + (high - low) / 2;
            mergeSort(low, middle, array, array2);
            mergeSort(middle+1, high, array, array2);
            merge(low, middle, high, array, array2);
        }


    }

    public <T extends Comparable<T>> void merge(int low, int middle, int high, T[] array, T[] array2){
        for (int i = low; i <= high; i++){
            array2[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (array2[i].compareTo(array2[j]) <= 0) {
                array[k] = array2[i];
                i++;
            } else {
                array[k] = array2[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = array2[i];
            k++;
            i++;
        }

    }
}
