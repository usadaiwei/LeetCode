package Examples.Algorithms.Bloomberg;
/*
Given an array of integers nums, sort the array in ascending order.

Quick Sort
 */
public class SortAnArray {

    public int[] sortArray(int[] nums) {
        if (nums.length == 1 || nums == null)
            return nums;

        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r){
        if (l >= r)
            return;

        int mid = helper(nums, l, r);

        quickSort(nums, l, mid);
        quickSort(nums, mid+1, r);
    }

    public int helper(int[] nums, int l, int r){
        int temp = nums[l]; // will be the mid value

        while (l < r){
            while (l < r && nums[r] >= temp)
                r--;

            nums[l] = nums[r];

            while (l < r && nums[l] <= temp)
                l++;

            nums[r] = nums[l];
        }

        nums[r] = temp; // also can be nums[l]

        return r; // can also be l
    }
}
