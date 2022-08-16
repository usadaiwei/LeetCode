package Examples.Algorithms.Bloomberg;
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */
public class NumberOfIslands {
    int[][] paths = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int total = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    total++;
                }
            }
        }
        return total;
    }

    // mark all lands nearby to 2
    public void dfs(char[][] grid, int i, int j){
        grid[i][j] = '2';

        for (int[] path : paths){
            int ii = i + path[0];
            int jj = j + path[1];

            if (ii >= 0 && jj >= 0 && ii< grid.length && jj < grid[0].length && grid[ii][jj] == '1')
                dfs(grid, ii, jj);
        }
    }
}
