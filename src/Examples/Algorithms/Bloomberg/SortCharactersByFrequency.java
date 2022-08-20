package Examples.Algorithms.Bloomberg;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
451. Sort Characters By Frequency
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
public class SortCharactersByFrequency {
    // 主要是HashMap的遍历， 和整个加入PriorityQueue并且排序
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(); // char, frequency
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); // key
        for (Map.Entry<Character, Integer> entry : map.entrySet()){ // key
            queue.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            int frequency = queue.peek().getValue();
            while (frequency > 0){
                sb.append(queue.peek().getKey());
                frequency--;
            }
            queue.remove();
        }

        return sb.toString();
    }
}
