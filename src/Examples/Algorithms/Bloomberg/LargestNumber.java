package Examples.Algorithms.Bloomberg;

import java.util.Arrays;

/*
179. Largest Number

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
Since the result may be very large, so you need to return a string instead of an integer.

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        Integer[] sort = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++)
            sort[i] = nums[i];

        Arrays.sort(sort, (a, b) -> {
            String aa = "" + a + b;
            String bb = "" + b + a;
            return bb.compareTo(aa);
        });

        // if biggest number is 0, then it equals to 0 anyway
        if (sort[0] == 0)
            return "0";

        StringBuilder sb = new StringBuilder();

        for (Integer i : sort)
            sb.append(i);

        return sb.toString();
    }
}
