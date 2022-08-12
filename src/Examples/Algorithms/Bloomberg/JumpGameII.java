package Examples.Algorithms.Bloomberg;

/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 */
public class JumpGameII {
    int ans = Integer.MAX_VALUE;

    public int jump(int[] nums) {

        int jump = 0;
        int currMax = 0;
        int maxPos = 0;

        for (int i = 0; i < nums.length-1; i++){
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == currMax){
                jump++;
                currMax = maxPos;
            }
        }
        return jump;
    }
}
