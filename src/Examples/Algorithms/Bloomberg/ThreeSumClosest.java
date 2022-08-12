package Examples.Algorithms.Bloomberg;

import java.util.Arrays;

/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int resSum  = Integer.MAX_VALUE;
        int resDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n-2; i++){
            int left = i+1;
            int right = n-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);

                if (diff < resDiff){
                    resSum  = sum;
                    resDiff = diff;
                }

                if (sum == target)
                    return resSum;
                else if (sum > target)
                    right--;
                else
                    left++;
            }
        }
        return resSum ;
    }
}
