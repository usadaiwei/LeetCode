package Examples.DataStructures.Arrays;
/*
Find the Duplicate Number (Medium)
There is only one repeated number in nums
Input: nums = [1,3,4,2,2]
Output: 2
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int l = 1, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l)/2;
            int count = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] <= mid)
                    count++;
            }
            if (count > mid)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}
