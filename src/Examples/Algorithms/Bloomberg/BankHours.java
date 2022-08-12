package Examples.Algorithms.Bloomberg;

import java.util.Arrays;

public class BankHours {
    public boolean check(int[] target, int[][] sum){
        Arrays.sort(sum, (a, b) -> a[0] - b[0]);
        int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE;
        for (int i = 0; i < sum.length; i++){
            if (target[0] >= start && target[1] <= end)
                return true;
            if (sum[i][0] > end) {
                start = sum[i][0];
                end = sum[i][1];
            } else
                end = Math.max(end, sum[i][1]);
        }
        return false;
    }
}
