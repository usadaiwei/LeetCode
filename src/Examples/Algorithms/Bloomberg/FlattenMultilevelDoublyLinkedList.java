package Examples.Algorithms.Bloomberg;

import Examples.DataStructures.Node;
/*
You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer.
This child pointer may or may not point to a separate doubly linked list, also containing these special nodes.
These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level,
doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

 */
public class FlattenMultilevelDoublyLinkedList {
    Node A;
    Node B;
    Node C;
    Node D;

    public Node getLast(Node curr){
        if (curr.next != null){
            curr = getLast(curr.next);
        }
        return curr;
    }

    public Node flatten(Node head) {
        Node curr = head;
        Node pre = curr;
        if (curr == null) return curr;
        while (curr != null){
            if (curr.child != null)
                attach(curr);
            curr = curr.next;
        }
        return pre;
    }

    public void attach(Node curr){
        A = curr;
        B = curr.child;
        C = getLast(curr.child);
        D = curr.next;

        A.next = B;
        B.prev = A;
        C.next = D;
        if (D != null)
            D.prev = C;
        A.child = null;
    }


}
