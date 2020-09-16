package org.pg4200.ex05;

/*
Write a test class BinaryTreeLeftMaxDeleteTest that extends
MyMapBinarySearchTreeTest, in which you override the method
getTreeInstance() to use an instance of BinaryTreeLeftMaxDelete.
If your implementation is correct, all tests should pass.
 */

import org.pg4200.les05.MyMapBinarySearchTreeTest;
import org.pg4200.les05.MyMapTreeBased;

public class BinaryTreeLeftMaxDeleteTest extends MyMapBinarySearchTreeTest {
    @Override
    protected <K extends Comparable<K>, V> MyMapTreeBased<K, V> getTreeInstance() {
        return new BinaryTreeLeftMaxDelete();
    }
}
