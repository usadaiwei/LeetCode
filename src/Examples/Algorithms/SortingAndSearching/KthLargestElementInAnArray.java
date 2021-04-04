package Examples.Algorithms.Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

/* Kth Largest Element in an Array (Medium)
Input: [3,2,1,5,6,4] and k = 2
Output: 5
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // Solve by Heap
    public int findKthLargestUsingHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            // Make sure the size of heap <= k
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}
