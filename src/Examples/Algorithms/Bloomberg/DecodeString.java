package Examples.Algorithms.Bloomberg;
/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 */

public class DecodeString {
    int i = 0;

    public String decodeString(String s) {
        return decode(s);
    }

    private String decode(String s){
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        String str = "";

        while (i < s.length()){
            char c = s.charAt(i);
            i++;
            if (c == '['){
                str = decode(s); // recursive
                for (int j = 0; j < counter; j++){
                    sb.append(str);
                }
                counter = 0;
            } else if (c == ']')
                break;
            else if (Character.isAlphabetic(c)){
                sb.append(c);
            }
            else {
                counter = counter * 10 + c - '0';
            }
        }
        return sb.toString();
    }
}
