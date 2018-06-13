
public class LinkedListLastNNode {
	/*
	 * use two pointers, slow and fast to calculate the length as well as detect the cycle.
	 * 
	 * LinkedList: if a cycle exist.
	 * Pointer manipulation.
	 * Null pointer check before use next, prev, etc.
	 * 
	 * for each slow pointer advance, increase cnt, stop when:
	 * fast pointer == null : len = slow cnt * 2
	 * fast pointer.next == null len = slow cnt * 2
	 * if(fast == slow) return null, detect a cycle.
	 * 
	 * else get the len, and go thru len - n.
	 * also if n > len, return null
	 * */
	
	public static class Node {
		Node next;
		int val;
		public Node(int v) {
			this.val = v;
			this.next = null;
		}
	}
	
	// 1->2->3->4->null, n = 3
	public static Node nthNode(Node head, int n) {
		// it works when the list is null
		Node slow = head, fast = head;
		int cnt = 0, len = 0;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			cnt++;
			fast = fast.next.next;
			// has a cycle.
			if(fast == slow) return null; 
		}
		// if XOR condition, use else if.
		if(fast == null) len = cnt * 2;
		else if(fast.next == null) len = cnt * 2 + 1; // else if. when fast == null it is still going to check it.
		// if n larger than len, also error.
		if(n > len) return null;
		cnt = 0;
		// len - n from the end.
		while(cnt++ < len - n) head = head.next;
		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node node = head;
		for(int i = 2; i < 5; i++) {
			node.next = new Node(i);
			node = node.next;
		}
//		node.next = head;   // cycle check.
//		node = head;
//		while(node != null) {
//			System.out.print(node.val + " -> ");
//			node = node.next;
//		}
		System.out.println(nthNode(head, 3));

	}

}
