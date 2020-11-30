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
    public static void main(String[] args){
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode forth = new ListNode();
        head.next = second;
        second.next = third;
        third.next = forth;
        head.val = 1;
        second.val = 2;
        third.val = 3;
        forth.val = 4;
        ReverseLinkedList test = new ReverseLinkedList();
        ListNode result = test.ReverseList(head);
        System.out.println(result.val);
    }
}