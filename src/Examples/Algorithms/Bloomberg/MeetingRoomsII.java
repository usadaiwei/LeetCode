package Examples.Algorithms.Bloomberg;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // a - b = 从小到大排序； b - a = 从大到小排序
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] >= q.peek())
                q.poll();

            q.add(intervals[i][1]);
        }
        return q.size();
    }
}
