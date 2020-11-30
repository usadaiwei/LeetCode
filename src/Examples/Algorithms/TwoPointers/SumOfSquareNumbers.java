package Examples.Algorithms.TwoPointers;

/* Sum of Square Numbers (Easy)
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int target) {
        if (target < 0) return false;
        int small = 0, large = (int) Math.sqrt(target);
        while (small <= large){
            int sum = small * small + large * large;
            if (target == sum) return true;
            else if(target < sum)
                large --;
            else
                small ++;
        }
        return false;
    }
}
