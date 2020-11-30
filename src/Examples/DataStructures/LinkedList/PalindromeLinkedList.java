package Examples.DataStructures.LinkedList;

import utils.ListNode;

/*
Input: 1->2         Output: false
Input: 1->2->2->1   Output: true
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        // slow will go to middle of ListNode
        ListNode slow = head;
        ListNode fast = slow.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Disconnect second half, forming 2 LLs.
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode next = null;

        // 3. Reverse second half
        while(curr != null) {
            next = curr.next; // save
            curr.next = prev;
            prev = curr; // advance
            curr = next; // advance
        }

        // 4. Compare first half and the reversed second half.
        //    Use "head" as pointer to iterate over first LL.
        //    Use "prev" as pointer to iterate over second LL.
        while(head != null && prev != null) {
            if(head.val != prev.val)
                return false;

            head = head.next;
            prev = prev.next;
        }

        return true;
    }
}
