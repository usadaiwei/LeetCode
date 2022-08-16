package Examples.Algorithms.Bloomberg;
/*
209. Minimum Size Subarray Sum
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0; // two pointer, 先从头加, 加到sum >= target为止
        int j = 0; // 再从头开始减
        int min = Integer.MAX_VALUE;

        while (i < nums.length && j < nums.length){
            sum += nums[i];

            if (sum >= target){
                while (sum >= target){
                    sum -= nums[j];
                    j++;
                }
                min = Math.min(min, i-j+2);
            }
            i++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
