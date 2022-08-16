package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        // 先sort
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();
        // 先用list<int[]>, 最后toArray()
        int[] curr = intervals[0];

        for (int[] interval : intervals){
            int currentStart = curr[0];
            int currentEnd = curr[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart){
                curr[1] = Math.max(currentEnd, nextEnd);
            } else {
                ans.add(curr);
                curr = interval;
            }
        }
        ans.add(curr);
        return ans.toArray(new int[ans.size()][2]);
    }
}
