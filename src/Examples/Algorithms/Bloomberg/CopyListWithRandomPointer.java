package Examples.Algorithms.Bloomberg;

import java.util.HashMap;

/*
LeetCode 138:

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of
its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list
and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class CopyListWithRandomPointer {
    // 储存Node head， 和对应copy这个head的temp Node
    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        Node temp = head; // 因为后面还要用到head， head不能变， 用temp代替
        Node prev = null;
        // 处理next
        while (temp != null){
            Node newHead = new Node(temp.val);
            map.put(temp, newHead); // 加进hashmap

            if (prev != null)
                prev.next = newHead; // 前面的.next = 现在的
            prev = newHead;
            temp = temp.next; // 重复循环
        }

        // 初始化temp
        temp = head;
        // 处理random
        while (temp != null){
            Node newHead = map.get(temp);
            newHead.random = map.get(temp.random);

            temp = temp.next; // 重复循环
        }

        return map.get(head);
    }











    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
