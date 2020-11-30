package Examples.DataStructures.LinkedList;

import utils.ListNode;

/* Find the intersection of Two Linked Lists (Easy)
   Hint: If ListA has a+c, ListB has b+c, then (a+c)+(b+c)=(b+c)+(a+c)
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1= headA;
        ListNode l2 = headB;

        while (l1 != l2){
            if (l1 == null){
                l1 = headB;
            } else {
                l1 = l1.next;
            }

            if (l2 == null){
                l2 = headA;
            } else {
                l2 = l2.next;
            }
        }

        return l1;
    }
}
