package Examples.Algorithms.Bloomberg;

import java.util.List;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] ans = new boolean[s.length()+1]; // +1 because ans[0] is not related to any char of the String
        ans[0] = true;
        for (int i = 1; i < s.length()+1; i++){
            for (int j = 0; j < i; j++){
                if (ans[j] == true && wordDict.contains(s.substring(j, i))){
                    ans[i] = true;
                    break;
                }
            }
        }
        return ans[s.length()];
    }
}
