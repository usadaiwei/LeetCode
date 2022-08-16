package Examples.Algorithms.Bloomberg;

import Examples.DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
 */
public class PathSumII {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null)
            return ans;  // 最开始root检查，如果null， 直接返回空集

        list.add(root.val); // 当前value加进list

        if (root.left == null && root.right == null)
            if (root.val == targetSum)  // 检查逻辑
                ans.add(new ArrayList<>(list)); // 收集逻辑

        pathSum(root.left, targetSum - root.val);
        pathSum(root.right, targetSum - root.val);
        list.remove(list.size()-1); // 回溯

        return ans; // 最后返回结果
    }
}
