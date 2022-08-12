package Examples.Algorithms.Bloomberg;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') // 记得一定要先检查 stack.isEmpty()
                stack.pop();
            else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') // 记得一定要先检查 stack.isEmpty()
                stack.pop();
            else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') // 记得一定要先检查 stack.isEmpty()
                stack.pop();
            else
                return false; // 其他情况直接 return false;
        }
        return stack.isEmpty();
    }
}
