package Examples.Algorithms.Bloomberg;

/*
DP经典题目
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 */

public class LongestPalindromicSubstring {

    /*
        b   a   b   a   d      (col j)
    b   T       T
    a       T       T
    b           T
    a       T       T
    d                   T      (row i) -> 从左到右搜索i， 然后从下往上搜索j

    */
    public String longestPalindrome(String s) {
        int start = 0, end = 0, max = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int i = 0; i < n; i++){ // end index
            for (int j = 0; j < i; j++){ // start index
                if (s.charAt(i) == s.charAt(j)){ // 先找aa， bb， dd， 必然true
                    if (i - j == 1 || dp[i-1][j+1]){ // 然后找到左上角，或者i - j = 1 回文中间夹杂随便一个字母
                        dp[i][j] = true;
                        if (i - j > max){
                            max = i - j;
                            end = i;
                            start = j;
                        }
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
