package Examples.Algorithms.Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

/*
542. 01 Matrix
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
 */
public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>(); // 用queue 是因为不一定第一个格子就是0, 如果是1的话, 很难确定它离0多远.

        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if (mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                } else
                    mat[i][j] = -1;
            }
        }

        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            for (int[] dir : dirs){
                int r = temp[0] + dir[0];
                int c = temp[1] + dir[1];

                if (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == -1){
                    queue.offer(new int[]{r, c}); // push back to the queue to check larger distance
                    mat[r][c] = mat[temp[0]][temp[1]] + 1;
                }
            }
        }
        return mat;
    }
}
