package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        func(nums, ans, list, 0);
        return ans;
    }

    private void func(int[] nums, List<List<Integer>> ans, List<Integer> list, int from){
        if (list.size() == nums.length){
            ans.add(new ArrayList<>(list)); // 终止条件
            return;
        }

        for (int i = from; i < nums.length; i++){
            //每次把当前可以选择的数(from到nums.length-1)换到最前面
            swap(nums, from, i);
            //然后把这个数加到当前选项(cur)中
            list.add(nums[from]);
            //然后递归
            func(nums, ans, list, from+1);
            //backtrack，reset到原始的状态
            list.remove(list.size()-1);
            //backtrack，swap回来, reset到原始的状态
            swap(nums, from, i);
        }

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
