package Examples.Algorithms.Bloomberg;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long a = (long)dividend;
        long b = (long)divisor;

        if (a/b >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;       // key 1
        else if (a/b <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;       // key 2
        else
            return dividend/divisor;        // normal result
    }
}
