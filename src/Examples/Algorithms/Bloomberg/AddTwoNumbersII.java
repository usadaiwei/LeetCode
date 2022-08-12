package Examples.Algorithms.Bloomberg;

import utils.ListNode;
/*
Add sum of two linkedLists.
Example 1:

7 -> 2 -> 4 -> 3
     5 -> 6 -> 4
------------------
7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = reverse(l1);
        ListNode b = reverse(l2);
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        int carry = 0;

        while (a != null || b != null || carry != 0){
            int sum = 0;
            if (a != null){
                sum += a.val;
                a = a.next;
            }

            if (b != null){
                sum += b.val;
                b = b.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            pre.next = node;
            pre = pre.next;
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode node){
        if (node == null || node.next == null)
            return node;
        ListNode ans = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return ans;
    }
}
