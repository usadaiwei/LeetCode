package Examples.Algorithms.Bloomberg;
/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 */

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<String> words = new Stack<>();    // for words in []
        Stack<Integer> nums = new Stack<>();    // for integers

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){          // 是数字的话
                int num = c - '0';
                while (Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                nums.push(num);
            } else if (Character.isLetter(c)){  // 是字母的话
                words.push(c + "");
            } else if (c == '['){
                words.push("[");           // '['
            } else if (c == ']'){               // ']' 意味着 '[' 之后的左右的字母需要重复nums.pop()次
                String temp = "";
                while (words.peek() != "["){
                    temp = words.pop() + temp;
                }
                words.pop(); // stack.pop() "["

                int repeat = nums.pop();
                String inside = "";

                for (int j = 0; j < repeat; j++){
                    inside += temp;
                }

                words.push(inside);              // 要push回stack里去, 因为有可能整个整体需要再次重复, 需要继续搜索 ']'
            }
        }

        String ans = "";

        while (!words.isEmpty()){
            ans = words.pop() + ans;
        }

        return ans;
    }
}
