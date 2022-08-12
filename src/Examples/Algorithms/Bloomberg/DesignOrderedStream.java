package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.List;

/*
There is a stream of n (idKey, value) pairs arriving in an arbitrary order, where idKey is an integer between 1 and n and value is a string. No two pairs have the same id.

Design a stream that returns the values in increasing order of their IDs by returning a chunk (list) of values after each insertion. The concatenation of all the chunks should result in a list of the sorted values.

Implement the OrderedStream class:

OrderedStream(int n) Constructs the stream to take n values.
String[] insert(int idKey, String value) Inserts the pair (idKey, value) into the stream, then returns the largest possible chunk of currently inserted values that appear next in the order.

Example:

Input
["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
[[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]

Output
[null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]

 */
public class DesignOrderedStream {
    String[] stream;
    int ptr;

    public DesignOrderedStream(int n) {
        stream = new String[n];
        ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey-1] = value; // add new value
        List<String> ans = new ArrayList<>();
        for (int i = ptr; i < stream.length; i++){
            if (stream[i] == null)
                break;
            ans.add(stream[i]);
            ptr++; // ptr一定要++
        }
        return ans;
    }
}

