package Examples.DataStructures.LinkedList;

import utils.ListNode;

/*  (Medium)
    Given linked list: 1->2->3->4->5, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        // dummy head: dummy.next = head
        ListNode dummy = new ListNode(0);
        int length = 0;
        dummy.next = head;

        while (current != null){
            current = current.next;
            length++;
        }
        length-=n;
        current = dummy;
        while (length != 0) {
            length--;
            current = current.next;
        }
        current.next = current.next.next;
        return dummy.next;
    }
}
