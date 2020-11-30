package Examples.DataStructures.LinkedList;

import utils.ListNode;

/* Odd Even Linked List (Medium)
Example:
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        // odd list point to head of even list
        odd.next = evenHead;
        return head;
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
        OddEvenLinkedList test = new OddEvenLinkedList();
        ListNode result = test.oddEvenList(head);
        System.out.println(result.val);
    }
}
