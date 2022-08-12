package Examples.Algorithms.Bloomberg;

/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        if(nums == null || nums.length <= 1)
            return;

        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i+1])  // 如果前面比后面大， 算进 i
            i--;

        if (i >= 0){
            int j = n-1;
            while (nums[i] >= nums[j])          // 如果前面比后面大， 算进 j
                j--;

            swap(nums, i, j);                   // 交换i, j值
        }
        reverse(nums, i+1, n-1);                // reverse i后面的所有的值
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j){
        while (i < j)
            swap(nums, i++, j--);
    }
}
