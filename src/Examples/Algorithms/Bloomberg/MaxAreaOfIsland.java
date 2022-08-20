package Examples.Algorithms.Bloomberg;
/*
695. Max Area of Island
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.

 */
public class MaxAreaOfIsland {
    int max = 0;
    int size = 0;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    func(i, j, grid);
                    max = Math.max(max, size);
                    size = 0;
                }
            }
        }
        return max;
    }

    public void func(int i, int j, int[][] grid){
        size++;
        grid[i][j] = 2;

        for (int[] dir : dirs){
            int ii = i + dir[0];
            int jj = j + dir[1];

            if (ii >= 0 && jj >= 0 && ii < grid.length && jj < grid[0].length && grid[ii][jj] == 1)
                func(ii, jj, grid);
        }
    }
}
