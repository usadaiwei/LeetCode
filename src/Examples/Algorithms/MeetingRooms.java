package Examples.Algorithms;

/*
Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... , determine if a person could attend all meetings.

For example,
Given [ [0, 30], [5, 10], [15, 20] ],
return false.
 */

import Examples.DataStructures.Interval;

import java.util.Arrays;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i-1].end > intervals[i].start)
                return false;
        return true;
    }
}