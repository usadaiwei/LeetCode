package Examples.Algorithms.Bloomberg;

import utils.ListNode;

/*
160. Intersection of Two Linked Lists
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b){
            a = (a == null ? headB : a.next);  // headA和headB长度不一样， 所以headA遍历对比完从headB开始再次遍历对比
            b = (b == null ? headA : b.next);  // 同理， headB遍历对比完从headA开始再次遍历对比
        }
        return a;
    }
}
