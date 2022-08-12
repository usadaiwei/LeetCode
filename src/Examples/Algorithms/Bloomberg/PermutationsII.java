package Examples.Algorithms.Bloomberg;

import java.util.*;

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.



Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class PermutationsII {
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);                                     // 先sort()
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        func(nums, ans, list, 0);
        return ans;
    }

    private void func(int[] nums, List<List<Integer>> ans, List<Integer> list, int from){
        if (list.size() == nums.length && !set.contains(list)){ // set筛除重复答案
            ans.add(new ArrayList<>(list));
            set.add(new ArrayList<>(list));                     // 加进去set 去除重复答案
            return;
        }

        for (int i = from; i < nums.length; i++){
            swap(nums, from, i);
            list.add(nums[from]);
            func(nums, ans, list, from+1);
            list.remove(list.size()-1);
            swap(nums, from, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
