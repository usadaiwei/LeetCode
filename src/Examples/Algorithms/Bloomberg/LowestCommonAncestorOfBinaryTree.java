package Examples.Algorithms.Bloomberg;

import Examples.DataStructures.TreeNode;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
 */
public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)   // 边界条件
            return root;

        if (root.val == p.val || root.val == q.val) // 找到
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);     // 左边
        TreeNode right = lowestCommonAncestor(root.right, p, q);    // 右边

        if (left == null)  // 左边为空的话, 肯定在右边
            return right;

        if (right == null)  // 右边为空的话, 肯定在左边
            return left;

        return root;
    }
}
