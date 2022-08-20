package Examples.TestMain;


import Examples.Algorithms.Bloomberg.BankHours;
import Examples.Algorithms.Bloomberg.BinaryStringWithWildCards;

import java.util.*;

public class SortTechniques {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // use comparator to sort hashmap in a PriorityQueue
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(Comparator.comparing(Map.Entry<String, Integer>::getValue)
                .reversed()
                .thenComparing(Map.Entry<String, Integer>::getKey));

        for (Map.Entry<String, Integer> m : map.entrySet()){
            q.offer(m);
        }

        // use comparator to sort an array in a PriorityQueue 把array[1]从小到大排序
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));



        // sort a list in descending order
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, Collections.reverseOrder());

    }
}
