package Examples.Algorithms.Bloomberg;

import java.util.Stack;

/*
402. Remove K Digits
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        // 用stack
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++){
            int c = num.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > c && k > 0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // k might still > 0
        while (k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb.append("0"); // sb might be empty if num.length == k
        String ans = sb.reverse().toString();

        // there might be 0 at the beginning
        for (int i = 0; i < ans.length(); i++){
            if (ans.charAt(i) != '0')
                return ans.substring(i);
        }

        return "0";
    }
}

