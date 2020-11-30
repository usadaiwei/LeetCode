package Examples.DataStructures.LinkedList;

import utils.ListNode;

// Remove Duplicates from Sorted List (Easy)
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;

        if (list == null || list.next == null)
            return list;
        list.next = deleteDuplicates(head.next);
        if (list.val == list.next.val)
            return head.next;
        else
            return head;
    }
}
