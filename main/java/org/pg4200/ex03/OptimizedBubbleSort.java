package org.pg4200.ex03;

import org.pg4200.les03.sort.MySort;

import java.util.Arrays;
import java.util.Comparator;

/*
The method should sort the input array based on a given Comparator. The method should
return the number of times the method Comparator#compare is called.

If optimized is true, then instead of a naive bubble sort, you should run a better version.
For example, one fact that
can be exploited is that, if the last swap is done at position i, then all elements after
i are necessarily sorted.
So, in the next iteration, you do not need to check elements after i.

Write a class called OptimizedBubbleSortTest in which you test your implementation.
You need at least one test with
the following input array ["c", "b", "a", "d", "e", "f"]. On such array, you need to
verify that your optimized bubble
sort version should do less than half the comparisons than a non-optimized version.
Note: be careful to do not call
sorting twice on the same array, but rather create a new one. Add enough unit tests
until your reach 100% statement
coverage.
*/

public class OptimizedBubbleSort{


    public <T> int sort(T[] array, Comparator<T> comparator, boolean optimized){

        //Check if the array is empty
        if(array == null){
            return 0;
        }

        int counter = 0; //To have track of how many time time compare method has been executed
        boolean swapped = true; //true in the beginning so the while loop will start
        int lastSwap = array.length -1; //Keeps track of where it was the last swap for the round
        int max = array.length -1; //Keeps track of how many the for loop should run, important if optimized = true


        while (swapped == true){

            swapped = false;

            //If optimized==true it will start next for loop from where it was last swapped from the round before
            if(optimized){
                max = lastSwap;
            }

            for(int i = 0; i < max; i++){
                int j = i + 1;//j is the value after i

                //Compare i and j with the comparator
                if(comparator.compare(array[i],array[j]) > 0){

                    //Makes the swap
                    T tmp = array[i];
                    array[i] = array [j];
                    array[j] = tmp;

                    //Tells that it has been a swap and where the last swap was
                    swapped = true;
                    lastSwap = i;
                }
                counter++;
            }
        }
        return counter;//Return counter so we can compare optimized == true and optimized == false
    }

}
