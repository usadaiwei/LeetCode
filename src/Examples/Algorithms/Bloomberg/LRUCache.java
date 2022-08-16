package Examples.Algorithms.Bloomberg;

import java.util.HashMap;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 */
public class LRUCache {
    HashMap<Integer, DLLNode> map = new HashMap<>();
    int cap;
    DLLNode head = new DLLNode(-1, -1);
    DLLNode tail = new DLLNode(-1, -1); // The tail.prev is the least used node which will be removed first when size == capacity

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // 每次get, 都要把node挪到前面去, 放在head.next
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        else {
            DLLNode node = map.get(key);
            remove(node);
            addHead(node);
            map.put(key, node);
            return node.val;
        }
    }

    // 每次put新value, 都要把node挪到前面去, 放在head.next
    public void put(int key, int value) {

        if (!map.containsKey(key)) {
            DLLNode node = map.get(key);
            if (map.size() == cap)
                remove(tail.prev);
            addHead(new DLLNode(key, value));
        } else {
            DLLNode node = map.get(key);
            node.val = value;
            remove(node);
            addHead(node);
        }
    }

    public void remove(DLLNode node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addHead(DLLNode node) {
        map.put(node.key, node);
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }



    // Implement double linkedList Node
    public class DLLNode {
        public int key;
        public int val;

        public DLLNode prev;
        public DLLNode next;

        public DLLNode() {
        }

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
