package Examples.Algorithms.Bloomberg;

/*
167. Two Sum II - Input Array Is Sorted
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 */
public class TwoSumII {
    // Use two pointer
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j){
            if (numbers[i] + numbers[j] == target){
                return new int[]{i+1, j+1};
            } else if (numbers[i] + numbers[j] < target){
                i++;
            } else
                j--;
        }
        return new int[]{-1, -1};
    }
}
