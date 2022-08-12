package Examples.Algorithms.Bloomberg;

import java.util.Stack;
/*
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them,
causing the left and the right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 */

public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        Stack<Counter> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if (!stack.isEmpty() && stack.peek().ch == c)
                stack.peek().count += 1;
            else {
                Counter ct = new Counter(c, 1);
                stack.push(ct);
            }

            if (stack.peek().count == k)
                stack.pop();
        }

        while (!stack.isEmpty()){
            int count = stack.peek().count;
            while (count != 0){
                sb.append(stack.peek().ch);
                count--;
            }
            stack.pop();
        }
        return sb.reverse().toString();
    }
}

class Counter {
    public char ch;
    public int count;

    public Counter(){}
    public Counter(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}