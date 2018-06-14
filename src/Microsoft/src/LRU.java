import java.util.*;
import java.util.HashMap;
public class LRU {
    /*
    combanation of hashmap and linkedlist. 
    everytime get or put something, put it into the head of the linkedlist, when cap is reached, evict the last, also in the hashmap.
    for put or get: if thing already in the hashmap, update its value. else put and check evciting. for get return value if exist, both move the element to the end of the list.
    for removing, remove both from the end of the linked list and from hashmap, get from node's key.
    linkedlist: insert: into next of sudo head.
    update to the last, get the node, remove it and insert into head
    map: <node's key : Node>
    DLL node: <key, value>
    
    */

    public int cap;
    public Map<Integer, DLL> map;
    public DLL head, tail;
    public LRU(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        head = new DLL(-1, -1);
        tail = new DLL(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public class DLL {
        int key, value;
        DLL prev, next;
        public DLL(int k, int v) {
            this.key = k;
            this.value = v;
            this.prev = null;
            this.next = null;
        }
    }
    
    public int get(int key) {
        DLL node = map.get(key);
        if(node == null) return -1;
        shiftToHead(node);
        return node.value;
    }
    
    private void shiftToHead(DLL node) {
        remove(node);
        insertHead(node);
    }
    
    private int remove(DLL node) {
        if(node == null) return -1;
        DLL next = node.next, prev = node.prev;
        prev.next = next;
        next.prev = prev;
        return node.key;
    }
    
    private void insertHead(DLL node) {
        if(node == null) return;
        DLL next = head.next;
        // insert to head. set prevouses also 
        // next.prev this
        // this.prev head
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DLL node = map.get(key);
            node.value = value;
            shiftToHead(node);
        } else {
            DLL node = new DLL(key, value);
            map.put(key, node);
            // not shift to head since the node is new, does not have prev and next, no need to del.
            insertHead(node);
            if(map.size() > cap) {
                int delKey = remove(tail.prev);
                map.remove(delKey);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */