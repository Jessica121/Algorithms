import java.util.ArrayList;
import java.util.List;
public class HashMap<K, V> {
/*
 * HashMap is an array (arraylist) of unsync linkedlists of map nodes.
 * 1. Compute the hashcode of key : hashcode
 * 2. compute the index of the array using the hashcode by code % arr.length (what is the length?)
 * 3. put the (key, value) pair in the list
 * 
 * put, get, remove, size, containsKey
 * 
 * Get: for collision: compute the index like put, and iterate thru the list, with the pair's.key == key. return its value.
 * 
 * Worst case: O(K), K: number of keys. collide into one index.
 * 
 * Good implementation get is O(1), put O(1)
 * 
 * basically the operation on linkedlist: fixed sized linked list, check null pointers before iterating
 * put can only using set index, put if exist in map, head exist in map, node with same key in map, if not new node 
 * is the new head, set index.
 * get from index, head != null && head.key != key, iterate. if head = null, null; else head.key
 * remove same as get from index, head != null && head.key != key, record prev; if head == null, null, prev == null, first one, set index first.next
 * prev.next = head.next
 * 
 * https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
 * 
 * */
	
	List<Node<K, V>> buckets;
	int numOfBuckets; // need to calculate the index.
	int size; // to return isEmpty()
	public HashMap() {
		this.numOfBuckets = 16;
		this.buckets = new ArrayList<>();
		this.size = 0;
		for(int i = 0; i < numOfBuckets; i++) buckets.add(null);
	}
	
	// linked list add with unique key
	// non-existing, existing head but not in list, existing head and in the list(override)
	public void put(K key, V val) {
		int index = index(key);
		Node<K, V> head = buckets.get(index);
		Node<K, V> node = new Node<K, V>(key, val);
		// always set, not put directly. else will increase the num of buckets, the index will not be right.
		// another important thing is overrding an existing key value.
		// check already exist.
		while(head != null) {
			if(head.key.equals(key)) { // use equals for string as the key
				head.value = val;
				// return to break.
				return;
			}
			head = head.next;
		}
		// if not exist, append to the head of the linked list, eaiser to implement.
		// get the head again:
		head = buckets.get(index);
		node.next = head;
		buckets.set(index, node);
		size++;
		// System.out.println(buckets);
	}
	
	// linkedlist remove ; remove null, head, middle
	public V remove(K key) {
		int index = index(key);
		Node<K, V> head = buckets.get(index), prev = null;
		while(head != null && !head.key.equals(key)) {
			prev = head;
			head = head.next;
		}
		if(head == null) return null; // key not found. head is null no prev, prev always the tail
		else if(prev == null) buckets.set(index, head.next); // first is the key
		else prev.next = head.next;
		size--;
		return head.value;
	}
	
	// linkedlist get. get null get exist.
	public V get(K key) {
		int index = index(key);
		// below index >= buckets size will never happen as it is mod by it.. need a capacity for arraylist.
		// if(index >= buckets.size()) return null;
		Node<K, V> head = buckets.get(index);
		while(head != null && !head.key.equals(key)) {
			head = head.next;
		}
		return head == null ? null : head.value;
	}
	
	private int index(K key) {
		return key.hashCode() % numOfBuckets;
	}
	
//	public int hashCode() {
//		
//	}
	
	public static class Node<K, V> {
		V value;
		K key;
		Node<K, V> next;
		public Node(K key, V val) {
			this.key = key;
			this.value = val;
			this.next = null;
		}
		
		@Override
		public String toString() {
			return "(" + this.key + ", " + this.value + ")";
		}
	}
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
        map.put("this", 1);
        map.put("coder", 2);
        map.put("this", 4);
        map.put("hi", 5);
		System.out.println(map.get("this"));
		System.out.println(map.get("coder"));
		System.out.println(map.get("hi"));
		map.remove("this");
		System.out.println(map.get("this"));
	}
}
