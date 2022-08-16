package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Constraints:

m == matrix.length
n == matrix[i].length
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0, left = 0, bottom = matrix.length-1, right = matrix[0].length-1;

        while (left <= right && top <= bottom){
            // traverse left to right
            for (int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }   
            top++;
            // traverse top to bottom
            for (int i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;

            // 终止条件
            if (left > right || top > bottom)
                break;

            // traverse right to left
            for (int i = right; i >= left; i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;

            // traverse bottom to top
            for (int i = bottom; i >= top; i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
