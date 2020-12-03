package Examples.DataStructures.LinkedList;

import utils.ListNode;

import java.util.Stack;

/* Add Two Numbers II (Medium)
   Input: (7 -> 2 -> 4 -> 3 -> null) + (5 -> 6 -> 4 -> null)
   Output: 7 -> 8 -> 0 -> 7 -> null
 */
public class AddTwoNumbersII {


    public ListNode addTwoNumbersNormalWay(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        Stack<Integer> s = new Stack<>();
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        // int carry
        int c = 0;
        // add l1, l2 to Stack s1, s2, then they will come out in reverse sequence
        while(l1 != null){
            s1.add(l1);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.add(l2);
            l2 = l2.next;
        }
        // add sum and carry into stack s
        while(!s1.isEmpty() || !s2.isEmpty() || c != 0){
            int n1 = 0;
            if(!s1.isEmpty()){
                // pop(): shows the element on the top of the Stack and remove it
                n1 = s1.pop().val;
            }

            int n2 = 0;
            if(!s2.isEmpty()){
                n2 = s2.pop().val;
            }

            int result = n1 + n2 + c;
            // if carry = 1
            if(result >= 10){
                c =  result / 10;
                result %= 10;
            }else{
                c = 0;
            }
            s.add(result);
        }

        ListNode root = null;
        ListNode node = null;

        while(!s.isEmpty()){
            int val = s.pop();
            if(root == null){
                // keep the root for returning
                root = new ListNode(val);
                node = root;
            }else{
                node.next = new ListNode(val);
                node = node.next;
            }
        }
        return root;
    }
}
