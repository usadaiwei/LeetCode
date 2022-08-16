package Examples.Algorithms.Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPointersInEachNodeII {

    public PopulatingNextRightPointersInEachNode.Node connect(PopulatingNextRightPointersInEachNode.Node root) {
        if (root == null)
            return root;

        // 用queue 一排一排地处理
        Queue<PopulatingNextRightPointersInEachNode.Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            //record of the previous element in the same level
            PopulatingNextRightPointersInEachNode.Node pre = queue.peek();
            int size = queue.size();
            while (size-- > 0){
                //removing elements of same level and adding their children in the queue
                PopulatingNextRightPointersInEachNode.Node next = queue.poll();

                if (next.left != null)
                    queue.add(next.left);

                if (next.right != null)
                    queue.add(next.right);

                // prevent first root element
                if (pre != next){
                    //connecting pre.next to the right element
                    pre.next = next;
                    // get next element in the same level
                    pre = pre.next;
                }
            }
            //making the last element of the same level pointing to null
            pre.next = null;
        }

        return root;
    }



    // Node Definition
    class Node {
        public int val;
        public PopulatingNextRightPointersInEachNode.Node left;
        public PopulatingNextRightPointersInEachNode.Node right;
        public PopulatingNextRightPointersInEachNode.Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, PopulatingNextRightPointersInEachNode.Node _left, PopulatingNextRightPointersInEachNode.Node _right, PopulatingNextRightPointersInEachNode.Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}