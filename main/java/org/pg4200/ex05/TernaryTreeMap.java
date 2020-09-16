package org.pg4200.ex05;
import java.util.Objects;

/*
* Write a class called TernaryTreeMap that extends MyMapTreeBased.
* This class should be similar to MyMapBinaryTree, but with a major
* difference: each node contains two elements (first and second),
*
* instead of just one, and three children (left, middle and right).
* Their ordering relation should be left < first < middle < second < right.
* */

import org.pg4200.les05.MyMapTreeBased;

public class TernaryTreeMap<K extends Comparable<K>, V> implements MyMapTreeBased<K,V>{
    /*
    protected class TreeNodeTwo{
        public K key;
        public V value;

        public TreeNodeTwo left;
        public TreeNodeTwo right;

    }*/
    protected class TreeNodeThree{
        public K key, keyTwo;
        public V value, valueTwo;

        public TreeNodeThree left;
        public TreeNodeThree right;
        public TreeNodeThree middle;

    }

    protected TreeNodeThree root;
    protected int size;


    @Override
    public void put(K key, V value) {
        if (key == null){
            throw new NullPointerException();
        }

        root = put(key, value, root);
    }

    private TreeNodeThree put(K key, V value, TreeNodeThree subtree){

        //If subtree is empty, create 2-node root
        if(subtree == null){
            TreeNodeThree node = new TreeNodeThree();
            node.key = key;
            node.value = value;
            size++;
            return node;
        }

        //Compare the current key with the subtree key
        int comp = key.compareTo(subtree.key);

        if(comp < 0){
            //The current key is smaller then the subtree key and we go left in the tree
            subtree.left = put(key, value, subtree.left);
        }else if(comp > 0){
            //The current key is large then the subtree key

            //Check if the subtree have is an 2 or 3 node
            if(subtree.keyTwo == null){

                //This means that the subtree only have one key and it is a 2 node
                //Add the current node to the subtree and make the subtree a 3 node
                subtree.keyTwo = key;
                subtree.valueTwo = value;
                size++;
            }else{
                //Have to check the keyTwo in the subtree
                int comp2 = key.compareTo(subtree.keyTwo);

                if(comp2 < 0){
                    //The current key is smaller then the subtree key
                    //TODO: lägg in middle
                    subtree.left = put(key, value, subtree.left);
                }else if(comp2 > 0){
                    //The current key is larger then the subtree key
                    //TODO: lägg in middle
                    subtree.right = put(key, value, subtree.right);
                }

                //The current key is the same as the subtree key
                //Override the value of keyTwo in the subtree to the current/new value
                assert comp2 == 0;
                subtree.valueTwo = value;

            }
        }
        return subtree;

    }

    @Override
    public void delete(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        root = delete(key, root);
    }

    protected TreeNodeThree delete(K key, TreeNodeThree subtreeRoot){
        //If key is not found
        if(subtreeRoot == null){
            return null;
        }

        //Compare on key one
        int comp = key.compareTo(subtreeRoot.key);

        if(comp < 0){
            //Recursion on the left side
            subtreeRoot.left = delete(key,subtreeRoot.left);
            return subtreeRoot;

        }else if(comp > 0){
            //Recursion on the left side
            subtreeRoot.left = delete(key,subtreeRoot.left);
            return subtreeRoot;
        }

        //This means that we have found what we want to delete
        assert comp == 0;
        size--;

        //When we have delete something we have to se how many children the node has

    }

    @Override
    public Object get(Comparable key) {
        return null;
    }

    @Override
    public int getMaxTreeDepth() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }
}
