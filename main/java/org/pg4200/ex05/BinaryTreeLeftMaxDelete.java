package org.pg4200.ex05;

import com.sun.source.tree.Tree;
import org.pg4200.les05.MyMapBinarySearchTree;

import javax.swing.tree.TreeNode;

/*
* When a node with two children needs to be deleted,
* instead of replacing it with the min value
* from the right-subtree, do use the max
* value from the left-subtree.
* */

public class BinaryTreeLeftMaxDelete extends MyMapBinarySearchTree {

    @Override
    protected TreeNode delete(Comparable key, TreeNode subtreeRoot) {

        if(subtreeRoot == null){
            //If the key is not found
            return null;
        }

        //Compare the key to the subtree key, save it in a int
        int comp = key.compareTo(subtreeRoot.key);

        /*Recursion*/

        //Delete left side
        if(comp < 0){
            subtreeRoot.left = delete(key,subtreeRoot.left);
            return subtreeRoot;
        }

        //Delete right side
        if(comp > 0){
            subtreeRoot.right = delete(key,subtreeRoot.right);
            return subtreeRoot;
        }

        //done with recursion and time to check if the node have children or not.
        //We tell the program that we know that comp will be 0 and that it should
        // be that at this point.
        assert comp == 0;
        size --;

        //Check if the left or the right children are not present
        if(subtreeRoot.left == null){
            return subtreeRoot.right;
        }
        if(subtreeRoot.right == null){
            return subtreeRoot.left;
        }

        //Both children are present
        TreeNode nodeTmp = subtreeRoot;
        subtreeRoot = max(nodeTmp.left);
        subtreeRoot.left = deleteMax(nodeTmp.left);
        subtreeRoot.right = nodeTmp.right;

        return subtreeRoot;
    }

    private TreeNode max(TreeNode subtreeRoot){
        if(subtreeRoot.right == null){
            return subtreeRoot;
        }
        return max(subtreeRoot.right);
    }
    private TreeNode deleteMax(TreeNode subtreeRoot){
        if(subtreeRoot.right == null){
            return subtreeRoot.left;
        }
        subtreeRoot.right = deleteMax(subtreeRoot.right);
        return subtreeRoot;
    }
}
