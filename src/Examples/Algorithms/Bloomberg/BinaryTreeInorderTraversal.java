package Examples.Algorithms.Bloomberg;

import Examples.DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
94. Binary Tree Inorder Traversal
Given the root of a binary tree, return the inorder traversal of its nodes' values.
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]
 */
public class BinaryTreeInorderTraversal {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        helper(root);
        return ans;
    }

    public void helper(TreeNode root){
        if (root == null)
            return;

        helper(root.left);

        ans.add(root.val); // Just need to add root.val before calling helper(root.right)

        helper(root.right);
    }
}
