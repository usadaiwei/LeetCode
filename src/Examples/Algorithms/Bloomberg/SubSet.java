package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSet {
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    List<Integer> list = new ArrayList<>();// 用来存放符合条件结果
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0)
            return result;
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex){ // 回溯
        result.add(new ArrayList<>(list));// 加结果
        if (startIndex == nums.length){ //终止条件
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            list.add(nums[i]); // 收集结果
            backtracking(nums, i + 1); // 递归
            list.remove(list.size()-1);  // 回溯
        }
    }
}
