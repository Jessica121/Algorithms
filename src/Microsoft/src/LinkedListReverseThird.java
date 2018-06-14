
public class LinkedListReverseThird {
/*
 * Given a linked list, reverse every thrid element.
 * 
 * 1->2->3->4->5->6->7 into 3->1->2->6->4->5->7
 * 
 * do it iteratively, linkedlist pointers manipulation. prev, next save up.
 * 
 * cnt = 0 .. 2, first head is head, when cnt == 2, this node.next save to next, prev if not null next is node 
 * node.next = head, prev = node.
 * cnt = 0;
 * 
 * next iteration next = head. all over till the end. 
 * O(N) time, O(1) space
 * 
 * works for gap larger than three too. only need to save three nodes.
 * 
 * */
	
	public static Node reverseThird(Node head) {
		if(head == null) return null;
		Node node = head, prev = null, tail = null, ret = null;
		int cnt = 0;
		while(node != null) {
			Node next = node.next;
//			if condition is checking if cnt++ , then if not satisfy, still going to increase
			if(cnt == 0) {
				head = node;
				cnt++;
			} else if(cnt == 1) {
				tail = node;
				cnt++;
			} else {
				node.next = head;
				if(prev != null) prev.next = node;
				else {
					ret = node;
					prev = node;
				}
				prev = tail;
				cnt = 0;
			}
			node = next;
		}
		if(cnt != 0) prev.next = head;
		return ret;
	}
	
	public static class Node {
		int val;
		Node next;
		public Node(int v) {
			this.val = v;
			this.next = null;
		}
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head = reverseThird(head);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
