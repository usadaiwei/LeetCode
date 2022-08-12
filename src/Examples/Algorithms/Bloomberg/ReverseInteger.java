package Examples.Algorithms.Bloomberg;

/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21

Constraints:

-231 <= x <= 231 - 1
 */
public class ReverseInteger {
    public int reverse(int x){
        long ans = 0; // 用 long

        while (x != 0){
            ans = ans * 10 + x % 10;
            x = x / 10;
        }

        // 因为constraints, 如果 ans >= Integer.MAX_VALUE 或者 ans <= Integer.MIN_VALUE, return x = 0;
        if (x <= Integer.MAX_VALUE && x >= Integer.MIN_VALUE)
            return (int)ans;
        else
            return 0;
    }
}
