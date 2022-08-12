package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109

 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        if (nums.length < 4)
            return list;

        Arrays.sort(nums);                              // Arrays.sort() is a must!!!

        for (int i = 0; i < nums.length; i++){          // first loop i = 0
            for (int j = i+1; j < nums.length; j++){    // second loop j = i+1
                int s = j + 1;                          // first pointer j+1
                int e = nums.length - 1;                // second pointer 从最后地element往前扫
                while (s < e){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[s] + (long)nums[e];
                    if (sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[s]);
                        temp.add(nums[e]);

                        if (!set.contains(temp)){
                            set.add(temp);
                            list.add(temp);
                        }
                        s++;
                        e--;
                    } else if (sum < target)
                        s++;
                    else
                        e--;
                }
            }
        }
        return list;
    }
}
