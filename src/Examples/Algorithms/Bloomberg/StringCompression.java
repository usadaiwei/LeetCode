package Examples.Algorithms.Bloomberg;
/*
443. String Compression
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.



Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 */
public class StringCompression {
    public int compress(char[] chars) {
        int index = 0;
        int start = 0;
        while (start < chars.length){
            int end = start+1;
            while (end < chars.length && chars[end] == chars[start]){
                end++;
            }
            chars[index] = chars[start];
            index++;

            int count = end - start;
            if (count > 1){
                String s = "" + count; // 可能count > 10, 不能直接用char, 要用String
                for (char c : s.toCharArray()){
                    chars[index] = c;
                    index++;
                }
            }
            start = end; // 准备扫描下一个字母
        }
        return index;
    }
}
