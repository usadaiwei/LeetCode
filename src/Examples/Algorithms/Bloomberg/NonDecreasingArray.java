package Examples.Algorithms.Bloomberg;
/*
665. Non-decreasing Array
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {

        int i = 1;
        int modified = 0;
        int prev = nums[0];
        for (i = 1; i < nums.length; i++){
            int curr = nums[i];
            if (curr < prev){
                if (modified++ == 1)
                    return false;
                if (i-2 >= 0 && nums[i-2] > curr) // nums[i-2] might be larger, need to skip prev = curr step
                    continue;
            }
            prev = curr;
        }
        return true;
    }
}
