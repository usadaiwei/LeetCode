package Examples.Algorithms.TwoPointers;

import utils.ListNode;

/* Linked List Cycle (Easy)
Given head, the head of a linked list, determine if the linked list has a cycle in it.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null && fast.next != null){
            if (slow == fast) return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
