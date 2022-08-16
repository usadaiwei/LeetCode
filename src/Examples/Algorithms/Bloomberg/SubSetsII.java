package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */
public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // sort to prevent duplicated results
        Arrays.sort(nums);

        backtrack(ans, list, nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> list, int[] nums, int index){
        // add here can also add null list into ans
        ans.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++){
            // check duplicated elements
            if (i > index && nums[i] == nums[i-1])
                continue;
            // else, recursive and backtrack
            list.add(nums[i]);
            backtrack(ans, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
