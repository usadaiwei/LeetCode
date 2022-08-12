package Examples.DataStructures.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Isomorphic Strings (Easy)
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (s.length() == 0 && t.length() == 0) {
            return true;
        } else if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>(s.length());
        Set<Character> set = new HashSet<>(t.length());
        char sChar;
        char tChar;
        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);
            if (!map.containsKey(sChar)) {
                if (set.contains(tChar)) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                    set.add(tChar);
                }
            } else {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isIsomorphic("abb", "egg"));
    }
}
