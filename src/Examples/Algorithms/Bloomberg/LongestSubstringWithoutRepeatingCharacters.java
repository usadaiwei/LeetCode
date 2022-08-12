package Examples.Algorithms.Bloomberg;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s, find the length of the longest substring without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        for(int i=0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                i = map.get(s.charAt(i));
                count = 0;
                map.clear();
            } else if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i); // 重点是map value存储当前index i, 而不是key出现的个数
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
