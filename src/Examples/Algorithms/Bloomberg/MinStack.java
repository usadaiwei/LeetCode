package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
 */
public class MinStack {
    ArrayList<Integer> list;

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
    }

    public void pop() {
        list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++)
            min = Math.min(min, list.get(i));

        return min;
    }
}
