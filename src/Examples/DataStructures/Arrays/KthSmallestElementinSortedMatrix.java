package Examples.DataStructures.Arrays;
/*
Kth Smallest Element in a Sorted Matrix ((Medium))
matrix = [
  [ 1,  5,  9],
  [10, 11, 13],
  [12, 13, 15]
],
k = 8,

return 13.
 */
class KthSmallestElementInSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];
        while (low < high){
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n && matrix[i][j] <= mid; j++){
                    count++;
                }
            }
            if (count < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
        System.out.println(kthSmallest(matrix, 2));
    }
}
