package Examples.DataStructures.String;

import java.util.HashMap;

/*
Longest Palindrome(Easy)
Input : "abccccdd"
Output : 7
Explanation : One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int odd = 0, even = 0;
        if (s == "" || s == null)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else
                map.put(c, 1);
        }
        for (int i = 0; i < s.length(); i++){
            int helper = map.get(s.charAt(i));
//            System.out.println(helper);
            if (helper % 2 == 0){
                even++;
            }else
                odd++;
        }
        if (odd != 0)
            odd = 1;
        else
            odd = 0;

        int ans = even + odd;

        return ans;
    }

    public static void main(String[] args){
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
