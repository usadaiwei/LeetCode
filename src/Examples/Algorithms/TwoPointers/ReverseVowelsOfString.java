package Examples.Algorithms.TwoPointers;

import java.util.Arrays;
import java.util.HashSet;

/* Reverse Vowels of a String (Easy)
Given s = "leetcode", return "leotcede".
 */
public class ReverseVowelsOfString {
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null) return null;

        int small = 0, large = s.length() - 1;
        char[] newString = new char[large + 1];

        while (small <= large) {
            char slarge = s.charAt(large);
            char ssmall = s.charAt(small);

            if (!vowels.contains(ssmall)) {
                newString[small] = ssmall;
                small++;
            } else if (!vowels.contains(slarge)) {
                newString[large] = slarge;
                large--;
            } else {
                newString[large] = ssmall;
                large--;
                newString[small] = slarge;
                small++;
            }
        }
        return new String(newString);
    }
}
