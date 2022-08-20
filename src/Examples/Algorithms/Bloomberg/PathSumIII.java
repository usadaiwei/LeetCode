package Examples.Algorithms.Bloomberg;

import Examples.DataStructures.TreeNode;

/*
437. Path Sum III
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 */
public class PathSumIII {
    int totalAmount = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        preCounter(root, targetSum);

        return totalAmount;
    }

    // Need preCounter because 我们需要同时计算每一小节和每一大节
    private void preCounter(TreeNode root, int targetSum){
        if (root == null)
            return;

        counter(root, 0, targetSum);

        preCounter(root.left, targetSum);
        preCounter(root.right, targetSum);
    }

    private void counter(TreeNode root, long currentSum, int targetSum){
        if (root == null)
            return;

        if (currentSum + root.val == targetSum)
            totalAmount++;

        counter(root.left, currentSum + root.val, targetSum);
        counter(root.right, currentSum + root.val, targetSum);
    }
}
