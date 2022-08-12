package Examples.Algorithms.Bloomberg;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int ans = 0;
        for (char c : s.toCharArray()){
            switch (c){
                case 'I':
                    ans += 1;
                    break;
                case 'V':
                    ans += 5;
                    break;
                case 'X':
                    ans += 10;
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'C':
                    ans += 100;
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'M':
                    ans += 1000;
                    break;
            }
        }

        // 前面遍历的时候加过了, 所以要减两次
        if (s.contains("IV") || s.contains("IX"))
            ans -= 2;
        if (s.contains("XL") || s.contains("XC"))
            ans -= 20;
        if (s.contains("CD") || s.contains("CM"))
            ans -= 200;

        return ans;
    }
}
