package Examples.Algorithms.Bloomberg;

public class RotateImage {
    public void rotate(int[][] matrix) {
        /*  Before:
            1   2   3
            4   5   6
            7   8   9

            After 1st:
            1   4   7
            2   5   8
            3   6   9

            After 2nd:
            7   4   1
            8   5   2
            9   6   3
        */

        // 1st rotate, 以159这条斜线为镜面，rotate对称位置的值
        for (int i = 0; i< matrix.length; i++){
            for (int j = i; j < matrix.length; j++){ // j starts from i
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2nd replace
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length/2; j++){ // 只需要对调左半边和右半边
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
