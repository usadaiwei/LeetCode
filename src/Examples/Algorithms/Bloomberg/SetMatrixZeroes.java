package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        List<int[]> list = new ArrayList<>();
        // 遍历matrix， 把值为0的格子加进list里
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    int[] temp = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    list.add(temp);
                }
            }
        }
        // 把list里的格子进行处理
        for (int i = 0; i < list.size(); i++){
            int[] pair = list.get(i);
            int a = pair[0];
            int b = pair[1];
            setZero(a, b, matrix);
        }

    }

    private void setZero(int a, int b, int[][] matrix){
        // 当前格子所在的row都变成0
        for (int i = 0; i < matrix.length; i++){
            matrix[i][b] = 0;
        }

        // 当前格子所在的col都变为零
        for (int i = 0; i < matrix[0].length; i++){
            matrix[a][i] = 0;
        }
    }
}
