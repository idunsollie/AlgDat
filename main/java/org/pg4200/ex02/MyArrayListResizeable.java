package org.pg4200.ex02;

import org.pg4200.les02.list.MyArrayList;

/*
Write a class called `MyArrayListResizable` that extends `MyArrayList`.

Override the method `add(int index, T value)` in a way that, if the internal array is full,
then such array should be doubled in size before inserting the new element.

Write a test class called `MyArrayListResizableTest` that extends `MyListTestTemplate`,
where the instance of `MyArrayListResizable` is initialized with capacity of 1
(i.e., the size for the internal array).
If your implementation of `MyArrayListResizable#add` is correct, then all tests should pass.
*/

public class MyArrayListResizeable<T> extends MyArrayList<T> {

    public MyArrayListResizeable(int capacity){super(capacity);}//Capacity = 10

    @Override
    public void add(int index, T value) {

        if(size == data.length){
            //Make a new arraylist that are twice the size from the first one
            Object[] newArrayList = new Object[2* data.length];

            //Copy the data into the new array
            for(int i = 0; i < data.length; i++){
                newArrayList[i] = data[i];
            }
            data = newArrayList;//Sets the data to be the content in newArrayList
        }

        //Cal the super class so we dont have to copy the rest of the code
        super.add(index, value);
    }

}
