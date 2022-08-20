package Examples.DataStructures.LinkedList;

import utils.ListNode;

import java.util.Stack;

/* Add Two Numbers II (Medium)
   carry is added in a reverse sequence, so we need to use stack.
   Input: (7 -> 2 -> 4 -> 3 -> null) + (5 -> 6 -> 4 -> null)
   Output: 7 -> 8 -> 0 -> 7 -> null
 */
public class AddTwoNumbersII {
    // 先反转两个LinkedList, 再处理
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        if (L1 == null)
            return L2;
        if (L2 == null)
            return L1;

        ListNode pre = new ListNode();
        ListNode dummy = pre;
        ListNode l1 = reverse(L1);
        ListNode l2 = reverse(L2);

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0){
            int sum = carry;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(sum % 10); // key
            carry = sum / 10;   // key
            pre.next = node;
            pre = pre.next;
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head){

        ListNode pre = null;
        ListNode node = head;
        while (node != null){
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }
}
