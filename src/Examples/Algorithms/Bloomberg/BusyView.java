package Examples.Algorithms.Bloomberg;
/*
Given list of events of a given day in a calendar, write an algorithm to return a list of busy view time slots.
Busy view is created by the consolidating adjacent and overlapping event time slots without showing details of individual events.

Details: Each event in calendar has a start time, end time & some title.
Events can start at any minute (granularity at the minute only, no seconds).

Input: list of following events
(100,300, "Some Event")  // 1:00 am to 3:00 am
(115,145, "Some Event")
(145,215, "Some Event")
(200,400, "Some Event")
(215,230, "Some Event")
(215,415, "Some Event")
(600,700, "Some Event")
(500,600, "Some Event")

Output: Based on above events, my busy view should show like this:
(100,415) // Busy from 1am to 4:15 am
(500,700) // Busy from 5am to 7:00 am
 */

import java.util.List;

//public class BusyView {
//    public List<List<String>> merge(List<List<String>> events){
//
//    }
//}
