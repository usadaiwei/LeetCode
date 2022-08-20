package Examples.Algorithms.Bloomberg;

import java.util.*;

/*
692. Top K Frequent Words
Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

很重要!!!一定要牢记!!!
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 牢牢记住!!!
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().thenComparing(Map.Entry<String, Integer>::getKey));

        for (Map.Entry<String, Integer> m : map.entrySet()){
            q.offer(m);
        }

        while (k-- > 0)
            ans.add(q.poll().getKey());

        return ans;
    }
}
