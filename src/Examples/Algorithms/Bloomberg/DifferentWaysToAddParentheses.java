package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.List;

/*
241. Different Ways to Add Parentheses
Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.



Example 1:

Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) ==  '+' || s.charAt(i) == '-' || s.charAt(i) == '*'){ // 如果当前char为运算符号
                String left = s.substring(0, i); // 拆分左边的数字
                String right = s.substring(i+1); // 拆分右边的数字
                List<Integer> l1 = diffWaysToCompute(left); // 左边递归继续找
                List<Integer> l2 = diffWaysToCompute(right); // 右边递归继续找

                // 只要有运算符号，直接计算，上面的递归会考虑所有可能性
                for (int a : l1){
                    for (int b : l2){
                        if (s.charAt(i) == '+')
                            ans.add(a + b);
                        else if (s.charAt(i) == '-')
                            ans.add(a - b);
                        else if (s.charAt(i) == '*')
                            ans.add(a * b);
                    }
                }
            }
        }

        if (ans.size() == 0)
            ans.add(Integer.parseInt(s)); // 递归到最底层 也就是单个数字的时候，会跳过上面的if逻辑，所以直接将数字加进ans
        return ans; // 递归时l1, l2的值为ans
    }
}
