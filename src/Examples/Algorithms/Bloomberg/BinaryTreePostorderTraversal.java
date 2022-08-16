package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.
Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]
 */
public class BinaryTreePostorderTraversal {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {

        func(root);
        return ans;
    }

    private void func(TreeNode node){
        if (node == null)
            return;

        func(node.left);
        func(node.right);
        ans.add(node.val);  // add from the very end
    }























//Definition for a binary tree node.
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

}
