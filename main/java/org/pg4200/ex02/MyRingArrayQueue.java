package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

/*
Write a class called `MyRingArrayQueue` that implements `MyQueue`.
Internally, it should be similar to the implementation of `MyQueueArray`,
but with a fundamental performance improvement.
When by adding many elements the `tail` index reaches the end of the internal array,
**instead of** shifting elements to the left or copying over to a new larger array,
the `tail` should start back from `0`, unless of course `head==0`.

The idea is to reuse the empty spaces before `head` when `head>0`.
Note, when `head==0`, or when `tail` increases so much that it reaches `head`, then it would
mean that the array is completely full, and you need to copy over to a new internal array.

Write a `MyRingArrayQueueTest` that extends `MyQueueTestTemplate`.
If your implementation is correct, all tests should pass.
Run the tests with code coverage enabled, and verify that all of the instructions in your
code are covered. If not, add new tests to `MyRingArrayQueueTest`.
*/

public class MyRingArrayQueue<T> implements MyQueue<T> {

    protected Object[] data;
    //Default values for the start
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

            //Check if its space in the end of the array
            if(tail < data.length -1){
                tail++;//This will be the index for where the value should be inserted
            }else{
                //Its not space in the end of the array so we have to check if its space in the start of the array

                if(head != 0){
                    //If the head != 0 it means it space before the head hand we can fill values in the start of the array
                    tail = 0;//This will be the index for where the values should be inserted
                }else{
                    //The array is full so we make the array double it size and copy it over

                    Object[] newArray = new Object[2*data.length];
                    for (int i = 0; i < data.length; i++){
                        newArray[i] = data[i];
                    }
                    tail++;//This will be the index for where the values should be inserted
                    data = newArray;//Sets the data to be get the value from the copy
                }
            }
        }else{
            //The tail is smaller than the head
            if(tail < head -1){
                //This means that it's still space between the tail and head
                tail++;//This will be the index for where the values should be inserted
            }else{
                //The array is full so we make the array double it size and copy it over
                Object[] newArray = new Object[2*data.length];
                
                //To make sure that all the elements in thw new array will be in the right order we will 
                // move one part of the time
                
                int amountCopyHead = data.length - head;
                int amountCopyTail = tail + 1;
                
                //Copy elements ¨
                for(int i = 0; i < amountCopyHead; i++){
                    newArray[i] = data[i + head];
                }

                //Move the elements behind tail
                for(int j = 0; j < amountCopyTail; j++){
                    newArray[amountCopyHead + j] = data[j];
                }

                //Sets the head and tail to standard
                head = 0;
                tail = data.length;
                data = newArray;
            }
        }
        data[tail] = value; //--> Puts in the data in the array according to the tail and index
    }

    @Override
    public T dequeue() {
        //Check if the array is empty
        if(isEmpty()){
            throw new RuntimeException();
        }

        T value = (T) data[head]; //Gets the value of head

        if(size() == 1){
            //We want to dequeue the last element and have to set the head and tail to the default values
            head = -1;
            tail = -1;
        }else{
            head ++;//Change the head to the next in the queue

            //If the array is not empty we want to set the head to be the first element of the queue
            if(head >= data.length){
                head = 0;
            }
        }

        return value;//Return the value
    }

    @Override
    public T peek() {
        //Check if the array is empty
        if(isEmpty()){
            throw new RuntimeException();
        }
        T value = (T) data[head];//Gets the value of head

        return value;
    }

    @Override
    public int size() {

        if(head < 0){
            //Array is empty
            return 0;
        }else if(head <= tail){
            //Head are smaller or same as tail so we have a "normal" array
            return (tail - head) + 1;
        }else{
            //Head are bigger than tail so we have a "unmoral" array
            return (data.length - head) + (tail + 1);
        }
    }
}
