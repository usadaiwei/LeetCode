package Examples.Algorithms.Bloomberg;

import Examples.DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 */
public class BinaryTreePaths {
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root != null){
            search(root, "");
        }
        return ans;
    }

    private void search(TreeNode root, String path){

        if (root.left == null && root.right == null){ // 返回条件
            ans.add(path + root.val);
        }

        if (root.left != null){
            search(root.left, path + root.val + "->");
        }

        if (root.right != null){
            search(root.right, path + root.val + "->");
        }
    }
}
