package Examples.DataStructures.LinkedList;

import utils.ListNode;

// (Medium)
public class GetIntersectionNodeExistence {
    public boolean IntersectionNodeExistOrNot(ListNode A, ListNode B){
        ListNode l1 = A, l2 = B;
        if(l1 == null || B == null)
            return false;

        ListNode last1 = l1;

        while(l1.next != null){
            last1 = l1;
            l1 = l1.next;
        }
        ListNode last2 = l2;

        while (l2.next != null){
            last1 = l2;
            l2 = l2.next;
        }
        if(last1 == last2){
            return true;
        }else
            return false;
    }
}
