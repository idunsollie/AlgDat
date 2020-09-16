package org.pg4200.ex01;

/*
Using `org.pg4200.les01.array.MyArrayListString` as a
reference, implement a class called  `MyArrayListInteger`
which rather works on `Integer` objects instead of `String`.
Such class does not need to implement any interface.

Using `org.pg4200.les01.MyListStringTestTemplate`
as a reference, develop a concrete (not abstract) test class
called `MyArrayListIntegerTest`, with the same kind
of tests, buf for `MyArrayListInteger`.
Here you need to use `Integer` inputs  instead of `String`.
All tests should pass.
*/

public class MyArrayListInteger {

    //Array to backup the data
    //Int to have the control of the size
    private Integer[] data;
    private int size = 0;

    //Default constructor with max size for the tests
    public MyArrayListInteger(){
        this(10);
    }
    public MyArrayListInteger(int maxSize){
        data = new Integer[maxSize];
    }//Put the new array inside 'data'

    public Integer get(int index){
        //Check if the index from input is invalid
        if(index < 0 || index >= size){
            return null;
        }
        return data[index];//Returns data from the desired index
    }

    public void add(int value){
        data[size] = value;//Puts value in index = size
        size++;
    }

    public int size(){return size;}

}
