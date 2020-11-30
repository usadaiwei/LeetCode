package Examples.DataStructures.LinkedList;

import utils.ListNode;

/* (Easy)
    Merge two linked lists. For example:
    l1: 1->3->6, l2: 1->2->4->8
    After merge: 1->1->2->3->4->6->8
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);
        ListNode current = merged;

        while (l1 != null || l2 != null){
            if (l1 == null) {
                current.next = l2;
                break;
            }
            else if (l2 == null) {
                current.next = l1;
                break;
            }

            if (l1.val < l2.val){
                current.next = new ListNode(l1.val);
                l1 = l1.next;

            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        return merged.next;

 /*       A better way

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
*/
    }
}
