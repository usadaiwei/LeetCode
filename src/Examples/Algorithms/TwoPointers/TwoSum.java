package Examples.Algorithms.TwoPointers;

/* Two Sum II - Input array is sorted (Easy)
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int small = 0, large = numbers.length - 1;
        while (small < large){
            int sum = numbers[small] + numbers[large];
            if (target == sum)
                return new int[]{small + 1, large + 1};
            else if (target < sum)
                large --;
            else
                small ++;
        }
        return null;
    }
}
