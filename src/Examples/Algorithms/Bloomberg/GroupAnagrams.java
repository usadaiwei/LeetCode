package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        // the key to solve the problem
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++){
            List<String> list;
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if (map.containsKey(s)){
                list = map.get(s);
                list.add(strs[i]);
                map.put(s, list);
            } else {
                list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }

        for (String s : map.keySet()){
            ans.add(map.get(s));
        }
        return ans;
    }
}
