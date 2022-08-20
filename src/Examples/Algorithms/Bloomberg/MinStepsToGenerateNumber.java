package Examples.Algorithms.Bloomberg;

import java.util.HashSet;
import java.util.Set;

/*
Bloomberg | Phone Screen | Min Steps to Generate Number
Given an int n. You can use only 2 operations:

multiply by 2
integer division by 3 (e.g. 10 / 3 = 3)
Find the minimum number of steps required to generate n from 1.

Example 1:

Input: 10
Output: 6
Explanation: 1 * 2 * 2 * 2 * 2 / 3 * 2
6 steps required, as we have used 5 multiplications by 2, and one division by 3.
Example 2:

Input: 3
Output: 7
Explanation: 1 * 2 * 2 * 2 * 2 * 2 / 3 / 3
7 steps required, as we have used 5 multiplications by 2 and 2 divisions by 3.
 */
public class MinStepsToGenerateNumber {

    public static int getMin(int n){
        int step = 0;
        Set<Integer> visited = new HashSet<>(); // value we tried so far

        int value = 1;
        visited.add(1);

        while (value != n){
            if (value == n){
                return step;
            }
            else if (!visited.contains(value/3) && value > n) {
                value = value / 3;
            }
            else {
                value = value * 2;
            }
            step++;
            visited.add(value);
        }
        return value == n ? step : -1;
    }

    public static void main(String[] args){
        int n = 7;

        int ans = getMin(n);

        System.out.println(ans);
    }
}
