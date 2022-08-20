package Examples.Algorithms.Bloomberg;
/*
311. Sparse Matrix Multiplication
Given two sparse matrices mat1 of size m x k and mat2 of size k x n, return the result of mat1 x mat2. You may assume that multiplication is always possible.
Input: mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]
Output: [[7,0,0],[-7,0,3]]
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] ans = new int[mat1.length][mat2[0].length];

        for (int i = 0; i < mat1.length; i++){              // i: mat1 row
            for (int k = 0; k < mat1[0].length; k++){       // k: mat1 col
                for (int j = 0; j < mat2[0].length; j++){   // j: mat2 col
                    ans[i][j] += mat1[i][k] * mat2[k][j];   // 
                }
            }
        }
        return ans;
    }
}
