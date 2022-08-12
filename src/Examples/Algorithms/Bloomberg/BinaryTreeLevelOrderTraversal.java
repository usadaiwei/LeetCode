package Examples.Algorithms.Bloomberg;

import Examples.DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++){

                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            if (list.size() != 0)
                ans.add(list);
        }
        return ans;
    }
}
