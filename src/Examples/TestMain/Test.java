package Examples.TestMain;


import Examples.Algorithms.Bloomberg.BankHours;
import Examples.Algorithms.Bloomberg.BinaryStringWithWildCards;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        int[][] costs = {{10, 20}, {30, 200}, {40, 500}, {30, 20}};
//        int[][] costs = {{20, 30}, {200, 30}, {500, 40}, {20, 30}};
        int[] cost = new int[]{5, 2, 4, 3, 1};
        System.out.println("It was: [10, 20], [30, 200], [40, 500], [30, 20]");
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        System.out.print("return (a[0] - a[1]) - (b[0] - b[1]) : ");
        for (int i = 0; i < costs.length; i++) {
            System.out.print("[");
            System.out.print(costs[i][0]);
            System.out.print(", ");
            System.out.print(costs[i][1]);
            System.out.print("] ");
        }
        System.out.println("");

        Arrays.sort(costs, (a, b) -> {
            return (a[1] - a[0]) - (b[1] - b[0]);
        });

        System.out.print("return (a[1] - a[0]) - (b[1] - b[0]) : ");
        for (int i = 0; i < costs.length; i++) {
            System.out.print("[");
            System.out.print(costs[i][0]);
            System.out.print(", ");
            System.out.print(costs[i][1]);
            System.out.print("] ");
        }
        System.out.println("");

        Arrays.sort(costs, (a, b) -> {
            return (b[0] - b[1]) - (a[0] - a[1]) ;
        });

        System.out.print("return (b[0] - b[1]) - (a[0] - a[1]) : ");
        for (int i = 0; i < costs.length; i++) {
            System.out.print("[");
            System.out.print(costs[i][0]);
            System.out.print(", ");
            System.out.print(costs[i][1]);
            System.out.print("] ");
        }
        System.out.println("");

        Arrays.sort(costs, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]) ;
        });

        System.out.print("return (b[1] - b[0]) - (a[1] - a[0]) : ");
        for (int i = 0; i < costs.length; i++) {
            System.out.print("[");
            System.out.print(costs[i][0]);
            System.out.print(", ");
            System.out.print(costs[i][1]);
            System.out.print("] ");
        }
        System.out.println("");
















//        Arrays.sort(cost);
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < cost.length; i++) {
//            stack.push(cost[i]);
//        }
//
//        for (int i = 0; i < cost.length; i++) {
//            int pop = stack.pop();
//            System.out.print(pop + ", ");
//        }
    }
}
