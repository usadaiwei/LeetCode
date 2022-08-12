package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
 */
public class GenerateParentheses {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        handle("", 0, 0, n);
        return ans;
    }

    public void handle(String s, int left, int right, int max){

        if (right == max){ // return case
            ans.add(s);
            return;
        }

        if (left < max){ // < max
            StringBuilder sb = new StringBuilder(s);
            sb.append("(");
            handle(sb.toString(), left+1, right, max);
        }

        if (left > right){
            StringBuilder sb = new StringBuilder(s);
            sb.append(")");
            handle(sb.toString(), left, right+1, max);
        }
    }
}
