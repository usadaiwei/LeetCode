package Examples.Algorithms.Bloomberg;
/*
516. Longest Palindromic Subsequence
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString(); // compare with the reversed string
        int[][] dp = new int[len + 1][len + 1];   // use dp[][]
        for (int i = 1; i < len+1; i++){
            for (int j = 1; j < len+1; j++){
                if (s.charAt(i-1) == reverse.charAt(j-1)){ // find largest common subSequence
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len][len];
    }
}
