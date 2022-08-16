package Examples.Algorithms.Bloomberg;

import utils.ListNode;

/*
Given the head of a linked list, rotate the list to the right by k places.

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Input: head = [0,1,2], k = 4
Output: [2,0,1]
 */
public class RotateList {
    // 先把头尾相连, 再从第k的节点断开并指向null, 返回原先第k+1的节点
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        ListNode pre = new ListNode();
        ListNode start = head;
        ListNode end = head;
        int count = 1;

        while (end.next != null){
            end = end.next;
            count++;
        }
        end.next = head;

        // prevent more rotates
        if (k >= count)
            k = k % count;

        for (int i = 0; i < count-k-1; i++){
            start = start.next;
        }

        pre = start.next;
        start.next = null;

        return pre;
    }
}
