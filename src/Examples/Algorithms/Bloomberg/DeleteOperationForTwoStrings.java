package Examples.Algorithms.Bloomberg;
/*
583. Delete Operation for Two Strings
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        // array1.length - 最长的common substring + array2.length - 最长的common subtring
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        int[][] dp = new int[c1.length+1][c2.length+1];

        for (int i = 1; i < c1.length+1; i++){
            for (int j = 1; j < c2.length+1; j++){
                if (c1[i-1] == c2[j-1])                 // key, 要-1, 不然会超出长度限制
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return c1.length + c2.length - 2*dp[c1.length][c2.length];
    }
}
