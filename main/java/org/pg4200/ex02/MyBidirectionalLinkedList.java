package org.pg4200.ex02;

import org.pg4200.les02.list.MyList;

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

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        if(index <= (size()%2+size())/2){
            //Start from head
            if (index == 0) {
                if(head.next != null){
                    head = head.next; //the new head will be the second node
                }else{
                    //Delete the last element and the list will be ampty
                    head = null;
                    tail = null;
                }
            }else{
                ListNode beforeNode = head;
                int counter = 0;

                /*
                beforeNode = the node before the one we want to delete
                */


                while (counter != index - 1){
                    //Use -1 to get the node before the one we want to delete
                    beforeNode = beforeNode.next;
                    counter++;
                }

                if(beforeNode.next == tail){
                    //We want to delete the tail and have to set the tail to beforeNode
                    tail = beforeNode;
                }

                //Override that the beforeNods next is the node after the node we want to delete
                beforeNode.next = beforeNode.next.next;
            }


        }else{
            //Start from tail
            ListNode afterNode = tail;
            int counter = 0;

            while (counter != +1){
                afterNode = afterNode.prev;
                counter++;
            }

            afterNode.prev = afterNode.prev.prev;

            if(index == size){
                //TODO: kill the tail?
            }

        }
        size--;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        int middle = (size()%2+size())/2;
        int counter = 0;
        ListNode thisNode;

        if(index<=middle){
            thisNode = head;

            while (thisNode != null){
                if(counter == index){
                    return thisNode.value;
                }
                thisNode = thisNode.next;
                counter++;
            }
        }else{
            thisNode = tail;

            while (thisNode != null){

                //TODO: ändra if statement så det teller rett antall ganger.
                // nu ränkar den bakifrån och till första så det blir foo.
                int test = size - index - 1;
                if (counter == test){
                    return thisNode.value;
                }
                thisNode = thisNode.prev;
                counter++;
            }

        }
        // We dont want to get here but have to write to not get an error from compiler
        assert false;
        return null;
    }



    @Override
    public void add(int index, T value) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        ListNode node = new ListNode();
        node.value = value;

        if(head == null){
            assert size == 0; //dubbelcheck if its true

            head = node;
            tail = node;
            node.next = null;
            size ++;

        }else if(index == 0){
            node.next = head; //pointer to the node after the new one
            head.prev = node; //Sets prev for the old node to the new node
            head = node; //Pointer from head to new node
            size ++;

        }else if(index == size){
            tail.next = node; //Pointer from the old last one to the new last one
            node.prev = tail;
            tail = node; //pointer from linkedlist to new tail
            size++;
        }else{
            ListNode beforeNode; // Before = after.prev
            ListNode afterNode; // After = before.next

            int middle = (size()%2+size())/2;

            //Add in a specific spot
            if (index <= middle) {
                beforeNode = head;

                //Start from head
                for(int i = 0; i < index -1; i++){
                    beforeNode = beforeNode.next;
                }

                node.next = beforeNode.next;
                beforeNode.next = node;
                size++;

            } else {
                afterNode = tail;

                //Start from tail
                for(int i = size; i > index +1; i--){
                    afterNode = afterNode.prev;
                }
                node.prev = afterNode.prev;
                afterNode.prev = node;
                size++;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

}
