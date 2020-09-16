package org.pg4200.ex01;

public class MyArrayListInteger {

    //Array to backup the data and int to have the controll of the size
    private Integer[] data;
    private int size = 0;

    //Deafult constructor with max size
    public MyArrayListInteger(){
        this(10);
    }

    public MyArrayListInteger(int maxSize){
        data = new Integer[maxSize];
    }


    public Integer get(int index){
        if(index < 0 || index >= size){
            //If the input and index is a value that is invalid
            return null;
        }
        return data[index];
    }

    public void add(int value){
        data[size] = value;
        size++;
    }

    public int size(){return size;}

}
