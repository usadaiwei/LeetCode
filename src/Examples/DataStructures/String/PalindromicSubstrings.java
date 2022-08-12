package Examples.DataStructures.String;

/*
Palindromic Substrings (Medium)
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubstrings {

    private static int count = 0;

    public static int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++){
            extendSubstrings(s, i, i);
            extendSubstrings(s, i, i+1);
        }
        return count;
    }

    private static void  extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
            count++;
        }
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "cba";
        int ans = countSubstrings("aaa");
        System.out.println(ans);
    }
}
