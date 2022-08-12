package Examples.Algorithms.Bloomberg;
/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

 */
public class MultiplyStrings {

    //      1 2 3
    //      4 5 6
    //===========
    //      7 3 8
    //    6 1 5
    //  4 9 2
    //===========
    //  5 6 0 8 8

    public String multiply(String num1, String num2) {
        // Base case
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // which store the multiplaction of the number
        int[] result = new int[num1.length()+num2.length()];
        int mul = 0;

        // for loop starts
        for(int i = num1.length()-1; i >= 0; i--) {
            for(int j = num2.length()-1; j >= 0; j--) {

                mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 加上carry
                mul = mul + result[i+j+1];
                // 在前一个格子里存储此轮相乘的结果
                result[i+j+1] = mul%10;
                // 在当前储存carry
                result[i+j] = result[i+j] + mul/10;
            }
        } // for loop ends

        StringBuilder s = new StringBuilder();
        for(int i : result) {
            // 第一个如果没有carry就会是0，需要去除， 不加进StringBuilder里
            if(s.length()==0 && i==0) {
                continue;
            }
            s.append(i);
        }
        return s.toString();
    }
}
