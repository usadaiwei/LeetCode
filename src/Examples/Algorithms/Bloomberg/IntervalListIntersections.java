package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.List;

/*
986. Interval List Intersections
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
Each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;

        if (m == 0 || n == 0)
            return new int[][]{};

        int i = 0, j = 0; // i - A list index; j - B list index
        List<int[]> ans = new ArrayList<>();

        while (i < m && j < n){
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);

            if (start <= end){ // check if it is a valid interval
                ans.add(new int[]{start, end});
            }

            // compare next
            if (A[i][1] == end)
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][2]);
    }

}
