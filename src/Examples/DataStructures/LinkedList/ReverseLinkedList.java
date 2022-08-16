package Examples.DataStructures.LinkedList;

import utils.ListNode;

/* Reverse a linkedList (Easy).
 * For example, 1->2->3 becomes 1<-2<-3
 */
public class ReverseLinkedList {

    public ListNode ReverseList(ListNode head){
        ListNode current = head;
        ListNode prev = null;

        while (current != null){
            ListNode nextHolder = current.next;
            current.next = prev;
            prev = current;
            current = nextHolder;
        }

        return prev;
    }
}