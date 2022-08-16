package Examples.Algorithms.Bloomberg;
/*
238. Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {
    // 乍一看ans[i]可以用所有数字的乘积除以nums[i]来得到, 但是要求O(n)复杂度，
    // 所以ans[i] = nums[i]左边所有数的乘积 * nums[i]右边所有数的乘积
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        // L 存储的是L[i]左边所有的乘积
        // nums: 1, 2, 3, 4
        //    L: 1, 1, 2, 6
        L[0] = 1; // nums[0]左边没有乘积，默认为1
        for (int i = 1; i < nums.length; i++)
            L[i] = L[i-1] * nums[i-1];


        // R 存储的是R[i]右边所有的乘积
        // nums: 1,  2, 3, 4
        // R:   24, 12, 4, 1
        R[nums.length-1] = 1; // nums[nums.length-1]的右边没有乘积， 默认为1
        for (int i = nums.length-2; i >= 0; i--){
            R[i] = R[i+1] * nums[i+1];
        }

        // ans[i] = 左边的乘积 * 右边的乘积
        for (int i = 0; i < nums.length; i++){
            ans[i] = L[i] * R[i];
        }

        return ans;
    }
}
