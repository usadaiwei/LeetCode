package Examples.Algorithms.Bloomberg;

import java.util.Arrays;

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

10
9
2
2, 5
2, 3
2, 3, 7
2, 3, 7, 101
2, 3, 7, 18

 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // dp[i]表示以 nums[i] 这个数结尾的最长递增子序列的长度, 最后 dp: [1,1,1,2,2,3,4,4]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // 数组全都初始化为 1
        int ans = 1;

        for (int i = 0; i < nums.length; i++){ //nums[i]现在的格子
            for (int j = 0; j < i; j++){ // nums[j]前面的递增的最后一个格子
                if (nums[j] < nums[i]){
                    //把 nums[i] 接在后面，即可形成长度为 dp[j] + 1, 会找到不同的长度， 所以要找max
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    ans = Math.max(dp[i], ans);
                }
            }
        }
        return ans;
    }
}
