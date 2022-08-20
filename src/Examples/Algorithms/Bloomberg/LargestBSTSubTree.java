package Examples.Algorithms.Bloomberg;
import Examples.DataStructures.TreeNode;
/*
Leetcode 333: Largest BST Subtree
Given the root of a binary tree, find the largest subtree,
which is also a Binary Search Tree (BST), where the largest means subtree has the largest number of nodes.
return 最大二叉搜索子树个数, root.cleft < root < root.right

 */

public class LargestBSTSubTree {
    class Solution {
        public int largestBSTSubtree(TreeNode root) {
            if (root == null)
                return 0;
            // 先验证是BST
            if (isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
                // 然后搜size
                return getSize(root);

            // 如果!isValidBST(root)，从它的左边或者右边child找, 对比取最大
            return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
        }

        private boolean isValidBST(TreeNode node, int min, int max){
            if (node == null)
                return true;

            if (node.val <= min || node.val >= max)
                return false;

            return (isValidBST(node.left, min, node.val)) && (isValidBST(node.right, node.val, max));
        }

        private int getSize(TreeNode root){
            if (root == null)
                return 0;

            return getSize(root.left) + getSize(root.right) + 1;
        }
    }
}

