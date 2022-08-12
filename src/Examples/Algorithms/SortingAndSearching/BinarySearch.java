package Examples.Algorithms.SortingAndSearching;

/*
Input : [1,2,3,4,5]
key : 3
return the index : 2
 */

public class BinarySearch {
    public int binarySearch(int[] nums, int key){
        int l = 0, h = nums.length - 1;
        while (l < h){
            int m = l + (h - l)/2;
            if (nums[m] == key) {
                return m;
            } else if (nums[m] < key){
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }
}
