package Examples.Algorithms.Bloomberg;

import Examples.DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
366. Find Leaves of Binary Tree
Given the root of a binary tree, collect a tree's nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.
 */
public class FindLeavesOfBinaryTree {
    // 找到每层node的高度， 加进HashMap<高度， 包含这个高度所有node的List>
    public List<List<Integer>> findLeaves(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();// height, list of nodes in this height
        getHeight(root, map);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i : map.keySet()){
            ans.add(map.get(i));
        }
        return ans;
    }

    public int getHeight(TreeNode root, Map<Integer, List<Integer>> map){
        if (root == null)
            return -1;

        int left = getHeight(root.left, map);
        int right = getHeight(root.right, map);
        int height = Math.max(left, right) + 1;

        map.putIfAbsent(height, new ArrayList<>());
        map.get(height).add(root.val);

        return height;
    }
}
