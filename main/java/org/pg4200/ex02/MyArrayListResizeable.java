package org.pg4200.ex02;

import org.pg4200.les02.list.MyArrayList;

public class MyArrayListResizeable<T> extends MyArrayList<T> {

    public MyArrayListResizeable(int capacity){super(capacity);}

    @Override
    public void add(int index, T value) {
        if(index < 0 || index < size){
            throw new IndexOutOfBoundsException();
        }

        if(index >= data.length){
            //Make a new arraylist that are twice the size from the first one
            Object[] newArrayList = new Object[2* data.length];

            //Put the data inside the new array
            for(int i = 0; i < data.length; i++){
                newArrayList[i] = data[i];
            }
            data = newArrayList;
        }

        //Cal the super class so we dont have to cope the rest of the code
        super.add(index, value);
    }

}
