package Examples.Algorithms.Bloomberg;

/*
A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti,
and the cost of flying the ith person to city b is bCosti.
Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

Example 1:
Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation:
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 */
import java.util.Arrays;

public class TwoCityScheduling {
    int total = 0;
    public int twoCitySchedCost(int[][] costs) {
        /* 前面a - 后面b = 从小到大排序； 后面b - 前面a = 从大到小排序
           这个例子就是 按照(b[1] - b[0]) 的值从大到小排序
         */
        Arrays.sort(costs, (a, b) ->((a[0] - a[1]) - (b[0] - b[1])));
        int sum = 0;
        int n = costs.length/2;

        for (int i = 0; i < n; i++){
            sum += costs[i][0];
        }

        for (int i = n; i < 2*n; i++){
            sum += costs[i][1];
        }

        return sum;
    }
}
/*
P       LostA
1:      -10
2:      -70
3:      350
4:      10

2,  1,  4,  3
A   A   B   B
*/