package Examples.Algorithms.SortingAndSearching;
/*
Input: 4
Output: 2
Input: 8
Output: 2
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 0, h = x;
        while (l < h){
            int m = l + (l + h)/2;
            int sqrt = x / m;
            if (m == sqrt) return m;
            else if (m > sqrt) h = m - 1;
            else l = m + 1;
        }
        return h;
    }
}
