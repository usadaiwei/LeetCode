package Examples.Algorithms.TwoPointers;

/* Merge Sorted Array (Easy)
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n -1;
        while (i >= 0 || j >= 0){
            if (i < 0)
                nums1[k--] = nums2[j--];
            else if (j < 0)
                nums1[k--] = nums1[i--];
            else if (nums1[i] < nums2[j]){
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
    }
}
