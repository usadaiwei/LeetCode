package Examples.Algorithms.Bloomberg;

import Examples.DataStructures.TreeNode;
/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    boolean isValid = true;
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {

        check(root);
        return isValid;
    }

    private void check(TreeNode root){
        if (root == null)
            return;

        check(root.left);

        // 右边的数都要比左边的大， 否则false
        if ((prev != null && root.val <= prev.val)){
            isValid = false;
            return;
        }

        prev = root;
        check(root.right);
    }
}
