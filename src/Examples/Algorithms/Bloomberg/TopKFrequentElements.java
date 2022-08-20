package Examples.Algorithms.Bloomberg;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num,0)+1);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1])); // 从小到大排序

        for (Integer i : map.keySet())
            queue.add(new int[]{i, map.get(i)});

        while (queue.size() > k)
            queue.poll();

        int[] ans = new int[k];
        int i = 0;

        while (!queue.isEmpty()){
            ans[i] = queue.poll()[0];
            i++;
        }
        return ans;
    }
}
