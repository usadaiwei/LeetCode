package Examples.DataStructures.String;
/*
Count Binary Substrings (Easy)
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 */
public class CountBinarySubstrings {
    public static int countBinarySubstrings(String s) {
        int preLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }
            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
}
