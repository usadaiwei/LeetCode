package Examples.DataStructures.Arrays;
/*
Max Chunks To Make Sorted (Medium)
Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 */
public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null) return 0;
        int ans = 0;
        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right == i)
                 ans++;
        }
        return ans;
    }
}
