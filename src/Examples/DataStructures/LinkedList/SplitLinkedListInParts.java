package Examples.DataStructures.LinkedList;

import utils.ListNode;

/* Split Linked List in Parts(Medium)
Input:
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
Explanation: The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 */
public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int total = 0;
        ListNode current = root;
        // Get total num of ListNode root
        while (current != null){
            total++;
            current = current.next;
        }

        int num = total / k;
        int carry = total % k;

        // init array of ListNode contains k list nodes
        ListNode[] node = new ListNode[k];
        current = root;

        for (int i = 0 ; current != null && i < k; i++){
            node[i] = current;
            int size = num + (carry-- > 0 ? 1 : 0);

            for (int j = 0; j < size - 1; j++){
                current = current.next;
            }
            ListNode next = current.next;
            current.next = null;
            current = next;
        }
        return node;
    }
}
