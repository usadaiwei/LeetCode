package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.List;

/*
LeetCode 797
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 */
public class AllPathsFromSourceToTarget {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> temp = new ArrayList<>();
        dfs(0, temp, graph);
        return ans;
    }

    private void dfs(int current, List<Integer> temp, int[][] graph){
        temp.add(current);
        if (current == graph.length -1)
            ans.add(new ArrayList<Integer>(temp));
        for (int i : graph[current]){
            dfs(i, temp, graph);
            temp.remove(temp.size() - 1); // 回溯
        }

    }
}
