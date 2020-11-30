package Examples.Algorithms.TwoPointers;

/* Valid Palindrome II (Easy)
*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s){
        for (int i = 0,  j = s.length() - 1; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int small, int large){
        while (small < large){
            if (s.charAt(small++) != s.charAt(large--))
                return false;
        }
        return true;
    }
}
