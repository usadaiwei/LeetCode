package Examples.Algorithms.Bloomberg;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
341. Flatten Nested List Iterator
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

Implement the NestedIterator class:

NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
int next() Returns the next integer in the nested list.
boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.

Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 */
public class FlattenNestedListIterator {
    Queue<Integer> queue;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {

        for (NestedInteger n : nestedList){
            getContent(n);
        }
    }

    public void getContent(NestedInteger n){

        if (n.isInteger())
            queue.add(n.getInteger());
        else {
            List<NestedInteger> list = n.getList();
            for (NestedInteger nn : list)
                getContent(nn);
        }
    }

    public Integer next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return queue.size() > 0;
    }










public class NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger(){
         return false;
     }

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger(){
         return null;
     }

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return empty list if this NestedInteger holds a single integer
     public List<NestedInteger> getList(){
         return null;
     }
}
}