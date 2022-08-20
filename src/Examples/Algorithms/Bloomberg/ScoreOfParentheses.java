package Examples.Algorithms.Bloomberg;
/*
Given a balanced parentheses string s, return the score of the string.
"()" has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.

Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
Example 3:

Input: s = "()()"
Output: 2
 */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        int ans = 0;
        int deep = 0;

        char pre = '0';

        for (char c : s.toCharArray()){
            if (c == '(')
                deep++;

            else {
                deep--;
                if (pre == '('){
                    ans += Math.pow(2, deep);
                }
            }
            pre = c;
        }
        return ans;
    }
}
