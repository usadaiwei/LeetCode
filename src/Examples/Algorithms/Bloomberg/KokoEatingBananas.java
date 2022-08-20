package Examples.Algorithms.Bloomberg;

import java.util.Arrays;

/*
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Return the minimum integer k such that she can eat all the bananas within h hours.
Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int i = 1;
        int j = piles[piles.length-1];
        int ans = 0;
        int mid = 0;

        while (i <= j){
            mid = i + (j-i)/2;
            if (!canEat(piles, mid, h))
                i = mid + 1;
            else {
                ans = mid;  // 必须在这里传递ans的值， 否则会再次loop导致mid值改变
                j = mid - 1;
            }
        }

        return ans;
    }

    public boolean canEat(int[] piles, int count, int hours){ // key, 二分法的条件
        long needTime = 0;

        for (int pile: piles){
            needTime +=  (long)((pile/count) + ((pile%count > 0) ? 1 : 0));
        }

        return needTime <= (long)hours;
    }
}
