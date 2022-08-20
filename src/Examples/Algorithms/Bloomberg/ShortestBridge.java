package Examples.Algorithms.Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

/*
934. Shortest Bridge
An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
You may change 0's to 1's to connect the two islands to form one island.
Return the smallest number of 0's you must flip to connect the two islands.

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 */

// 先DFS找第一座桥, 全部mark成-1, 然后bfs一层一层的找
public class ShortestBridge {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    Queue<int[]> q = new LinkedList<>();
    boolean found = false;

    public int shortestBridge(int[][] grid) {
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                    dfs(grid, i, j);
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }

        return bfs(grid);
    }

    private void dfs(int[][] grid, int i, int j){
        grid[i][j] = -1;

        for (int[] dir : dirs){
            int ii = i + dir[0];
            int jj = j + dir[1];

            if (ii >= 0 && jj >= 0 && ii < grid.length && jj < grid[0].length && grid[ii][jj] == 1){
                q.offer(new int[]{ii, jj});
                dfs(grid, ii, jj);
            }
        }
    }

    private int bfs(int[][] grid){
        int distance = 0;

        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){ // current distance search size
                int[] temp = q.poll();

                for (int[] dir : dirs){
                    int i = temp[0] + dir[0];
                    int j = temp[1] + dir[1];

                    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1)
                        continue;

                    if (grid[i][j] == 1)
                        return distance;

                    else if (grid[i][j] == 0){
                        grid[i][j] = -1;
                        q.offer(new int[]{i, j});
                    }
                }
            }
            distance++; // next distance search
        }
        return -1;
    }
}
