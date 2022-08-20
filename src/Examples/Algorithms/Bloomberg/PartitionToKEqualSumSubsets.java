package Examples.Algorithms.Bloomberg;

import java.util.Arrays;

/*
698. Partition to K Equal Sum Subsets
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Example 2:
Input: nums = [1,2,3,4], k = 3
Output: false
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = 0;

        for (int num : nums){
            sum += num;
            max = Math.max(max, num);
        }

        int target = sum/k;

        if (sum%k != 0 || max > target)
            return false;

        int[] sub= new int[k];
        int endIndex = nums.length-1;
        Arrays.sort(nums);

        return helper(nums, sub, target, endIndex);
    }

    private boolean helper(int[] nums, int[] sub, int t, int end){
        if (end == -1){
            for (int i : sub){
                if (i != t)
                    return false;
                return true;
            }
        }

        for (int i = 0; i < sub.length; i++){
            if (i-1 >= 0 && sub[i-1] == 0) // key point
                break;
            if (sub[i] + nums[end] <= t){
                sub[i] += nums[end];
                if (helper(nums, sub, t, end-1))
                    return true;
                sub[i] -= nums[end];
            }
        }
        return false;
    }
}
