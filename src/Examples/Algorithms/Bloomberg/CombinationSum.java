package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        func(candidates, ans, list, 0, 0, target);
        return ans;
    }

    private void func(int[] candidates, List<List<Integer>> ans, List<Integer> list, int current, int sum, int target){
        // sum >= target时收集, 终止
        if (sum >= target){
            if (sum == target)
                ans.add(new ArrayList<Integer>(list)); // 一定要new ArrayList
            return;
        }
        // 当前搜索到最后一个int[]时，后面没了, 所以终止
        if (current == candidates.length)
            return;
        // 不管怎样 先把当前int[] 加进list里
        list.add(candidates[current]);

        // take candidates[current]
        sum = sum + candidates[current];
        func(candidates, ans, list, current, sum, target); // 继续

        // not take candidates[current]
        list.remove(list.size()-1); // 回溯
        sum = sum - candidates[current]; // 回溯
        func(candidates, ans, list, current+1, sum, target); // 下一个int[]
    }
}
