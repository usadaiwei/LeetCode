package Examples.Algorithms.Bloomberg;

import java.util.HashSet;
import java.util.Stack;

public class BrowserHistory {
    Stack<String> stack = new Stack<>();
    HashSet<String> set;
    public BrowserHistory(String homepage) {
        set = new HashSet<>(stack);
    }

    public void visit(String url) {
        stack.push(url);
    }
}
