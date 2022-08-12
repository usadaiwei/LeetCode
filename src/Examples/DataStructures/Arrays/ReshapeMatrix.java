package Examples.DataStructures.Arrays;
/*
Reshape the Matrix (Easy)
Input:
nums =
[[1,2],
 [3,4]]
r = 1, c = 4

Output:
[[1,2,3,4]]

Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 */
public class ReshapeMatrix {

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c)
            return nums;

        int[][] ans = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                ans[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2}, {3,4}};
        int[][] ans = matrixReshape(nums, 1, 4);
        for (int i = 0; i < 1; i++){
            for(int j = 0; j < 4; j++){
                System.out.println(ans[i][j]);
            }
        }
    }
}
