package Examples.Algorithms.Bloomberg;

import java.util.HashSet;
import java.util.Set;

/*
DFS + StringBuilder + Set
寻找形状不相同的岛屿的总数
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Return the number of distinct islands.

Input: grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
Output: 1

Input: grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
Output: 3
 */
public class NumberOfDistinctIslands {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, sb, grid, 0, 0);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public void dfs(int i, int j, StringBuilder sb, int[][] grid, int x, int y){
        sb.append(x).append(",").append(y).append(",");
        grid[i][j] = 2;

        for (int[] dir : dirs){

            int ii = i + dir[0];
            int jj = j + dir[1];

            if (ii >= 0 && jj >= 0 && ii < grid.length && jj < grid[0].length && grid[ii][jj] == 1)
                dfs(ii, jj, sb, grid, x+dir[0], y+dir[1]);
        }
    }
}
