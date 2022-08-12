package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]

 */

// 记住回溯模板
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;

        int n = digits.length();
        HashMap<Character, String> map = new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backTrack(digits, 0, map, new StringBuilder(), ans);
        return ans;
    }

    private void backTrack(String digits, int i, HashMap<Character, String> map, StringBuilder sb, List<String> ans){
        if (i == digits.length()){
            ans.add(sb.toString()); // collect and return statement
            return;
        }

        String curr = map.get(digits.charAt(i));
        for (int j = 0; j < curr.length(); j++){ // 条件
            sb.append(curr.charAt(j));  // 条件下地处理逻辑
            backTrack(digits, i+1, map, sb, ans); // 回溯
            sb.deleteCharAt(sb.length()-1); // remove last element
        }
    }
}
