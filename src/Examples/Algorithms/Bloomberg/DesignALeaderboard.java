package Examples.Algorithms.Bloomberg;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Design a Leaderboard class, which has 3 functions:

addScore(playerId, score): Update the leaderboard by adding score to the given player's score. If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
top(K): Return the score sum of the top K players.
reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard). It is guaranteed that the player was added to the leaderboard before calling this function.
Initially, the leaderboard is empty.
 */
public class DesignALeaderboard {
    Map<Integer, Integer> players;  // Key - 玩家id， Value - 此玩家得分
    TreeMap<Integer, Integer> scores; // Key - 分数， Value - 此分数的个数， 用TreeMap因为它会sort， lastKey为最大Key值

    public DesignALeaderboard() {
        players = new HashMap<>();
        scores = new TreeMap<>();
    }

    public void addScore(int playerId, int score) {
        if (players.containsKey(playerId)){
            int oldScore = players.get(playerId);
            scores.put(oldScore, scores.get(oldScore) - 1);
            if (scores.get(oldScore) == 0) // 记得remove
                scores.remove(oldScore);
        }
        int newScore = players.getOrDefault(playerId, 0) + score;
        players.put(playerId, newScore);
        scores.put(newScore, scores.getOrDefault(newScore, 0) + 1);
    }

    public int top(int K) {
        int max = scores.lastKey(); // lastKey 为最大Key值
        int sum = 0;
        while (K > 0){
            int score = scores.floorKey(max); // floorKey 小于或等于 max的Key值
            int count = scores.get(score);
            int times = Math.min(count, K);
            sum += score * times;
            K -= times;
            max = score - 1;
        }
        return sum;
    }


    public void reset(int playerId) {
        int oldScore = players.get(playerId);
        scores.put(oldScore, scores.get(oldScore) - 1);
        if (scores.get(oldScore) == 0) // 记得remove
            scores.remove(oldScore);

        players.remove(playerId); // 记得remove
    }

}
