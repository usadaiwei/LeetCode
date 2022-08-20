package Examples.Algorithms.Bloomberg;
/*
611. Valid Triangle Number
Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:

Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Example 2:

Input: nums = [4,2,3,4]
Output: 4
 */

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++){
            int k = i + 2;
            for (int j = i + 1; j < nums.length; j++){
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                if (k > j) // k, as the third side of the triangle, must be the lonest side
                    sum += k - j - 1;
            }
        }
        return sum;
    }
}
