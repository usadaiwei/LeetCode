package Examples.Algorithms.DynamicProgramming;

/*
Given the two integers m and n, return the number of possible unique paths that the robot can take from top-left corner to reach the bottom-right corner. Only can move to right or to bottom.

First we set all the blocks in "row 0" as 1 becase there is only 1 way to reach any of those blocs and same for "col 0"
now for the dp[i][j] block the no. of ways to reach is 2 from top or from left
1.) from the top of it i.e dp[i-1][j]
2.) from the left of it ie. dp[i][j-1]
3.)now we add these two and get the total no of ways for that column and update it
4.the final table looks like this and we return the last block i.e dp[m-1][n-1]
0 [1, 1, 1, 1, 1, 1, 1]
1 [1, 2, 3, 4, 5, 6, 7]
2 [1, 3, 6, 10, 15, 21, 28]
 */
public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
