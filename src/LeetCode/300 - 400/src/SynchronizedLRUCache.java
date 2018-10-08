import java.util.*;
public class SynchronizedLRUCache {
	 /*
    insert(update and add), get, will require the node to be shifted into the head of the list. => remove the node and insert to head.
    use dll for quick remove and insertion.
    map:<key, node> for getting the node by key quickly and also for shifiting. also for deletion while the node to be deleted.
    after insert, check size. if > capa, remove the tail of the list, -> get the removed key, remove the entry in the map.
    node: key, val, for getting the node by key, check the map, return map.get(key).val or -1.
    and shift the node to the head of the list. since get can get the node.
    
    */

    private Map<Integer, DLL> map;
    private DLL sudoHead, sudoTail;
    private int cap;
    
    private class DLL {
        int key, val;
        DLL next, prev;
        public DLL(int k, int v) {
            this.key = k;
            this.val = v;
            this.next = null;
            this.prev = null;
        }
    }
    
    public SynchronizedLRUCache(int capacity) {
        this.cap = capacity;
        this.map = Collections.synchronizedMap(new HashMap<>());
        this.sudoHead = new DLL(-1, -1);
        this.sudoTail = new DLL(-1, -1);
        sudoHead.next = sudoTail;
        sudoTail.prev = sudoHead;
    }
    
    public int get(int key) {
    	synchronized(map) {
    		if(map.containsKey(key)) {
	            DLL node = map.get(key);
	            shiftToHead(node);
	            return node.val;
	        }
    	}
        return -1;
    }
    
    private synchronized int removeTail() {
        DLL remove = sudoTail.prev;
        remove.prev.next = sudoTail;
        sudoTail.prev = remove.prev;
        // return key not val. as the map is stored by key not value.
        return remove.key;
    }
    
    private synchronized void shiftToHead(DLL node) {
        remove(node);
        addToHead(node);
    }
    
    private synchronized void addToHead(DLL node) {
    	// pointer manipulation nothing gancy but be clear about who assign to who.
        DLL headNext = sudoHead.next;
        sudoHead.next = node;
        node.next = headNext;
        headNext.prev = node;
        node.prev = sudoHead;
    }
    
    private synchronized void remove(DLL node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void put(int key, int value) {
    	synchronized(map) {
    		if(map.containsKey(key)) {
	            DLL node = map.get(key);
	            node.val = value;
	            // update is shift to head.
	            shiftToHead(node);
	        } else {
	            DLL node = new DLL(key, value);
	            map.put(key, node);
	            // while add is add to head. not forget, or put into shift head!
	            addToHead(node);
	            if(map.size() > cap) {
	                int del = removeTail();
	                map.remove(del);
	            }
	        }
    	}

    }
}
