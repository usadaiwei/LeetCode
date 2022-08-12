package Examples.Algorithms.Bloomberg;

import java.util.Stack;

public class BalancedParenthesis {
    public boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c != '(' && c != ')' && c != '[' && c != ']' && c != '{' && c != '}')
                continue;
            else if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (c == ')' && (stack.isEmpty() || stack.peek() != '('))
                    return false;
                else if (c == ']' && (stack.isEmpty() || stack.peek() != '['))
                    return false;
                else if (c == '}' && (stack.isEmpty() || stack.peek() != '{'))
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

