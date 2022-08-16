package Examples.Algorithms.Bloomberg;
/*
A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
nums[i] != nums[i + 1] for all valid i.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int ans = -1;

        if (nums.length == 1)
            return 0;

        if (nums.length == 2)
            return nums[1] > nums[0] ? 1 : 0;

        for (int i = 1; i < nums.length-1; i++){
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                ans = i;
                break;
            }
        }
        if (ans == -1){                                         // if no peak at the middle, it must be at the head or at the end
            if (nums[0] > nums[1])
                return 0;
            if (nums[nums.length-1] > nums[nums.length-2])
                return nums.length-1;
        }
        return ans;
    }
}
