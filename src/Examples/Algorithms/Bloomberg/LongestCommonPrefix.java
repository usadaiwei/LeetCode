package Examples.Algorithms.Bloomberg;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs); // 先sort, 再对比第一个和最后一个string
        char[] first = strs[0].toCharArray();
        char[] end = strs[strs.length-1].toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < first.length && i < end.length; i++){
            if (first[i] == end[i])
                sb.append(first[i]);
            else
                return sb.toString();
        }
        return sb.toString();
    }
}
