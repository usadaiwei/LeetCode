package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        func(candidates, target, 0, ans, list);
        return ans;
    }

    private void func(int[] arr, int target, int current, List<List<Integer>> ans, List<Integer> list){

        if (target == 0){
            ans.add(new ArrayList<>(list)); // 如果找到， 添加list并且结束
            return;
        }

        //如果没找到，从当前开始向后遍历并recursive + 回溯
        for (int i = current; i < arr.length; i++){
            if (i > current && arr[i] == arr[i-1])
                continue;
            if (target < arr[i])
                break;

            list.add(arr[i]);
            func(arr, target-arr[i], i+1, ans, list);
            list.remove(list.size()-1);
        }
    }
}
