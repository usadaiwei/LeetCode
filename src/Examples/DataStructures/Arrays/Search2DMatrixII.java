package Examples.DataStructures.Arrays;
/*
Search a 2D Matrix II (Medium)
[
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
]
 */
public class Search2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0].length == 0 || matrix.length == 0 || matrix == null)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0){
            if (target == matrix[row][col])
                return true;
            else if (target < matrix[row][col])
                col--;
            else
                row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
        System.out.println(searchMatrix(matrix, 13));
    }
}
