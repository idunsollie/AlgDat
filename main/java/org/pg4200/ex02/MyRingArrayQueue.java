package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue<T> {

    protected Object[] data;

    private int head = -1;
    private int tail = -1;

    public MyRingArrayQueue(){this(10);}
    public MyRingArrayQueue(int capacity){data = new Object[capacity];}

    @Override
    public void enqueue(T value){

        //Check if the array is empty
        if(isEmpty()){
            //Sets the head and tail to 0 if it's empty
            head = 0;
            tail = 0;

        //If head is smaller or same as tail it means the array have elements
        }else if(head <= tail){

            if(tail < data.length -1){
                //Still space
                tail++;
            }else{
                //Start to fill it up from the start, but only if its space
                if(head != 0){
                    tail = 0; //-->If head !=0 it means that it's space in the start and we can start filling
                }else{
                    //If the Array is full we will copy it to a new array
                    Object[] newArray = new Object[2*data.length];

                    for (int i = 0; i < data.length; i++){
                        newArray[i] = data[i]; //--> use head to make sure you dont copy empty space
                    }
                    //head = 0;
                    tail++;
                    data = newArray;
                }
            }


        }else{
            //TODO: assert?
            //TODO: check if it's full in the back?

            if(tail < head -1){
                //Still space
                tail++;
            }else{
                //No spcae in the end and the array is totaly full, copy to new array
                Object[] newArray = new Object[2*data.length];

                //Move the elements after the head
                int placementOfHead = data.length - head;
                int placementOfTail = tail + 1;
                for(int j = 0; j < placementOfHead; j++){
                    newArray[j] = data[j + head];
                }

                //Move the elements behind tail
                for(int i = 0; i < placementOfTail; i++){
                    newArray[placementOfHead + i] = data[i];
                }
                head = 0;
                tail = data.length;
                data = newArray;
            }
        }
        data[tail] = value; //--> Puts in the data in the array according to the tail and index
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new RuntimeException();
        }

        T value = (T) data[head]; //Gets the value of head

        if(size() == 1){
            //Sets the head and tail to default if you dequeue the last element in the array
            head = -1;
            tail = -1;
        }else{
            head ++;
            if(head >= data.length){
                head = 0;
            }
        }

        return value;
    }

    @Override
    public T peek() {

        if(isEmpty()){
            throw new RuntimeException();
        }
        T value = (T) data[head];

        return value;
    }

    @Override
    public int size() {

        //TODO: how manny elemnt are in the array?

        if(head < 0){
            return 0;
        }else if(head <= tail){
            return (tail - head) + 1;
        }else{
            return (data.length - head) + (tail + 1);
        }
    }
}
