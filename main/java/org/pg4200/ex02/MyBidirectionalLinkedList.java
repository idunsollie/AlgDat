package org.pg4200.ex02;

import org.pg4200.les02.list.MyList;

/*
Using `MyLinkedList` as a starting point, create a new class called `MyBidirectionalLinkedList`.
Here, besides a `next` link, each node also has a `previous` link pointing to the previous node in
the list. All insert/delete operations need to properly handle and update such `previous` links.
When inserting/deleting/getting a node at position `index`, the algorithm should decide if rather start
the search from `head` using `next` links, or from `tail` using the `previous` links.
If `index <= size()/2`, it makes sense to start from `head`.
On the other hand, when `index > size()/2` it would be more efficient to start from `tail`.

Write a `MyBidirectionalLinkedListTest` that extends `MyListTestTemplate`.
If your implementation is correct, all tests should pass.
Run the tests with code coverage enabled, and verify that all of the instructions in your
code are covered. If not, add new tests to `MyBidirectionalLinkedListTest`.
*/

public class MyBidirectionalLinkedList<T> implements MyList<T> {

    private class ListNode{
        T value;
        ListNode next;
        ListNode prev;
    }
    private ListNode head;
    private ListNode tail;
    private int size;

    @Override
    public void delete(int index) {

        //check if the index is inside the list
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        int middle = (size()%2+size())/2;//Find the "middle"

        //Check the size of the array and see if the search is going to start from the head or the tail
        if(index <= middle){
            //Index is smaller than the "middle"
            //Start from head
            if (index == 0) {
                //We want to delete the first element in the list, but we have to check if it's the last as well
                if(head.next != null){
                    head = head.next; //It's not the last element and the new head will be the second node
                }else{
                    //It's the last element så we have to set the list to empty
                    head = null;
                    tail = null;
                }
            }else{
                ListNode beforeNode = head; //beforeNode = the node before the one we want to delete
                int counter = 0;

                //Use -1 to get the node before the one we want to delete (beforeNode)
                while (counter != index - 1){
                    beforeNode = beforeNode.next;
                    counter++;
                }

                //The node we want to delete is tha tail and we have to set the beforeNode to the new tail
                if(beforeNode.next == tail){
                    tail = beforeNode;
                }

                //We have found the node we want to delete so we use override to delete it
                //We override it with the node that's after the node we want to delete
                beforeNode.next = beforeNode.next.next;
            }


        }else{
            //Index is bigger than the "middle"
            //Start from tail
            ListNode afterNode = tail;//afterNode = the node after the node we want to delete
            int counter = 0;

            if(index == size){
                //We want to delete the tail and have to put the tail on the prev
                tail = afterNode.prev;
            }

            //Use +1 to get the node after the one we want to delete (afterNode)
            while (counter != +1){
                afterNode = afterNode.prev;
                counter++;
            }

            //We have found the node we want to delete so we use override to delete it
            //We override it with the node that's before the node we want to delete
            afterNode.prev = afterNode.prev.prev;

        }
        size--;
    }

    @Override
    public T get(int index) {
        //check if the index is inside the list
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        int middle = (size()%2+size())/2;//Find the "middle"
        int counter = 0;
        ListNode thisNode;

        if(index<=middle){
            //Index is smaller than the "middle"
            //Start from head
            thisNode = head;

            //Gets the right value by checking counter == index
            while (thisNode != null){
                if(counter == index){
                    return thisNode.value;
                }
                thisNode = thisNode.next;
                counter++;
            }
        }else{
            //Index is bigger than the "middle"
            //Start from tail
            thisNode = tail;

            //Gets the right value by checking counter == steps
            while (thisNode != null){
                int steps = size - index - 1;//How many steps it should take until it has reach right node
                if (counter == steps){
                    return thisNode.value;
                }
                thisNode = thisNode.prev;
                counter++;
            }
        }
        //We dont want to get here but have to write to not get an error from compiler
        assert false;
        return null;
    }

    @Override
    public void add(int index, T value) {
        //Check if the index is inside the list
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        //Create new node and put the value to requested value
        ListNode node = new ListNode();
        node.value = value;


        if(head == null){
            //The list is empty and we want to insert the first element

            assert size == 0; //Size should be 0 here

            //Set the new node to tail, head and to the last element by node.next = null;
            head = node;
            tail = node;
            node.next = null;
            size++;

        }else if(index == 0){
            //We want to insert the element on the first spot in the list

            node.next = head; //Pointer --> the node after the new one is the one that are head before inserting
            head.prev = node; //Pointer --> head before inserting will have prev pointer to new node
            head = node; //Pointer --> sets the new node to be the new head
            size++;

        }else if(index == size){
            //We want to insert the element on the last spot in the list

            tail.next = node; //Pointer --> tail.next before inserting will be the new node
            node.prev = tail; //Pointer --> tail before inserting will be the new nodes .prev
            tail = node; //Pointer --> set the new node to be the new tail
            size++;
        }else{
            //We want to put it on a specific index that's not the start or end

            ListNode beforeNode; // Before = after.prev
            ListNode afterNode; // After = before.next

            int middle = (size()%2+size())/2;//Find the "middle"

            if(index <= middle){
                //Index is smaller than the "middle"
                //Start from head
                beforeNode = head;

                //Finds the beforeNode on the left side of the list
                for(int i = 0; i < index -1; i++){
                    beforeNode = beforeNode.next;
                }

                node.next = beforeNode.next;//Pointers --> .next for the beforeNode will be the .next for the new node
                beforeNode.next = node;//Pointers --> the new .next for the beforeNode will now be the new node
                size++;

            }else{
                //Index is smaller than the "middle"
                //Start from head
                afterNode = tail;

                //Finds the afterNode on the right side of the list
                for(int i = size; i > index +1; i--){
                    afterNode = afterNode.prev;
                }
                node.prev = afterNode.prev;//Pointers --> .prev for the afterNode will be the .prev for the new node
                afterNode.prev = node;//Pointers --> the new .prev for the afterNode will be the new node
                size++;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

}
