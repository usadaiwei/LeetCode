package Examples.Algorithms.Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

/*
566. Reshape the Matrix
Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length == r || mat[0].length == c || mat.length * mat[0].length != r * c) // key: mat.length * mat[0].length != r * c
            return mat;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                queue.offer(mat[i][j]);
            }
        }

        int[][] ans = new int[r][c];

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (queue.isEmpty())
                    break;
                else
                    ans[i][j] = queue.poll();
            }
        }

        return ans;
    }
}
