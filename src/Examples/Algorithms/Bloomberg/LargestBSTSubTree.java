package Examples.Algorithms.Bloomberg;
import Examples.DataStructures.TreeNode;
/*
Given the root of a binary tree, find the largest subtree,
which is also a Binary Search Tree (BST), where the largest means subtree has the largest number of nodes.
return 最大二叉搜索子树个数, root.left < root < root.right
Example: 5,1,8 答案为3
        10
       /  \
      5   15
     / \   \
    1  8    7
    /
 null

n  size min max
1 : 1,  1,  1
8 : 1,  8,  8
5 : 3,  1,  8
7 : 1,  7,  7
15: -1, 0,  0
10: -1, 0,  0

 */

public class LargestBSTSubTree {
    class Solution {
        int res = 0;

        public int largestBSTSubtree(TreeNode root) {
            if (root == null)
                return 0;
            helper(root);
            return res;
        }

        public SearchNode helper(TreeNode root){
            if (root == null)
                return new SearchNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            SearchNode left = helper(root.left);
            SearchNode right = helper(root.right);

            if (left.size == -1 || right.size == -1 || left.upper >= root.val || right.lower <= root.val)
                return new SearchNode(-1, 0, 0);
            int size = left.size + right.size + 1;
            res = Math.max(res, size);
            // 1的时候, root.val肯定比Integer.MAX_VALUE小, so lower 取Math.min(root.val, left.lower), upper同理.
            return new SearchNode(size, Math.min(root.val, left.lower), Math.max(root.val, right.upper));
        }
    }

    class SearchNode {
        int size;
        int lower;
        int upper;

        SearchNode(int size, int lower, int upper){
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
}

